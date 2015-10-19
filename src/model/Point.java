/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Laptop
 */
public class Point {
    
    private double x;
    private double y;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getXCoordinate(){
        return x;
    }
    
    public double getYCoordinate(){
        return y;
    }
    
    public void setXCoordinate(double x){
        this.x = x;
    }
    
    public void setYCoordinate(double y){
        this.y = y;
    }
    
}
