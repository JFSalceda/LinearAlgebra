/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.util.Arrays;

/**
 *
 * @author Laptop
 */
public class Polygon {
    
    private int[] xCoordinates;
    private int[] yCoordinates;
    
    public Polygon(int[] xCoordinates, int[] yCoordinates){
        if(xCoordinates.length == yCoordinates.length){
            this.xCoordinates = xCoordinates;
            this.yCoordinates = yCoordinates;
        }
        else{
            this.xCoordinates = new int[]{0,0,0};
            this.yCoordinates = new int[]{0,0,0};
        }
    }
    
    public int[] getPoint(int ptr){
        return new int[]{this.xCoordinates[ptr], this.yCoordinates[ptr]};
    }
    
    public void setPoint(int x, int y, int ptr){
        this.xCoordinates[ptr] = x;
        this.yCoordinates[ptr] = y;
    }
    
    public int[] getXCoordinates(){
        return this.xCoordinates;
    }
    
    public void setXCoordinates(int[] xCoordinates){
        this.xCoordinates = xCoordinates;
    }
    
    public int[] getYCoordinates(){
        return this.yCoordinates;
    }
    
    public void setYCoordinates(int[] yCoordinates){
        this.yCoordinates = yCoordinates;
    }
    
    public void addPoint(int x, int y){
        this.xCoordinates = Arrays.copyOf(this.xCoordinates, this.xCoordinates.length+1);
        this.yCoordinates = Arrays.copyOf(this.yCoordinates, this.yCoordinates.length+1);
        this.xCoordinates[this.xCoordinates.length-1] = x;
        this.yCoordinates[this.yCoordinates.length-1] = y;
    }
    
    public void removePoint(int ptr){
        int[] xhandle = this.xCoordinates;
        int[] yhandle = this.yCoordinates;
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
