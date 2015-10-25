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
        g.drawLine(0, 0, 290+x, 290-y);
    }
    //public void shear(Graphics g);
    public void rotate(Graphics g, double angle){
        
    }
    public void translate(Graphics g, double x, double y){
        this.vector.setXCoordinate(this.vector.getXCoordinate()+(int)x);
        this.vector.setYCoordinate(this.vector.getYCoordinate()+(int)y);
        
    }
    public void dilate(Graphics g, double factor, boolean isVerticalDilate){
        this.vector.setXCoordinate(this.vector.getXCoordinate()*(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()*(int)factor);
    }
    public void contract(Graphics g, double factor){
        
        this.vector.setXCoordinate(this.vector.getXCoordinate()/(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()/(int)factor);
    }
    public void uniformScale(Graphics g, double factor){
        this.vector.setXCoordinate(this.vector.getXCoordinate()*(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()*(int)factor);
    }
    public void nonUniformScale(Graphics g, double factor, boolean isVerticalScale){
        this.vector.setXCoordinate(this.vector.getXCoordinate()*(int)factor);
        this.vector.setYCoordinate(this.vector.getYCoordinate()*(int)factor);
    }
    public void reflect(Graphics g, boolean reflectOverX){
        if(reflectOverX){
            this.vector.setYCoordinate(this.vector.getYCoordinate()*-1);
        }else{
            this.vector.setXCoordinate(this.vector.getXCoordinate()*-1);
            
        }
    }
}
