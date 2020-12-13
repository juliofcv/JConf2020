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
public class Minutiae {
    
    private int X;
    private int Y;
    private int Type;
    private float Angle;
    private int Quality;

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public float getAngle() {
        return Angle;
    }

    public void setAngle(float Angle) {
        this.Angle = Angle;
    }

    public int getQuality() {
        return Quality;
    }

    public void setQuality(int Quality) {
        this.Quality = Quality;
    }
    
}