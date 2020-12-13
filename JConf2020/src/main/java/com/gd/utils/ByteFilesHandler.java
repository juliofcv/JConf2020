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

package com.gd.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Julio Chinchilla
 */
public class ByteFilesHandler {
    
    public static byte[] readFile (String fd) throws FileNotFoundException, IOException {
        File fileDir = new File(fd);
        byte[] result = new byte[(int)fileDir.length()];
        FileInputStream fis = new FileInputStream(fileDir);
        InputStream input = new BufferedInputStream(fis);
        int totalBytesRead = 0;
        while(totalBytesRead < result.length) {
            int bytesRemaining = result.length - totalBytesRead;
            int bytesRead = input.read(result, totalBytesRead, bytesRemaining); 
            if (bytesRead > 0) {
                totalBytesRead = totalBytesRead + bytesRead;
            }
        }
       return result;
    }
    
    /**
     * 
     * @param fd
     * @param fileBin
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void writeFile (String fd, byte [] fileBin) throws FileNotFoundException, IOException {
        File fileDir = new File(fd);
        if(fileBin!=null || fileBin.length!=0) {
            FileOutputStream fos = new FileOutputStream(fileDir);
            if (!fileDir.exists()) {
                fileDir.createNewFile();
            } 
            fos.write(fileBin);
            fos.flush();
            fos.close();
        }
    }

}