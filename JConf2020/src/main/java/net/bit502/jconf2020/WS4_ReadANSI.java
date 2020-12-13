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

import com.gd.bioutils.entity.Minutiae;
import com.gd.bioutils.read.readANSI378v2004;
import java.util.List;

/**
 *
 * @author Julio Chinchilla
 * 
 */
public class WS4_ReadANSI {
    
    public static void main (String... args) throws Exception {
        readANSI378v2004 ansi = new readANSI378v2004("D:\\JConf2020\\fingers\\finger_1607104586163.ANSI");
        System.out.println("Total Records: " +ansi.getTotalRecords());
        System.out.println("equipmentCertification: " +ansi.getEquipmentCertification());
        System.out.println("captureDeviceID: " +ansi.getCaptureDeviceID());
        System.out.println("image size in X: " +ansi.getImageSizeX());
        System.out.println("image size in Y: " +ansi.getImageSizeY());
        System.out.println("X Resolution: " +ansi.getXRes());
        System.out.println("Y Ressolution: " +ansi.getYRes());
        System.out.println("Number Finger View: " +ansi.getNumberFingerView());
        System.out.println("Finger Position: " +ansi.getFingerPosition());
        System.out.println("Impression Type: " +ansi.getImpressionType());
        System.out.println("Finger Quality: " +ansi.getFingerQuality());
        System.out.println("Number of Minutiae: " +ansi.getNumMinutiae());
        List<Minutiae> minutiaeData = ansi.getMinutiaeData();
        for(Minutiae min: minutiaeData) {
            System.out.println(" ------------------- ");
            System.out.println("Type: " + min.getType());
            System.out.println("Quality: " + min.getQuality());
            System.out.println("X: " + min.getX());
            System.out.println("Y: " + min.getY());
            System.out.println("Angle: " + min.getAngle());
        }
    }
    
}
