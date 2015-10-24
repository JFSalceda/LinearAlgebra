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
        int[] xpoints = polygon.getXCoordinates();
        int[] ypoints = polygon.getYCoordinates();
        int[] tempX = new int[xpoints.length], tempY = new int[xpoints.length];
        
        for(int k=0;k<xpoints.length;k++){
            xpoints[k] += 290;
            ypoints[k] -= 290;
            tempX[k] = xpoints[k];
            tempY[k] = ypoints[k];
        }
        
        int handle;
        g.fillPolygon(xpoints, ypoints, 4);
        for(int i=0; i<xpoints.length-1;i++){
            for(int j=i+1;j<xpoints.length;j++){
                handle = xpoints[i];
                xpoints[i] = xpoints[j];
                xpoints[j] = handle;
                handle = ypoints[i];
                ypoints[i] = ypoints[j];
                ypoints[j] = handle;
                g.fillPolygon(xpoints, ypoints, 4);
                for(int k=0;k<xpoints.length;k++){
                    xpoints[k] = tempX[k];
                    ypoints[k] = tempY[k];
                }
//                System.out.println("");
            }
        }
    }
    //public void shear(Graphics g);
    public void rotate(Graphics g, double angle){
        
    }
    public void translate(Graphics g, double x, double y){
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
    public void dilate(Graphics g, double factor, boolean isVerticalDilate){
        int[] xCoordinates, yCoordinates;
        if(isVerticalDilate){
            yCoordinates = this.polygon.getYCoordinates();
            for(int i=0;i<yCoordinates.length;i++){
                yCoordinates[i]/=factor;
            }
            this.polygon.setYCoordinates(yCoordinates);
        }else{
            xCoordinates = this.polygon.getXCoordinates();
            for(int i=0;i<xCoordinates.length;i++){
                xCoordinates[i]/=factor;
            }
            this.polygon.setXCoordinates(xCoordinates);
        }
    }
    public void contract(Graphics g, double factor){
        
    }
    public void scale(Graphics g, boolean isUniform){
        
    }
    public void reflect(Graphics g, boolean reflectOverX){
        
    }
}
