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
public class Vector implements Shape{
    
    private double x;
    private double y;
    private double angle;
    
    public Vector(double x, double y, double angle){
        this.x = x;
        this.y = y;
        this.angle = angle;
    }
    
    public void draw(Graphics g){
        
    }
    
     public double getXCoordinate(){
        return x;
    }
    
    public double getYCoordinate(){
        return y;
    }
    
    public double getAngle(){
        return angle;
    }
    
    public void setXCoordinate(double x){
        this.x = x;
    }
    
    public void setYCoordinate(double y){
        this.y = y;
    }
    
    public void setAngle(double angle){
        this.angle = angle;
    }
}
