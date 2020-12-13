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


package com.gd.sep7us.fingerreaders.entity;

/**
 *
 * @author Julio Chinchilla
 */
public abstract class FingerData {
    
    private byte[] Template;
    
    private byte[] Fingerprint;

    public byte[] getTemplate() {
        return Template;
    }

    protected void setTemplate(byte[] Template) {
        this.Template = Template;
    }

    public byte[] getFingerprint() {
        return Fingerprint;
    }

    protected void setFingerprint(byte[] Image) {
        this.Fingerprint = Image;
    }
    
}
