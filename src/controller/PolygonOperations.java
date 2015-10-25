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
public class PolygonOperations implements ShapeOperations{
    
    private Polygon polygon;
    
    public PolygonOperations(Polygon polygon){
        this.polygon = polygon;
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
                System.out.println(xpoints[j]+","+ypoints[j]);
            }
        }
        System.out.println("");
    }
    public void shear(double factor, boolean isXShear){
        int[] xCoordinates = this.polygon.getXCoordinates();
        int[] yCoordinates = this.polygon.getYCoordinates();
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
        if(angle >= 0){
            int[] xCoordinates = this.polygon.getXCoordinates();
            int[] yCoordinates = this.polygon.getYCoordinates();
            for(int i=0; i<xCoordinates.length;i++){
                xCoordinates[i] = (xCoordinates[i] * (int)Math.cos(angle)) - (yCoordinates[i] * (int)Math.sin(angle));
                yCoordinates[i] += (xCoordinates[i] * (int)Math.sin(angle)) + (yCoordinates[i] * (int)Math.cos(angle));
            }
            this.polygon.setXCoordinates(xCoordinates);
            this.polygon.setYCoordinates(yCoordinates);
        }else{
            int[] xCoordinates = this.polygon.getXCoordinates();
            int[] yCoordinates = this.polygon.getYCoordinates();
            for(int i=0; i<yCoordinates.length;i++){
                xCoordinates[i] = (xCoordinates[i] * (int)Math.cos(angle)) + (yCoordinates[i] * (int)Math.sin(angle));
                yCoordinates[i] += (xCoordinates[i] * ((int)Math.sin(angle) * -1)) + (yCoordinates[i] * (int)Math.cos(angle));
            }
            this.polygon.setXCoordinates(xCoordinates);
            this.polygon.setYCoordinates(yCoordinates);
        }
    }
    public void translate(double x, double y){
        int[] xCoordinates, yCoordinates;
        xCoordinates = this.polygon.getXCoordinates();
        yCoordinates = this.polygon.getYCoordinates();
        for(int i=0;i<xCoordinates.length;i++){
            xCoordinates[i]+=x;
            yCoordinates[i]+=y;
        }
        this.polygon.setXCoordinates(xCoordinates);
        this.polygon.setYCoordinates(yCoordinates);
    }
    public void dilate(double factor, boolean isVerticalDilate){
        int[] xCoordinates, yCoordinates;
        if(isVerticalDilate){
            yCoordinates = this.polygon.getYCoordinates();
            for(int i=0;i<yCoordinates.length;i++){
                yCoordinates[i]*=factor;
            }
            this.polygon.setYCoordinates(yCoordinates);
        }else{
            xCoordinates = this.polygon.getXCoordinates();
            for(int i=0;i<xCoordinates.length;i++){
                xCoordinates[i]*=factor;
            }
            this.polygon.setXCoordinates(xCoordinates);
        }
    }
    public void contract(double factor){
        //le ask miki
    }
    public void uniformScale(double factor){
        int[] xCoordinates, yCoordinates;
        yCoordinates = this.polygon.getYCoordinates();
        xCoordinates = this.polygon.getXCoordinates();
        for(int i=0;i<yCoordinates.length;i++){
            yCoordinates[i]*=factor;
            xCoordinates[i]*=factor;
        }
        this.polygon.setXCoordinates(xCoordinates);
        this.polygon.setYCoordinates(yCoordinates);
    }
    public void nonUniformScale(double factor, boolean isVerticalScale){
        int[] xCoordinates, yCoordinates;
        if(isVerticalScale){
            yCoordinates = this.polygon.getYCoordinates();
            for(int i=0;i<yCoordinates.length;i++){
                yCoordinates[i]*=factor;
            }
            this.polygon.setYCoordinates(yCoordinates);
        }else{
            xCoordinates = this.polygon.getXCoordinates();
            for(int i=0;i<xCoordinates.length;i++){
                xCoordinates[i]*=factor;
            }
            this.polygon.setXCoordinates(xCoordinates);
        }
    }
    public void reflect(boolean reflectOverX){
        if(reflectOverX){
            int[] yCoordinates = this.polygon.getYCoordinates();
            for(int i=0;i<yCoordinates.length;i++)
                yCoordinates[i] *= -1;
            this.polygon.setYCoordinates(yCoordinates);
        }else{
            int[] xCoordinates = this.polygon.getXCoordinates();
            for(int i=0;i<xCoordinates.length;i++)
                xCoordinates[i] *= -1;
            this.polygon.setXCoordinates(xCoordinates);
        }
    }
}
