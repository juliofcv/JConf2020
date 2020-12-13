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

/**
 *
 * @author Julio Chinchilla
 */
public abstract class FingerData {
    
    private byte[] RAWData;
    private byte[] ISO19794;
    private byte[] Fingerprint;

    public byte[] getRAWData() {
        return RAWData;
    }

    public void setRAWData(byte[] RAWData) {
        this.RAWData = RAWData;
    }

    public byte[] getISO19794() {
        return ISO19794;
    }

    public void setISO19794(byte[] ISO19794) {
        this.ISO19794 = ISO19794;
    }

    public byte[] getFingerprint() {
        return Fingerprint;
    }

    public void setFingerprint(byte[] Fingerprint) {
        this.Fingerprint = Fingerprint;
    }
    
}