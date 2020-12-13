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

package com.gd.sep7us.fingerreaders.secugen;

import SecuGen.FDxSDKPro.jni.*;
import com.gd.sep7us.fingerreaders.entity.FingerData;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author Julio Chinchilla
 */
public class SecuGenJNILib extends FingerData {
    
    public SecuGenJNILib (String templateFormat) throws Exception {
        SecuGenFingerCapture(templateFormat);
    }
    
    private synchronized void SecuGenFingerCapture (String templateFormat) throws Exception {
        long err; 
        short template;
        if (templateFormat.equals("ISO")) {
            System.out.println("selectd iso");
            template = SGFDxTemplateFormat.TEMPLATE_FORMAT_ISO19794;
        } else if (templateFormat.equals("ANSI")) {
            System.out.println("selectd ansi");
            template = SGFDxTemplateFormat.TEMPLATE_FORMAT_ANSI378;
        } else {
            template = SGFDxTemplateFormat.TEMPLATE_FORMAT_SG400;
        }        
        JSGFPLib sgfplib = new JSGFPLib();
        SGDeviceInfoParam deviceInfo = new SGDeviceInfoParam();
        byte[] imageBuffer1;
        int[] quality = new int[1];
        int[] maxSize = new int[1];
        int[] size = new int[1];
        byte[] MinutiaeBuffer1;
        SGFingerInfo fingerInfo = new SGFingerInfo();
        if ((sgfplib != null) && (sgfplib.jniLoadStatus != SGFDxErrorCode.SGFDX_ERROR_JNI_DLLLOAD_FAILED)) {
            err = sgfplib.Init(SGFDxDeviceName.SG_DEV_FDU03);
        if (err != 0) {
            throw new Exception("Secugen error 0x"+err+": "+SecuGenErrorList.getErrMessage(err));
        } else {
            err = sgfplib.OpenDevice(SGPPPortAddr.USB_AUTO_DETECT);
            err = sgfplib.GetLastError();        
            err = sgfplib.GetDeviceInfo(deviceInfo);        
            fingerInfo.FingerNumber = SGFingerPosition.SG_FINGPOS_UK;
            fingerInfo.ImageQuality = quality[0];
            err = sgfplib.SetBrightness(0);       
            fingerInfo.ImpressionType = SGImpressionType.SG_IMPTYPE_LP;
            fingerInfo.ViewNumber = 1;                  
            err = sgfplib.SetLedOn(true);         
            imageBuffer1 = new byte[deviceInfo.imageHeight*deviceInfo.imageWidth];
            BufferedImage originalImage = new BufferedImage(deviceInfo.imageWidth, deviceInfo.imageHeight, BufferedImage.TYPE_BYTE_GRAY);
            imageBuffer1 = ((java.awt.image.DataBufferByte) originalImage.getRaster().getDataBuffer()).getData();
            err = sgfplib.GetImage(imageBuffer1);
            if (err == SGFDxErrorCode.SGFDX_ERROR_NONE) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( originalImage, "jpg", baos );
                baos.flush();
                setFingerprint(baos.toByteArray());
                baos.close();
                int dvimw = deviceInfo.imageWidth;
                int dvimh = deviceInfo.imageHeight;
                err = sgfplib.GetImageQuality(dvimw, dvimh, imageBuffer1, quality);            
                err = sgfplib.SetTemplateFormat(template);
                err = sgfplib.GetMaxTemplateSize(maxSize);
                MinutiaeBuffer1 = new byte[maxSize[0]];
               
                err = sgfplib.CreateTemplate(fingerInfo, imageBuffer1, MinutiaeBuffer1);
                err = sgfplib.GetTemplateSize(MinutiaeBuffer1, size);
                byte[] templateMinutiae = new byte[size[0]];
                System.arraycopy(MinutiaeBuffer1,0,templateMinutiae,0,size[0]);
                if (err == SGFDxErrorCode.SGFDX_ERROR_NONE) {
                    System.out.println("Size template: "+templateMinutiae.length);
                    System.out.println("template: "+template);
                    if (template == SGFDxTemplateFormat.TEMPLATE_FORMAT_ISO19794) {
                        setTemplate(templateMinutiae);
                    } else if (template == SGFDxTemplateFormat.TEMPLATE_FORMAT_ANSI378) {
                        setTemplate(templateMinutiae);
                    }
                }
            System.out.println("err: "+err);
            } else {
                err = sgfplib.SetLedOn(false);
                err = sgfplib.CloseDevice();
                sgfplib.Close();
                throw new Exception("NO HUBO CAPTURA DE HUELLA DACTILAR, ES NECESARIO COLOCAR EL DEDO CORRECTAMENTE!\nSecugen error 0x"+err+" : "+SecuGenErrorList.getErrMessage(err));
                }
            err = sgfplib.SetLedOn(false);
            err = sgfplib.CloseDevice();
            sgfplib.Close();
            }
        } else {
            throw new Exception("Secugen error: JNI DLL Load failed");
        }       
    }
    
}