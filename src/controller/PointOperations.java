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
public class PointOperations implements ShapeOperations{
    private Point point;
    
    public PointOperations(Point point){
        this.point= point;
    }
    public void draw(Graphics g){
        g.drawLine(290+point.getXCoordinate(), 290-point.getYCoordinate(), 290+point.getXCoordinate(), 290-point.getYCoordinate());
    }
    public void shear(Graphics g, double factor, boolean isXShear){
        //empty
    }
    public void rotate(Graphics g, double angle){
        //empty
    }
    public void translate(Graphics g, double x, double y){
        this.point.setXCoordinate(this.point.getXCoordinate()+(int)x);
        this.point.setYCoordinate(this.point.getYCoordinate()+(int)y);
        
    }
    public void dilate(Graphics g, double factor, boolean isVerticalDilate){
        //empty
    }
    public void contract(Graphics g, double factor){
        //empty
    }
    public void uniformScale(Graphics g, double factor){
        //empty
    }
    public void nonUniformScale(Graphics g, double factor, boolean isVerticalScale){
        //empty
    }
    public void reflect(Graphics g, boolean reflectOverX){
        if(reflectOverX){
            this.point.setYCoordinate(this.point.getYCoordinate()*-1);
        }else{
            this.point.setXCoordinate(this.point.getXCoordinate()*-1);
        }
    }
}
