/* 
 * JConf 2020
 * 12/12/2020
 *
 * Copyright 2013-2020 GIGADATTA, S.A.
 * Julio Francisco Chinchilla Valenzuela
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package net.bit502.jconf2020.sourceafis;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;

public class UserDetails {
    
    public String name;
    public FingerprintTemplate template;
    
    
    public UserDetails find(FingerprintTemplate probe, Iterable<UserDetails> candidates) {
        FingerprintMatcher matcher = new FingerprintMatcher().index(probe);
        UserDetails match = null;
        double high = 0;
        for (UserDetails candidate : candidates) {
            double score = matcher.match(candidate.template);
            if (score > high) {
                high = score;
                match = candidate;
            }
        }
        double threshold = 40;
        return high >= threshold ? match : null;
    }
}