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
     public void shear(Graphics g, double factor, boolean isXShear){
        int[] xCoordinates = this.lineSegment.getXCoordinates();
        int[] yCoordinates = this.lineSegment.getYCoordinates();
        if(isXShear){//x' = x + ay
            xCoordinates[0] += xCoordinates[0] + factor * yCoordinates[0];
            xCoordinates[1] += xCoordinates[1] + factor * yCoordinates[1];
            this.lineSegment.setXCoordinates(xCoordinates);
        }else{// y' = y + ax
            yCoordinates[0] += yCoordinates[0] + factor * xCoordinates[0];
            yCoordinates[1] += yCoordinates[1] + factor * xCoordinates[1];
            this.lineSegment.setYCoordinates(yCoordinates);
        }
    }
    public void rotate(Graphics g, double angle){
        angle = Math.toRadians(angle);
        if(angle >= 0){
        // x' = xcos(rad)-ysin(rad)
        //y' = xsin(rad)+ycos(rad)
            int[] xCoordinates = this.lineSegment.getXCoordinates();
            int[] yCoordinates = this.lineSegment.getYCoordinates();
            xCoordinates[0] = (xCoordinates[0] * (int)Math.cos(angle)) - (yCoordinates[0] * (int)Math.sin(angle));
            yCoordinates[0] += (xCoordinates[0] * (int)Math.sin(angle)) + (yCoordinates[0] * (int)Math.cos(angle));
            xCoordinates[1] = (xCoordinates[1] * (int)Math.cos(angle)) - (yCoordinates[1] * (int)Math.sin(angle));
            yCoordinates[1] += (xCoordinates[1] * (int)Math.sin(angle)) + (yCoordinates[1] * (int)Math.cos(angle));
            this.lineSegment.setXCoordinates(xCoordinates);
            this.lineSegment.setYCoordinates(yCoordinates);
        }else{
        // x' = xcos(rad)+ysin(rad)
        //y' = x(-sin(rad) + ycos(rad)
            int[] xCoordinates = this.lineSegment.getXCoordinates();
            int[] yCoordinates = this.lineSegment.getYCoordinates();
            xCoordinates[0] = (xCoordinates[0] * (int)Math.cos(angle)) + (yCoordinates[0] * (int)Math.sin(angle));
            yCoordinates[0] += (xCoordinates[0] * ((int)Math.sin(angle) * -1)) + (yCoordinates[0] * (int)Math.cos(angle));
            xCoordinates[1] = (xCoordinates[1] * (int)Math.cos(angle)) + (yCoordinates[1] * (int)Math.sin(angle));
            yCoordinates[1] += (xCoordinates[1] * ((int)Math.sin(angle) * -1)) + (yCoordinates[1] * (int)Math.cos(angle));
            this.lineSegment.setXCoordinates(xCoordinates);
            this.lineSegment.setYCoordinates(yCoordinates);
        }
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
