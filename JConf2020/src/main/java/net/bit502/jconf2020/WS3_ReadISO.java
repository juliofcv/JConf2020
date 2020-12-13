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
import com.gd.bioutils.read.readISO19794;
import java.util.List;

/**
 *
 * @author Imotion Studio
 * 
 */
public class WS3_ReadISO {
    
    public static void main (String... args) throws Exception {
        readISO19794 iso = new readISO19794("D:\\JConf2020\\fingers\\finger_1606997650020.iso");
        System.out.println("Total Records: " +iso.getTotalRecords());
        System.out.println("equipmentCertification: " +iso.getEquipmentCertification());
        System.out.println("captureDeviceID: " +iso.getCaptureDeviceID());
        System.out.println("image size in X: " +iso.getImageSizeX());
        System.out.println("image size in Y: " +iso.getImageSizeY());
        System.out.println("X Resolution: " +iso.getXRes());
        System.out.println("Y Ressolution: " +iso.getYRes());
        System.out.println("Number Finger View: " +iso.getNumberFingerView());
        System.out.println("Finger Position: " +iso.getFingerPosition());
        System.out.println("Impression Type: " +iso.getImpressionType());
        System.out.println("Finger Quality: " +iso.getFingerQuality());
        System.out.println("Number of Minutiae: " +iso.getNumMinutiae());
        List<Minutiae> minutiaeData = iso.getMinutiaeData();
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
