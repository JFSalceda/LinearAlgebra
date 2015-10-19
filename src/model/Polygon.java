/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;

/**
 *
 * @author Laptop
 */
public class Polygon {
    
    private double[] xCoordinates;
    private double[] yCoordinates;
    
    public Polygon(double[] xCoordinates, double[] yCoordinates){
        if(xCoordinates.length == yCoordinates.length){
            this.xCoordinates = xCoordinates;
            this.yCoordinates = yCoordinates;
        }
        else{
            this.xCoordinates = new double[]{0,0,0};
            this.yCoordinates = new double[]{0,0,0};
        }
    }
    
    public double[] getPoint(int ptr){
        return new double[]{this.xCoordinates[ptr], this.yCoordinates[ptr]};
    }
    
    public void setPoint(double x, double y, int ptr){
        this.xCoordinates[ptr] = x;
        this.yCoordinates[ptr] = y;
    }
    
    public double[] getXCoordinates(){
        return this.xCoordinates;
    }
    
    public void setXCoordinates(double[] xCoordinates){
        this.xCoordinates = xCoordinates;
    }
    
    public double[] getYCoordinates(){
        return this.yCoordinates;
    }
    
    public void setYCoordinates(double[] yCoordinates){
        this.yCoordinates = yCoordinates;
    }
    
    public void addPoint(double x, double y){
        this.xCoordinates = Arrays.copyOf(this.xCoordinates, this.xCoordinates.length+1);
        this.yCoordinates = Arrays.copyOf(this.yCoordinates, this.yCoordinates.length+1);
        this.xCoordinates[this.xCoordinates.length-1] = x;
        this.yCoordinates[this.yCoordinates.length-1] = y;
    }
    
    public void removePoint(int ptr){
        double[] xhandle = this.xCoordinates;
        double[] yhandle = this.yCoordinates;
        this.xCoordinates = Arrays.copyOf(this.xCoordinates, this.xCoordinates.length-1);
        this.yCoordinates = Arrays.copyOf(this.yCoordinates, this.yCoordinates.length-1);
        for(int i=0;i<this.xCoordinates.length-1;i++){
            if(i != ptr){
               xCoordinates[i] = xhandle[i];
               yCoordinates[i] = yhandle[i];
            }
        }
                
    }
}
