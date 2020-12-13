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

package com.gd.bioutils.read;

import com.gd.bioutils.entity.ANSI378;
import com.gd.bioutils.entity.Minutiae;
import com.gd.utils.ByteFilesHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Chinchilla
 */
public final class readANSI378v2004 extends ANSI378 {
    
    private byte[] ansi378T;
    private final static byte LM = 0x06;
    private final static float ANGLE_RESOLUTION = 2;
    
    public readANSI378v2004 (String fd) throws IOException, Exception {
        ansi378T = ByteFilesHandler.readFile(fd);
        readTemplate();
    }
    
    public readANSI378v2004 (byte[] ansi378T) throws Exception {
        this.ansi378T = ansi378T;
        readTemplate();
    }
    
    private void readTemplate() throws Exception {
        checkTemplate(ansi378T);
        //One per Rec-ord
        setVersionStandard((ansi378T[0x04] & 0xFF) << 0x18 | (ansi378T[0x05] & 0xFF) << 0x10 | 
                            (ansi378T[0x06] & 0xFF) << 0x08 | (ansi378T[0x07] & 0xFF) );
        setTotalRecords((ansi378T[0x08] & 0xFF) << 0x28 | (ansi378T[0x09] & 0xFF) << 0x20 |
                         (ansi378T[0x0A] & 0xFF) << 0x18 | (ansi378T[0x0B] & 0x10) | 
                         (ansi378T[0x0C] & 0x08) | (ansi378T[0x0D] & 0xFF));
        
        setCBEFFProductIdentifier((ansi378T[0x0E] & 0xFF) << 0x18 | (ansi378T[0x0F] & 0x10) | 
                         (ansi378T[0x10] & 0x08) | (ansi378T[0x11] & 0xFF));

        //Capture Equipment Compilance 4 bits (0x12 & 0xF0 )
        //Capture Equipment ID 12 bits (0x12 & 0x0F 4 & 0x13)
        
        setImageSizeX((ansi378T[0x10] & 0xFF) << 8 | (ansi378T[0x11] & 0xFF) );
        setImageSizeY((ansi378T[0x12] & 0xFF) << 8 | (ansi378T[0x13] & 0xFF) );
        setXRes((ansi378T[0x14] & 0xFF) << 8 | (ansi378T[0x15] & 0xFF) );
        setYRes((ansi378T[0x16] & 0xFF) << 8 | (ansi378T[0x17] & 0xFF) );        
        setNumberFingerView(ansi378T[0x18] & 0xFF);
        setReservedByte(ansi378T[0x19] & 0xFF);
        //One per Finger View
        setFingerPosition(ansi378T[0x1A] & 0xFF);
        setViewNumber((ansi378T[0x1B] >> 4) & 0xFF);
        setImpressionType(ansi378T[0x1B] & 0x0F);
        setFingerQuality(ansi378T[0x1C] & 0xFF);
        setNumMinutiae(ansi378T[0x1D] & 0xFF);
        //One per minu-tiae
        List<Minutiae> minutiaeData = new ArrayList();
        for(int i =0; i < getNumMinutiae()*LM; i+=LM) {
            Minutiae minutia = new Minutiae();
            minutia.setType((ansi378T[0x1E+i]>>6)&0x03);
            minutia.setX((ansi378T[0x1E+i]&0x3F) | ansi378T[0x1F+i] & 0xFF );
            minutia.setY((ansi378T[0x20+i]&0xFF) << 8 | (ansi378T[0x21+i] & 0xFF));
            minutia.setAngle(((ansi378T[0x22+i] & 0xFF) * ANGLE_RESOLUTION));
            minutia.setQuality(ansi378T[0x23+i] & 0xFF);
            minutiaeData.add(minutia);
        }
        setMinutiaeData(minutiaeData);
    }
    
    private void checkTemplate(byte[] data) throws Exception {
       byte[] magic = new byte[4];
       System.arraycopy(data, 0, magic, 0, 4);
       for (int k = 0; k < magic.length; k++) 
           if(magic[k] != formatIdentifier[k])
               throw new Exception("Los datos no corresponden a una plantilla ISO-19794");
    }
    
}