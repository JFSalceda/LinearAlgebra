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
public class LineSegmentOperations extends ShapeOperations{
    private LineSegment lineSegment;
    
    public LineSegmentOperations(LineSegment lineSegment){
        this.lineSegment = lineSegment;
        super.selectShape(false);
    }
    
    public void draw(Graphics g){
        int[] xCoordinates = new int[this.lineSegment.getXCoordinates().length], yCoordinates = new int[this.lineSegment.getYCoordinates().length];
        System.arraycopy(this.lineSegment.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.lineSegment.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        
        g.drawLine(290+xCoordinates[0], 290-yCoordinates[0], 290+xCoordinates[1], 290-yCoordinates[1]);
    }
     public void shear(double factor, boolean isXShear){
        int[] xCoordinates = new int[this.lineSegment.getXCoordinates().length], yCoordinates = new int[this.lineSegment.getYCoordinates().length];
        System.arraycopy(this.lineSegment.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.lineSegment.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
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
    public void rotate(double angle){
        int[] xCoordinates = new int[this.lineSegment.getXCoordinates().length], yCoordinates = new int[this.lineSegment.getYCoordinates().length];
        System.arraycopy(this.lineSegment.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.lineSegment.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        angle = Math.toRadians(angle);
        if(angle >= 0){
        // x' = xcos(rad)-ysin(rad)
        //y' = xsin(rad)+ycos(rad)
            xCoordinates[0] = (int)(xCoordinates[0] * Math.cos(angle)) - (int)(yCoordinates[0] * Math.sin(angle));
            yCoordinates[0] = (int)(xCoordinates[0] * Math.sin(angle)) + (int)(yCoordinates[0] * Math.cos(angle));
            xCoordinates[1] = (int)(xCoordinates[1] * Math.cos(angle)) - (int)(yCoordinates[1] * Math.sin(angle));
            yCoordinates[1] = (int)(xCoordinates[1] * Math.sin(angle)) + (int)(yCoordinates[1] * Math.cos(angle));
        }else{
        // x' = xcos(rad)+ysin(rad)
        //y' = x(-sin(rad) + ycos(rad)
            xCoordinates[0] = (xCoordinates[0] * (int)Math.cos(angle)) + (yCoordinates[0] * (int)Math.sin(angle));
            yCoordinates[0] += (xCoordinates[0] * ((int)Math.sin(angle) * -1)) + (yCoordinates[0] * (int)Math.cos(angle));
            xCoordinates[1] = (xCoordinates[1] * (int)Math.cos(angle)) + (yCoordinates[1] * (int)Math.sin(angle));
            yCoordinates[1] += (xCoordinates[1] * ((int)Math.sin(angle) * -1)) + (yCoordinates[1] * (int)Math.cos(angle));
        }
        this.lineSegment.setXCoordinates(xCoordinates);
        this.lineSegment.setYCoordinates(yCoordinates);
    }
    public void translate(double x, double y){
        int[] xCoordinates = new int[this.lineSegment.getXCoordinates().length], yCoordinates = new int[this.lineSegment.getYCoordinates().length];
        System.arraycopy(this.lineSegment.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.lineSegment.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        xCoordinates[0] += x;
        yCoordinates[0] += y;
        xCoordinates[1] += x;
        yCoordinates[1] += y;
        this.lineSegment.setXCoordinates(xCoordinates);
        this.lineSegment.setYCoordinates(yCoordinates);
    }
    public void dilate(double factor, boolean isVerticalDilate){
        if(isVerticalDilate){
            int[] yCoordinates = new int[this.lineSegment.getYCoordinates().length];
            System.arraycopy(this.lineSegment.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
            yCoordinates[0] *= factor;
            yCoordinates[1] *= factor;
            this.lineSegment.setYCoordinates(yCoordinates);
        }else{
            int[] xCoordinates = new int[this.lineSegment.getXCoordinates().length];
            System.arraycopy(this.lineSegment.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
            xCoordinates[0] *= factor;
            xCoordinates[1] *= factor;
            this.lineSegment.setXCoordinates(xCoordinates);
        }
    }
    public void contract(double factor){
        int[] xCoordinates = new int[this.lineSegment.getXCoordinates().length], yCoordinates = new int[this.lineSegment.getYCoordinates().length];
        System.arraycopy(this.lineSegment.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.lineSegment.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        xCoordinates[0] /= factor;
        yCoordinates[0] /= factor;
        xCoordinates[1] /= factor;
        yCoordinates[1] /= factor;
        this.lineSegment.setXCoordinates(xCoordinates);
        this.lineSegment.setYCoordinates(yCoordinates);
    }
    public void uniformScale(double factor){
        int[] xCoordinates = new int[this.lineSegment.getXCoordinates().length], yCoordinates = new int[this.lineSegment.getYCoordinates().length];
        System.arraycopy(this.lineSegment.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.lineSegment.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        xCoordinates[0] *= factor;
        yCoordinates[0] *= factor;
        xCoordinates[1] *= factor;
        yCoordinates[1] *= factor;
        this.lineSegment.setXCoordinates(xCoordinates);
        this.lineSegment.setYCoordinates(yCoordinates);
    }
    public void nonUniformScale(double xFactor, double yFactor){
        int[] xCoordinates = new int[this.lineSegment.getXCoordinates().length], yCoordinates = new int[this.lineSegment.getYCoordinates().length];
        System.arraycopy(this.lineSegment.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.lineSegment.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        xCoordinates[0] *= xFactor;
        yCoordinates[0] *= xFactor;
        xCoordinates[1] *= yFactor;
        yCoordinates[1] *= yFactor;
        this.lineSegment.setXCoordinates(xCoordinates);
        this.lineSegment.setYCoordinates(yCoordinates);
    }
    public void reflect(boolean reflectOverX){
        int[] xCoordinates = new int[this.lineSegment.getXCoordinates().length], yCoordinates = new int[this.lineSegment.getYCoordinates().length];
        if(reflectOverX){
            System.arraycopy(this.lineSegment.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
            yCoordinates[0] *= -1;
            yCoordinates[1] *= -1;
            this.lineSegment.setYCoordinates(yCoordinates);
        }else{
            System.arraycopy(this.lineSegment.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
            xCoordinates[0] *= -1;
            xCoordinates[1] *= -1;
            this.lineSegment.setXCoordinates(xCoordinates);
        }
    }
}
