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
public class Parabola {
    
    private double constant;
    private final double[] vertex;
    private boolean opensVertically;
    
    public Parabola(double constant, double[] vertex, boolean opensVertically){
        if(vertex.length == 2){
            this.vertex = vertex;
        }else{
            this.vertex = new double[]{0,0};
        }
        this.constant = constant;
        this.opensVertically = opensVertically;
    }
    
    public double getConstant(){
        return this.constant;
    }
    
    public void setConstant(double constant){
        this.constant = constant;
    }
    
    public double getXCoordinate(){
        return vertex[0];
    }
    
    public void setXCoordinate(double x){
        vertex[0] = x;
    }
    
    public double getYCoordinate(){
        return vertex[1];
    }
    
    public void setYCoordinate(double y){
        vertex[1] = y;
    }
    
    public boolean isVertical(){
        return opensVertically;
    }
    
    public void changeOrientation(boolean opensVertically){
        this.opensVertically = opensVertically;
    }
}
