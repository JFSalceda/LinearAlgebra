/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import model.Shape;
import model.Vector;

/**
 *
 * @author Laptop
 */
public class VectorOperations extends ShapeOperations{
    private Vector vector;
    private Vector oldVector;
    
    public VectorOperations(Vector vector){
        this.vector = vector;
        super.selectShape(false);
    }
    
    public void draw(Graphics g){
        if(oldVector != null){
            int x = (int)oldVector.getXCoordinate();
            int y = (int)oldVector.getYCoordinate();
            g.setColor(new Color(8,120,48));
            g.drawLine(290, 290, 290+x, 290-y);
            System.out.println(x + "," + y);
        }
        g.setColor(Color.BLACK);
        int x = (int)vector.getXCoordinate();
        int y = (int)vector.getYCoordinate();
        g.drawLine(290, 290, 290+x, 290-y);
         System.out.println(x + "," + y);
    }
    public void shear(double factor, boolean isXShear){
        this.oldVector = new Vector(this.vector.getXCoordinate(), this.vector.getYCoordinate());
        if(isXShear){//x' = x + ay
            this.vector.setXCoordinate(this.vector.getXCoordinate() + (int)(factor * this.vector.getYCoordinate()));
        }else{// y' = y + ax
            this.vector.setYCoordinate(this.vector.getYCoordinate() + (int)(factor * this.vector.getXCoordinate()));
        }
    }
    public void rotate(double angle){
        this.oldVector = new Vector(this.vector.getXCoordinate(), this.vector.getYCoordinate());
        int xhandle, yhandle;
//        if(angle >= 0){
        // x' = xcos(rad)-ysin(rad)
        //y' = xsin(rad)+ycos(rad)
            angle = Math.toRadians(angle);
            xhandle = (int)(this.vector.getXCoordinate() * Math.cos(angle)) - (int)(this.vector.getYCoordinate()  * Math.sin(angle));
            yhandle = (int)(this.vector.getXCoordinate() * Math.sin(angle)) + (int)(this.vector.getYCoordinate()  * Math.cos(angle));
//        }else{
//        // x' = xcos(rad)+ysin(rad)
//        //y' = x(-sin(rad) + ycos(rad)
//            angle = Math.toRadians(angle);
//            xhandle = (this.vector.getXCoordinate() * (int)Math.cos(angle)) + (this.vector.getYCoordinate()  * (int)Math.sin(angle));
//            yhandle = this.vector.getXCoordinate() * ((int)Math.sin(angle) * -1) + (this.vector.getYCoordinate()  * ((int)Math.cos(angle) * -1));
//        }
        this.vector.setXCoordinate(xhandle);
        this.vector.setYCoordinate(yhandle);
    }
    public void translate(double x, double y){
        this.oldVector = new Vector(this.vector.getXCoordinate(), this.vector.getYCoordinate());
        this.vector.setXCoordinate(this.vector.getXCoordinate()+(int)x);
        this.vector.setYCoordinate(this.vector.getYCoordinate()+(int)y);
        
    }
    public void dilate(double factor, boolean isVerticalDilate){
        this.oldVector = new Vector(this.vector.getXCoordinate(), this.vector.getYCoordinate());
        this.vector.setXCoordinate(this.vector.getXCoordinate()*(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()*(int)factor);
    }
    public void contract(double factor){
        this.oldVector = new Vector(this.vector.getXCoordinate(), this.vector.getYCoordinate());
        this.vector.setXCoordinate(this.vector.getXCoordinate()/(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()/(int)factor);
    }
    public void uniformScale(double factor){
        this.oldVector = new Vector(this.vector.getXCoordinate(), this.vector.getYCoordinate());
        this.vector.setXCoordinate(this.vector.getXCoordinate()*(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()*(int)factor);
    }
    public void nonUniformScale(double xFactor, double yFactor){
        this.oldVector = new Vector(this.vector.getXCoordinate(), this.vector.getYCoordinate());
        this.vector.setXCoordinate(this.vector.getXCoordinate()*(int)xFactor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()*(int)yFactor);
    }
    public void reflect(boolean reflectOverX){
        this.oldVector = new Vector(this.vector.getXCoordinate(), this.vector.getYCoordinate());
        if(reflectOverX){
            this.vector.setYCoordinate(this.vector.getYCoordinate()*-1);
        }else{
            this.vector.setXCoordinate(this.vector.getXCoordinate()*-1);
            
        }
    }
    
    public Shape getShape(){
        return (Shape)this.vector;
    }
}
