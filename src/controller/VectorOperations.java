/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import model.Vector;

/**
 *
 * @author Laptop
 */
public class VectorOperations extends ShapeOperations{
    private Vector vector;
    
    public VectorOperations(Vector vector){
        this.vector = vector;
        super.selectShape(false);
    }
    
    public void draw(Graphics g){
        int x = (int)vector.getXCoordinate();
        int y = (int)vector.getYCoordinate();
        g.drawLine(290, 290, 290+x, 290-y);
    }
    public void shear(double factor, boolean isXShear){
        if(isXShear){//x' = x + ay
            this.vector.setXCoordinate(this.vector.getXCoordinate() + (int)(factor * this.vector.getYCoordinate()));
        }else{// y' = y + ax
            this.vector.setYCoordinate(this.vector.getYCoordinate() + (int)(factor * this.vector.getXCoordinate()));
        }
    }
    public void rotate(double angle){
        if(angle >= 0){
        // x' = xcos(rad)-ysin(rad)
        //y' = xsin(rad)+ycos(rad)
            angle = Math.toRadians(angle);
            this.vector.setXCoordinate((int)(this.vector.getXCoordinate() * Math.cos(angle)) - (int)(this.vector.getYCoordinate()  * Math.sin(angle)));
            this.vector.setYCoordinate((int)(this.vector.getXCoordinate() * Math.sin(angle)) + (int)(this.vector.getYCoordinate()  * Math.cos(angle)));
        }else{
        // x' = xcos(rad)+ysin(rad)
        //y' = x(-sin(rad) + ycos(rad)
            angle = Math.toRadians(angle);
            this.vector.setXCoordinate((this.vector.getXCoordinate() * (int)Math.cos(angle)) + (this.vector.getYCoordinate()  * (int)Math.sin(angle)));
            this.vector.setYCoordinate(this.vector.getXCoordinate() * ((int)Math.sin(angle) * -1) + (this.vector.getYCoordinate()  * ((int)Math.cos(angle) * -1)));
        }
    }
    public void translate(double x, double y){
        this.vector.setXCoordinate(this.vector.getXCoordinate()+(int)x);
        this.vector.setYCoordinate(this.vector.getYCoordinate()+(int)y);
        
    }
    public void dilate(double factor, boolean isVerticalDilate){
        this.vector.setXCoordinate(this.vector.getXCoordinate()*(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()*(int)factor);
    }
    public void contract(double factor){
        
        this.vector.setXCoordinate(this.vector.getXCoordinate()/(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()/(int)factor);
    }
    public void uniformScale(double factor){
        this.vector.setXCoordinate(this.vector.getXCoordinate()*(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()*(int)factor);
    }
    public void nonUniformScale(double factor, boolean isVerticalScale){
        this.vector.setXCoordinate(this.vector.getXCoordinate()*(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()*(int)factor);
    }
    public void reflect(boolean reflectOverX){
        if(reflectOverX){
            this.vector.setYCoordinate(this.vector.getYCoordinate()*-1);
        }else{
            this.vector.setXCoordinate(this.vector.getXCoordinate()*-1);
            
        }
    }
}
