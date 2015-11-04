/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import model.Polygon;
import model.Shape;

/**
 *
 * @author Laptop
 */
public class PolygonOperations extends ShapeOperations{
    
    private Polygon polygon;
    private Polygon oldPolygon;
    
    public PolygonOperations(Polygon polygon){
        this.polygon = polygon;
        super.selectShape(false);
    }
    
    public void draw(Graphics g){
        int[] xpoints = new int[polygon.getXCoordinates().length], ypoints = new int[polygon.getYCoordinates().length], tempX = new int[polygon.getXCoordinates().length], tempY = new int[polygon.getYCoordinates().length];
        int handle;
        if(oldPolygon != null){
            g.setColor(new Color(8,120,48));
            for(int k=0;k<xpoints.length;k++){
                xpoints[k] = oldPolygon.getXCoordinates()[k] + 290;
                ypoints[k] = 290 - oldPolygon.getYCoordinates()[k];
                tempX[k] = xpoints[k];
                tempY[k] = ypoints[k];
//            System.out.println(xpoints[k]+","+ypoints[k]);
//            System.out.println(tempX[k]+","+tempY[k]+"\n");
            }
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
            g.setColor(Color.BLACK);
        }
        for(int k=0;k<xpoints.length;k++){
            xpoints[k] = polygon.getXCoordinates()[k] + 290;
            ypoints[k] = 290 - polygon.getYCoordinates()[k];
            tempX[k] = xpoints[k];
            tempY[k] = ypoints[k];
//            System.out.println(xpoints[k]+","+ypoints[k]);
//            System.out.println(tempX[k]+","+tempY[k]+"\n");
        }
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
        this.oldPolygon = new Polygon(this.polygon.getXCoordinates(), this.polygon.getYCoordinates());
        int[] xCoordinates = new int[this.polygon.getXCoordinates().length], yCoordinates = new int[this.polygon.getYCoordinates().length];
        System.arraycopy(this.polygon.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.polygon.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
        if(isXShear){//x' = x + ay
            for(int i=0; i<xCoordinates.length;i++){
                xCoordinates[i] = xCoordinates[i] + (int)factor * yCoordinates[i];
            }
            this.polygon.setXCoordinates(xCoordinates);
        }else{// y' = y + ax
            for(int i=0; i<yCoordinates.length;i++){
                yCoordinates[i] = yCoordinates[i] + (int)factor * xCoordinates[i];
            }
            this.polygon.setYCoordinates(yCoordinates);
        }
    }
    public void rotate(double angle){
        this.oldPolygon = new Polygon(this.polygon.getXCoordinates(), this.polygon.getYCoordinates());
        int[] xCoordinates = new int[this.polygon.getXCoordinates().length], yCoordinates = new int[this.polygon.getYCoordinates().length];
        System.arraycopy(this.polygon.getXCoordinates(), 0, xCoordinates, 0, xCoordinates.length);
        System.arraycopy(this.polygon.getYCoordinates(), 0, yCoordinates, 0, yCoordinates.length);
//        if(angle >= 0){
            angle = Math.toRadians(angle);
            for(int i=0; i<xCoordinates.length;i++){
                xCoordinates[i] = (int)(this.polygon.getXCoordinates()[i] * Math.cos(angle)) - (int)(this.polygon.getYCoordinates()[i] * Math.sin(angle));
                yCoordinates[i] = (int)(this.polygon.getXCoordinates()[i] * Math.sin(angle)) + (int)(this.polygon.getYCoordinates()[i] * Math.cos(angle));
                System.out.println(xCoordinates[i] + "," + yCoordinates[i]);
            }
//        }else{
//            angle = Math.toRadians(angle);
//            for(int i=0; i<yCoordinates.length;i++){
//                xCoordinates[i] = (int)(this.polygon.getXCoordinates()[i] * Math.cos(angle)) + (int)(this.polygon.getYCoordinates()[i] * Math.sin(angle));
//                yCoordinates[i] = (int)(this.polygon.getXCoordinates()[i] * (Math.sin(angle) * -1)) + (int)(this.polygon.getYCoordinates()[i] * Math.cos(angle));
//            }
//        }
        this.polygon.setXCoordinates(xCoordinates);
        this.polygon.setYCoordinates(yCoordinates);
    }
    public void translate(double x, double y){
        this.oldPolygon = new Polygon(this.polygon.getXCoordinates(), this.polygon.getYCoordinates());
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
        this.oldPolygon = new Polygon(this.polygon.getXCoordinates(), this.polygon.getYCoordinates());
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
        this.oldPolygon = new Polygon(this.polygon.getXCoordinates(), this.polygon.getYCoordinates());
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
        this.oldPolygon = new Polygon(this.polygon.getXCoordinates(), this.polygon.getYCoordinates());
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
        this.oldPolygon = new Polygon(this.polygon.getXCoordinates(), this.polygon.getYCoordinates());
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
        this.oldPolygon = new Polygon(this.polygon.getXCoordinates(), this.polygon.getYCoordinates());
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
    public Shape getShape(){
        return (Shape)this.polygon;
    }
}
