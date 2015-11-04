/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import model.Point;
import model.Shape;

/**
 *
 * @author Laptop
 */
public class PointOperations extends ShapeOperations{
    private Point point;
    private Point oldPoint;
    
    public PointOperations(Point point){
        this.point= point;
        super.selectShape(false);
    }
    public void draw(Graphics g){
        if(oldPoint != null){
            g.setColor(new Color(8,120,48));
            g.drawLine(290+oldPoint.getXCoordinate(), 290-oldPoint.getYCoordinate(), 290+oldPoint.getXCoordinate(), 290-oldPoint.getYCoordinate());
            g.setColor(Color.BLACK);
        }
        g.drawLine(290+point.getXCoordinate(), 290-point.getYCoordinate(), 290+point.getXCoordinate(), 290-point.getYCoordinate());
    }
    public void shear(double factor, boolean isXShear){
        //empty
    }
    public void rotate(double angle){
        //empty
    }
    public void translate(double x, double y){
        this.oldPoint = new Point(this.point.getXCoordinate(), this.point.getYCoordinate());
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
        this.oldPoint = new Point(this.point.getXCoordinate(), this.point.getYCoordinate());
        if(reflectOverX){
            this.point.setYCoordinate(this.point.getYCoordinate()*-1);
        }else{
            this.point.setXCoordinate(this.point.getXCoordinate()*-1);
        }
    }
    public Shape getShape(){
        return (Shape)this.point;
    }
}
