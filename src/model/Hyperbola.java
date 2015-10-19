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
public class Hyperbola {
    
    private double constantX;
    private double constantY;
    private final double[] vertex;
    private boolean opensVertically;
    
    public Hyperbola(double constantX, double constantY, double[] vertex, boolean opensVertically){
        if(vertex.length == 2){
            this.vertex = vertex;
        }else{
            this.vertex = new double[]{0,0};
        }
        this.constantX = constantX;
        this.constantY = constantY;
        this.opensVertically = opensVertically;
    }
    
    public double getXConstant(){
        return this.constantX;
    }
    
    public void setXConstant(double constant){
        this.constantX = constant;
    }
    
    public double getYConstant(){
        return this.constantY;
    }
    
    public void setYConstant(double constant){
        this.constantY = constant;
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
