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
public class Vector/* implements Shape*/{
    
    private int x;
    private int y;
    private double angle;
    
    public Vector(int x, int y, double angle){
        this.x = x;
        this.y = y;
        this.angle = angle;
    }
    
     public int getXCoordinate(){
        return x;
    }
    
    public int getYCoordinate(){
        return y;
    }
    
    public double getAngle(){
        return angle;
    }
    
    public void setXCoordinate(int x){
        this.x = x;
    }
    
    public void setYCoordinate(int y){
        this.y = y;
    }
    
    public void setAngle(double angle){
        this.angle = angle;
    }
}
