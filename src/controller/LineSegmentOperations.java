/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import model.LineSegment;

/**
 *
 * @author Laptop
 */
public class LineSegmentOperations implements ShapeOperations{
    private LineSegment lineSegment;
    
    public LineSegmentOperations(LineSegment lineSegment){
        this.lineSegment = lineSegment;
    }
    
    public void draw(Graphics g){
        int[] xCoordinates = this.lineSegment.getXCoordinates();
        int[] yCoordinates = this.lineSegment.getYCoordinates();
        
        g.drawLine(290+xCoordinates[0], 290-yCoordinates[0], 290+xCoordinates[1], 290-yCoordinates[1]);
    }
    //public void shear(Graphics g);
    public void rotate(Graphics g, double angle){
        
    }
    public void translate(Graphics g, double x, double y){
        int[] xCoordinates = this.lineSegment.getXCoordinates();
        int[] yCoordinates = this.lineSegment.getYCoordinates();
        xCoordinates[0] += x;
        yCoordinates[0] += y;
        xCoordinates[1] += x;
        yCoordinates[1] += y;
        this.lineSegment.setXCoordinates(xCoordinates);
        this.lineSegment.setYCoordinates(yCoordinates);
    }
    public void dilate(Graphics g, double factor, boolean isVerticalDilate){
        int[] xCoordinates = this.lineSegment.getXCoordinates();
        int[] yCoordinates = this.lineSegment.getYCoordinates();
        xCoordinates[0] *= factor;
        yCoordinates[0] *= factor;
        xCoordinates[1] *= factor;
        yCoordinates[1] *= factor;
        this.lineSegment.setXCoordinates(xCoordinates);
        this.lineSegment.setYCoordinates(yCoordinates);
    }
    public void contract(Graphics g, double factor){
        int[] xCoordinates = this.lineSegment.getXCoordinates();
        int[] yCoordinates = this.lineSegment.getYCoordinates();
        xCoordinates[0] /= factor;
        yCoordinates[0] /= factor;
        xCoordinates[1] /= factor;
        yCoordinates[1] /= factor;
        this.lineSegment.setXCoordinates(xCoordinates);
        this.lineSegment.setYCoordinates(yCoordinates);
    }
    public void uniformScale(Graphics g, double factor){
        int[] xCoordinates = this.lineSegment.getXCoordinates();
        int[] yCoordinates = this.lineSegment.getYCoordinates();
        xCoordinates[0] *= factor;
        yCoordinates[0] *= factor;
        xCoordinates[1] *= factor;
        yCoordinates[1] *= factor;
        this.lineSegment.setXCoordinates(xCoordinates);
        this.lineSegment.setYCoordinates(yCoordinates);
    }
    public void nonUniformScale(Graphics g, double factor, boolean isVerticalScale){
        int[] xCoordinates = this.lineSegment.getXCoordinates();
        int[] yCoordinates = this.lineSegment.getYCoordinates();
        xCoordinates[0] *= factor;
        yCoordinates[0] *= factor;
        xCoordinates[1] *= factor;
        yCoordinates[1] *= factor;
        this.lineSegment.setXCoordinates(xCoordinates);
        this.lineSegment.setYCoordinates(yCoordinates);
    }
    public void reflect(Graphics g, boolean reflectOverX){
        if(reflectOverX){
            int[] yCoordinates = this.lineSegment.getYCoordinates();
            yCoordinates[0] *= -1;
            yCoordinates[1] *= -1;
            this.lineSegment.setYCoordinates(yCoordinates);
        }else{
            int[] xCoordinates = this.lineSegment.getXCoordinates();
            xCoordinates[0] *= -1;
            xCoordinates[1] *= -1;
            this.lineSegment.setXCoordinates(xCoordinates);
        }
    }
}
