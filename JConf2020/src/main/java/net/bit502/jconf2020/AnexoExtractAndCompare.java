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
import com.gd.bioutils.entity.Minutiae;
import com.gd.bioutils.read.readANSI378v2004;
import com.gd.sep7us.fingerreaders.secugen.SecuGenJNILib;
import com.gd.utils.ByteFilesHandler;
import static com.gd.utils.ByteFilesHandler.readFile;
import com.gd.utils.ImageUtil;
import java.io.PrintWriter;

/**
 *
 * @author Julio Chinchilla
 */
public class AnexoExtractAndCompare {
    
    final static String f = "D:\\JConf2020\\fingers\\MinutiaeExtract\\";
    final static String tf = "ANSI";
    
    public static void main(String... args) throws Exception{
        //Tiempo actual para distinguir los archivos
        String ct = String.valueOf(System.currentTimeMillis());
        //Paths de guardado
        String TEM_PATH_0 = f+"SecuGen"+ct+"."+tf;
        String TEM_PATH_1 = f+"SourceAfis"+ct+"."+tf;
        String IMG_PATH = f+ct+".jpg";
        String LOG_ANSI0 = f+"SecuGen"+ct+".txt";
        String LOG_ANSI1 = f+"SourceAfis"+ct+".txt";
        //Inicio de lector biométrico
        
        SecuGenJNILib fr = new SecuGenJNILib(tf);
        
        
        ImageUtil.saveImageJPG(IMG_PATH, fr.getFingerprint());
        ByteFilesHandler.writeFile(TEM_PATH_0, fr.getTemplate());
        
        byte[] ansiSF = SourceAfis.extractMinutiae(readFile(IMG_PATH));
        ByteFilesHandler.writeFile(TEM_PATH_1,  ansiSF);
        
        readANSI378v2004 ansi_0 = new readANSI378v2004(fr.getTemplate());
        readANSI378v2004 ansi_1 = new readANSI378v2004(ansiSF);
        
        PrintWriter writer0 = new PrintWriter(LOG_ANSI0, "UTF-8");
        for(Minutiae min: ansi_0.getMinutiaeData()) {
            writer0.println(" ------------------- ");
            writer0.println("Type: " + min.getType());
            writer0.println("Quality: " + min.getQuality());
            writer0.println("X: " + min.getX());
            writer0.println("Y: " + min.getY());
            writer0.println("Angle: " + min.getAngle());
        }
        writer0.close();
        PrintWriter writer1 = new PrintWriter(LOG_ANSI1, "UTF-8");
        for(Minutiae min: ansi_1.getMinutiaeData()) {
            writer1.println(" ------------------- ");
            writer1.println("Type: " + min.getType());
            writer1.println("Quality: " + min.getQuality());
            writer1.println("X: " + min.getX());
            writer1.println("Y: " + min.getY());
            writer1.println("Angle: " + min.getAngle());
        }
         writer1.close();
    }
    
    
    
}
