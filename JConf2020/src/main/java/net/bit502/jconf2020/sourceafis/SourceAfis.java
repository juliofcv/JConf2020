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

import com.machinezoo.sourceafis.FingerprintCompatibility;
import com.machinezoo.sourceafis.FingerprintImage;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import com.machinezoo.sourceafis.FingerprintTransparency;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Julio Chinchilla
 */
public class SourceAfis {
    
    public static boolean FingerTemplateMatch(byte[] templateProbe, byte[] templateCandidate, double threshold) throws IOException {
        FingerprintTemplate probe = FingerprintCompatibility.convert(templateProbe);
        FingerprintTemplate candidate = FingerprintCompatibility.convert(templateCandidate);
        double score = new FingerprintMatcher().index(probe).match(candidate);
        return score >= threshold;
    }
    
    public static byte[] extractMinutiae (byte[] fingerImage) throws FileNotFoundException, IOException {
        FingerprintTemplate p = new FingerprintTemplate(new FingerprintImage().dpi(500).decode(fingerImage));
        return FingerprintCompatibility.toAnsiIncits378v2004(p);
    }
    
    
    
    public static void TransparencyData (byte[] templateProbe, byte[] templateCandidate) throws FileNotFoundException, IOException {
        FingerprintTemplate p = new FingerprintTemplate(new FingerprintImage().dpi(500).decode(templateProbe));
        FingerprintTemplate c = new FingerprintTemplate(new FingerprintImage().dpi(500).decode(templateCandidate));
        try (
                OutputStream stream = new FileOutputStream("D:\\JConf2020\\fingers\\transparency.zip");
                FingerprintTransparency transparency = FingerprintTransparency.zip(stream)
            ) {
                
                new FingerprintMatcher().index(p).match(c);
            }
    }
    
}

