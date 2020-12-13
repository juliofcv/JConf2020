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

import com.gd.bioutils.entity.ISO19794;
import com.gd.bioutils.entity.Minutiae;
import com.gd.utils.ByteFilesHandler;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Chinchilla
 */
public final class readISO19794 extends ISO19794 {
    
    private byte[] iso19794T;
    private final static byte LM = 0x06;
    private final static float ANGLE_RESOLUTION = 1.40625f;
    
    public readISO19794 (String fingerFile) throws IOException, Exception {
        iso19794T = ByteFilesHandler.readFile(fingerFile);
        readTemplate();
    }
    
    public readISO19794 (byte[] iso19794T) throws Exception {
        this.iso19794T = iso19794T;
        readTemplate();
    }
    
    private void readTemplate() throws Exception {
        checkTemplate(iso19794T);
        //One per Rec-ord
        byte[] versionStandar = {iso19794T[0x04], iso19794T[0x05], iso19794T[0x06], iso19794T[0x07]};
        byte[] totalRecords   = {iso19794T[0x08], iso19794T[0x09], iso19794T[0x0A], iso19794T[0x0B]};
        setVersionStandard( DWORDToInt(versionStandar)  );
        setTotalRecords( DWORDToInt(totalRecords) );
        setEquipmentCertification((iso19794T[0x0C] >> 4) & 0xFF);
        setCaptureDeviceID((iso19794T[0x0C] & 0x0F) | (iso19794T[0x0D] & 0xFF));
        setImageSizeX( (iso19794T[0x0E] & 0xFF) << 8 | (iso19794T[0x0F] & 0xFF) );
        setImageSizeY( (iso19794T[0x10] & 0xFF) << 8 | (iso19794T[0x11] & 0xFF) );
        setXRes( (iso19794T[0x12] & 0xFF) << 8 | (iso19794T[0x13] & 0xFF) );
        setYRes( (iso19794T[0x14] & 0xFF) << 8 | (iso19794T[0x15] & 0xFF) );
        setNumberFingerView(iso19794T[0x16] & 0xFF);
        setReservedByte(iso19794T[0x17] & 0xFF);
        //One per View
        setFingerPosition(iso19794T[0x18] & 0xFF);
        setViewNumber((iso19794T[0x19] >> 4) & 0xFF);
        setImpressionType(iso19794T[0x19] & 0x0F);
        setFingerQuality(iso19794T[0x1A] & 0xFF);
        setNumMinutiae(iso19794T[0x1B] & 0xFF);
        //One per minu-tiae
        List<Minutiae> minutiaeData = new ArrayList();
        for(int i =0; i < getNumMinutiae()*LM; i+=LM) { //LM por el número de saltos entre bytes
            Minutiae minutia = new Minutiae();
            minutia.setType((iso19794T[0x1C+i]>>6)&0x03);
            minutia.setX( (iso19794T[0x1C+i]&0x3F) | iso19794T[0x1D+i] & 0xFF );
            minutia.setY((iso19794T[0x1E+i]&0xFF) << 8 | (iso19794T[0x1F+i] & 0xFF));
            minutia.setAngle(((iso19794T[0x20+i] & 0xFF) * ANGLE_RESOLUTION));
            minutia.setQuality(iso19794T[0x21+i] & 0xFF);
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
    
    private static int DWORDToInt (byte[] b) throws Exception {
        if (b.length != 4)
            throw new Exception("Error de precisión en la data, su tamaño es distinto de 4 bytes");
        return (ByteBuffer.wrap(b).order(ByteOrder.BIG_ENDIAN).getInt() & 0xFFFFFFFF);
    }
    
}