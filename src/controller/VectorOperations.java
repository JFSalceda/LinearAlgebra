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
public class VectorOperations implements ShapeOperations{
    private Vector vector;
    
    public VectorOperations(Vector vector){
        this.vector = vector;
    }
    
    public void draw(Graphics g){
        int x = (int)vector.getXCoordinate();
        int y = (int)vector.getYCoordinate();
        double angle = vector.getAngle();
        g.drawLine(290+x, 290-y,(290+x)+(int)(2000*Math.cos(Math.toRadians(angle))) ,(290-y)-(int)(2000*Math.sin(Math.toRadians(angle))) );
    }
    //public void shear(Graphics g);
    public void rotate(Graphics g, double angle){
        
    }
    public void translate(Graphics g, double x, double y){
        this.vector.setXCoordinate(this.vector.getXCoordinate()+(int)x);
        this.vector.setYCoordinate(this.vector.getYCoordinate()+(int)y);
        
    }
    public void dilate(Graphics g, double factor, boolean isVerticalDilate){
        if(isVerticalDilate){
            
        }else{
            
        }
    }
    public void contract(Graphics g, double factor){
        
    }
    public void scale(Graphics g, boolean isUniform){
        
    }
    public void reflect(Graphics g, boolean reflectOverX){
        
    }
}
