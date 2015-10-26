/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import model.Point;

/**
 *
 * @author Laptop
 */
public class PointOperations extends ShapeOperations{
    private Point point;
    
    public PointOperations(Point point){
        this.point= point;
        super.selectShape(false);
    }
    public void draw(Graphics g){
        g.drawLine(290+point.getXCoordinate(), 290-point.getYCoordinate(), 290+point.getXCoordinate(), 290-point.getYCoordinate());
    }
    public void shear(double factor, boolean isXShear){
        //empty
    }
    public void rotate(double angle){
        //empty
    }
    public void translate(double x, double y){
        this.point.setXCoordinate(this.point.getXCoordinate()+(int)x);
        this.point.setYCoordinate(this.point.getYCoordinate()+(int)y);
        
    }
    public void dilate(double factor, boolean isVerticalDilate){
        //empty
    }
    public void contract(double factor){
        //empty
    }
    public void uniformScale(double factor){
        //empty
    }
    public void nonUniformScale(double xFactor, double yFactor){
        //empty
    }
    public void reflect(boolean reflectOverX){
        if(reflectOverX){
            this.point.setYCoordinate(this.point.getYCoordinate()*-1);
        }else{
            this.point.setXCoordinate(this.point.getXCoordinate()*-1);
        }
    }
}
