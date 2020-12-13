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
package net.bit502.jconf2020;

import net.bit502.jconf2020.sourceafis.SourceAfis;
import java.io.IOException;

/**
 *
 * @author Julio Chinchilla
 */
public class WS1_Matching1_1 {
    
    public static void main (String... args) throws IOException {
        byte f1[] = com.gd.utils.ByteFilesHandler.readFile("D:\\JConf2020\\fingers\\finger_1607003177839.ANSI");
        byte f2[] = com.gd.utils.ByteFilesHandler.readFile("D:\\JConf2020\\fingers\\finger_1607003225643.ANSI");
        if(SourceAfis.FingerTemplateMatch(f1, f2, 50))
            System.out.println("MATCH OK");
        else
            System.out.println("NO match");
    }
    
}
