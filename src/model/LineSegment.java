/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;

/**
 *
 * @author Laptop
 */
public class LineSegment {
    
    private final int[] x;
    private final int[] y;
    
    public LineSegment(int x[], int y[]){
        if(x.length == 2 && y.length==2){
            this.x = new int[x.length];
            this.y = new int[y.length];
        }
        else{
            this.x = new int[]{0,0};
            this.y = new int[]{0,0};
        }
    }
    
    public int[] getPoint(int ptr){
        return new int[]{this.x[ptr], this.y[ptr]};
    }
    
    public void setPoint(int x, int y, int ptr){
        this.x[ptr] = x;
        this.y[ptr] = y;
    }
    
    public int[] getXCoordinates(){
        return this.x;
    }
    
    public void setXCoordinates(int[] x){
        this.x[0] = x[0];
        this.x[1] = x[1];
    }
    
    public int[] getYCoordinates(){
        return this.y;
    }
    
    public void setYCoordinates(int[] y){
        this.y[0] = y[0];
        this.y[1] = y[1];
    }
}
