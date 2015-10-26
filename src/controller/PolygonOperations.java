/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import model.Polygon;

/**
 *
 * @author Laptop
 */
public class PolygonOperations extends ShapeOperations{
    
    private Polygon polygon;
    
    public PolygonOperations(Polygon polygon){
        this.polygon = polygon;
        super.selectShape(false);
    }
    
    public void draw(Graphics g){
        int[] xpoints = new int[polygon.getXCoordinates().length], ypoints = new int[polygon.getYCoordinates().length], tempX = new int[polygon.getXCoordinates().length], tempY = new int[polygon.getYCoordinates().length];
        
        for(int k=0;k<xpoints.length;k++){
            xpoints[k] = polygon.getXCoordinates()[k] + 290;
            ypoints[k] = 290 - polygon.getYCoordinates()[k];
            tempX[k] = xpoints[k];
            tempY[k] = ypoints[k];
//            System.out.println(xpoints[k]+","+ypoints[k]);
//            System.out.println(tempX[k]+","+tempY[k]+"\n");
        }
        int handle;
        g.fillPolygon(xpoints, ypoints, xpoints.length);
        for(int i=0; i<xpoints.length-1;i++){
            for(int j=i+1;j<xpoints.length;j++){
                handle = xpoints[i];
                xpoints[i] = xpoints[j];
                xpoints[j] = handle;
                handle = ypoints[i];
                ypoints[i] = ypoints[j];
                ypoints[j] = handle;
                g.fillPolygon(xpoints, ypoints, xpoints.length);
                for(int k=0;k<xpoints.length;k++){
                    xpoints[k] = tempX[k];
                    ypoints[k] = tempY[k];
                }
            }
        }
        System.out.println("");
    }
    public void shear(double factor, boolean isXShear){
        int[] xCoordinates = new int[this.polygon.getXCoordinates().length], yCoordinates = new int[this.polygon.getYCoordinates().length];
        System.arraycopy(this.polygon.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.polygon.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        if(isXShear){//x' = x + ay
            for(int i=0; i<xCoordinates.length;i++){
                xCoordinates[i] += xCoordinates[i] + factor * yCoordinates[i];
            }
            this.polygon.setXCoordinates(xCoordinates);
        }else{// y' = y + ax
            for(int i=0; i<yCoordinates.length;i++){
                yCoordinates[i] += yCoordinates[i] + factor * xCoordinates[i];
            }
            this.polygon.setYCoordinates(yCoordinates);
        }
    }
    public void rotate(double angle){
        int[] xCoordinates = new int[this.polygon.getXCoordinates().length], yCoordinates = new int[this.polygon.getYCoordinates().length];
        System.arraycopy(this.polygon.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.polygon.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        if(angle >= 0){
            for(int i=0; i<xCoordinates.length;i++){
                xCoordinates[i] = (int)(xCoordinates[i] * Math.cos(angle)) - (int)(yCoordinates[i] * Math.sin(angle));
                yCoordinates[i] = (int)(xCoordinates[i] * Math.sin(angle)) + (int)(yCoordinates[i] * Math.cos(angle));
                System.out.println(xCoordinates[i] + "," + yCoordinates[i]);
            }
        }else{
            for(int i=0; i<yCoordinates.length;i++){
                xCoordinates[i] = (int)(xCoordinates[i] * Math.cos(angle)) + (int)(yCoordinates[i] * Math.sin(angle));
                yCoordinates[i] = (int)(xCoordinates[i] * (Math.sin(angle) * -1)) + (int)(yCoordinates[i] * Math.cos(angle));
            }
        }
        this.polygon.setXCoordinates(xCoordinates);
        this.polygon.setYCoordinates(yCoordinates);
    }
    public void translate(double x, double y){
        int[] xCoordinates = new int[this.polygon.getXCoordinates().length], yCoordinates = new int[this.polygon.getYCoordinates().length];
        System.arraycopy(this.polygon.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.polygon.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        for(int i=0;i<xCoordinates.length;i++){
            xCoordinates[i]+=x;
            yCoordinates[i]+=y;
        }
        this.polygon.setXCoordinates(xCoordinates);
        this.polygon.setYCoordinates(yCoordinates);
    }
    public void dilate(double factor, boolean isVerticalDilate){
        int[] xCoordinates = new int[this.polygon.getXCoordinates().length], yCoordinates = new int[this.polygon.getYCoordinates().length];
        if(isVerticalDilate){
            System.arraycopy(this.polygon.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
            for(int i=0;i<yCoordinates.length;i++){
                yCoordinates[i]*=factor;
            }
            this.polygon.setYCoordinates(yCoordinates);
        }else{
            System.arraycopy(this.polygon.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
            for(int i=0;i<xCoordinates.length;i++){
                xCoordinates[i]*=factor;
            }
            this.polygon.setXCoordinates(xCoordinates);
        }
    }
    public void contract(double factor){
        int[] xCoordinates = new int[this.polygon.getXCoordinates().length], yCoordinates = new int[this.polygon.getYCoordinates().length];
        System.arraycopy(this.polygon.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.polygon.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        for(int i=0;i<xCoordinates.length;i++){
            xCoordinates[i]/=factor;
            yCoordinates[i]/=factor;
        }
        this.polygon.setXCoordinates(xCoordinates);
        this.polygon.setYCoordinates(yCoordinates);
    }
    public void uniformScale(double factor){
        int[] xCoordinates = new int[this.polygon.getXCoordinates().length], yCoordinates = new int[this.polygon.getYCoordinates().length];
        System.arraycopy(this.polygon.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.polygon.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        for(int i=0;i<yCoordinates.length;i++){
            yCoordinates[i]*=factor;
            xCoordinates[i]*=factor;
            System.out.println(xCoordinates[i]+","+yCoordinates[i]);
        }
        this.polygon.setXCoordinates(xCoordinates);
        this.polygon.setYCoordinates(yCoordinates);
        System.out.println("wow");
        for(int i=0;i<xCoordinates.length;i++)
        System.out.println(xCoordinates[i]+","+yCoordinates[i]);
    }
    public void nonUniformScale(double xFactor, double yFactor){
        int[] xCoordinates = new int[this.polygon.getXCoordinates().length], yCoordinates = new int[this.polygon.getYCoordinates().length];
        System.arraycopy(this.polygon.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.polygon.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
            for(int i=0;i<yCoordinates.length;i++){
                xCoordinates[i]*=xFactor;
                yCoordinates[i]*=yFactor;
            }
            this.polygon.setYCoordinates(yCoordinates);
            this.polygon.setXCoordinates(xCoordinates);
    }
    public void reflect(boolean reflectOverX){
        int[] xCoordinates = new int[this.polygon.getXCoordinates().length], yCoordinates = new int[this.polygon.getYCoordinates().length];
        if(reflectOverX){
            System.arraycopy(this.polygon.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
            for(int i=0;i<yCoordinates.length;i++)
                yCoordinates[i] *= -1;
            this.polygon.setYCoordinates(yCoordinates);
        }else{
            System.arraycopy(this.polygon.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
            for(int i=0;i<xCoordinates.length;i++)
                xCoordinates[i] *= -1;
            this.polygon.setXCoordinates(xCoordinates);
        }
    }
}
