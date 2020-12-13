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

import com.gd.sep7us.fingerreaders.secugen.SecuGenJNILib;
import com.gd.utils.ByteFilesHandler;
import com.gd.utils.ImageUtil;

/**
 *
 * @author Julio Chinchilla
 */
public class WS0_ReadFinger {
    
    final static String f = "D:\\JConf2020\\fingers\\Read\\finger_";
    final static String tf = "ISO";
    
    public static void main(String... args) throws Exception{
        String ct = String.valueOf(System.currentTimeMillis());
        String TEM_PATH = f+ct+"."+tf;
        String IMG_PATH = f+ct+".jpg";
        //Inicio de lector biométrico
        SecuGenJNILib fr = new SecuGenJNILib(tf);
        System.out.println("template size: "+fr.getTemplate().length);
        ByteFilesHandler.writeFile(TEM_PATH, fr.getTemplate());
        ImageUtil.saveImageJPG(IMG_PATH, fr.getFingerprint()); 
    }
    
}
