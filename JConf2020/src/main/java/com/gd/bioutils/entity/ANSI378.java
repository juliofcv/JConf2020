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

package com.gd.bioutils.entity;

import java.util.List;

/**
 *
 * @author Julio Chinchilla
 */
public abstract class ANSI378 {
    
    protected final byte[] formatIdentifier = {(byte)0x46,(byte)0x4D,(byte)0x52,(byte)0x00};
    private int versionStandard;
    private int totalRecords;
    private int CBEFFProductIdentifier;
    private int equipmentCertification;
    private int captureDeviceID;
    private int imageSizeX;
    private int imageSizeY;
    private int XRes;
    private int YRes;
    private int numberFingerView;
    private int reservedByte;
    private int fingerPosition;
    private int viewNumber;
    private int impressionType;
    private int fingerQuality;
    private int  NumMinutiae;
    private List<Minutiae> MinutiaeData;

    public int getVersionStandard() {
        return versionStandard;
    }

    public void setVersionStandard(int versionStandard) {
        this.versionStandard = versionStandard;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getCBEFFProductIdentifier() {
        return CBEFFProductIdentifier;
    }

    public void setCBEFFProductIdentifier(int CBEFFProductIdentifier) {
        this.CBEFFProductIdentifier = CBEFFProductIdentifier;
    }

    public int getEquipmentCertification() {
        return equipmentCertification;
    }

    public void setEquipmentCertification(int equipmentCertification) {
        this.equipmentCertification = equipmentCertification;
    }

    public int getCaptureDeviceID() {
        return captureDeviceID;
    }

    public void setCaptureDeviceID(int captureDeviceID) {
        this.captureDeviceID = captureDeviceID;
    }

    public int getImageSizeX() {
        return imageSizeX;
    }

    public void setImageSizeX(int imageSizeX) {
        this.imageSizeX = imageSizeX;
    }

    public int getImageSizeY() {
        return imageSizeY;
    }

    public void setImageSizeY(int imageSizeY) {
        this.imageSizeY = imageSizeY;
    }

    public int getXRes() {
        return XRes;
    }

    public void setXRes(int XRes) {
        this.XRes = XRes;
    }

    public int getYRes() {
        return YRes;
    }

    public void setYRes(int YRes) {
        this.YRes = YRes;
    }

    public int getNumberFingerView() {
        return numberFingerView;
    }

    public void setNumberFingerView(int numberFingerView) {
        this.numberFingerView = numberFingerView;
    }

    public int getReservedByte() {
        return reservedByte;
    }

    public void setReservedByte(int reservedByte) {
        this.reservedByte = reservedByte;
    }

    public int getFingerPosition() {
        return fingerPosition;
    }

    public void setFingerPosition(int fingerPosition) {
        this.fingerPosition = fingerPosition;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }

    public int getImpressionType() {
        return impressionType;
    }

    public void setImpressionType(int impressionType) {
        this.impressionType = impressionType;
    }

    public int getFingerQuality() {
        return fingerQuality;
    }

    public void setFingerQuality(int fingerQuality) {
        this.fingerQuality = fingerQuality;
    }

    public int getNumMinutiae() {
        return NumMinutiae;
    }

    public void setNumMinutiae(int NumMinutiae) {
        this.NumMinutiae = NumMinutiae;
    }

    public List<Minutiae> getMinutiaeData() {
        return MinutiaeData;
    }

    public void setMinutiaeData(List<Minutiae> MinutiaeData) {
        this.MinutiaeData = MinutiaeData;
    }

}