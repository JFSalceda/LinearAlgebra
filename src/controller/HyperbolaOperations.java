/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import static java.lang.Math.sqrt;
import model.Hyperbola;

/**
 *
 * @author Laptop
 */
public class HyperbolaOperations implements ShapeOperations{
    
    private Hyperbola hyperbola;
    
    public HyperbolaOperations(Hyperbola hyperbola){
        this.hyperbola = hyperbola;
    }
    
    public void draw(Graphics g){
        int centerY = (int)this.hyperbola.getYCoordinate();
        int centerX = (int)this.hyperbola.getXCoordinate();
        double constantY = this.hyperbola.getYConstant();
        double constantX = this.hyperbola.getXConstant();
        boolean opensVertically = this.hyperbola.isVertical();
        for(int x=-400;x<=400;x++) //revised Ellipse method. Can possibly be used for diagonal ellipses
        {
            double y = constantY*sqrt((((double)x-centerX)*(x-centerX)/((double)constantX*constantX))+1);
            int Y = (int)y;
            if(opensVertically){
                g.drawLine(290+x,(290-centerY)+Y,290+x,(290-centerY)+Y); ////opens vertically
                g.drawLine(290+x,(290-centerY)-Y,290+x,(290-centerY)-Y);
            }else{
                g.drawLine((290+centerX)+Y,(290-centerY)+x,(290+centerX)+Y,(290-centerY)+x); ////opens horizontally
                g.drawLine((290+centerX)-Y,(290-centerY)+x,(290+centerX)-Y,(290-centerY)+x);
            }
            System.out.println(x +"," + y);
        }
    }
     public void shear(double factor, boolean isXShear){
        //empty
    }
    public void rotate(double angle){
        this.hyperbola.changeOrientation(!this.hyperbola.isVertical());
    }
    public void translate(double x, double y){
        this.hyperbola.setXCoordinate(this.hyperbola.getXCoordinate()+x);
        this.hyperbola.setYCoordinate(this.hyperbola.getYCoordinate()+y);
    }
    public void dilate(double factor, boolean isVerticalDilate){
        if(isVerticalDilate){
            this.hyperbola.setYConstant(this.hyperbola.getYConstant()*factor);
        }else{
            this.hyperbola.setXConstant(this.hyperbola.getXConstant()*factor);
        }
    }
    public void contract(double factor){
        //le ask miki
    }
    public void uniformScale(double factor){
        this.hyperbola.setYConstant(this.hyperbola.getYConstant()*factor);
        this.hyperbola.setXConstant(this.hyperbola.getXConstant()*factor);
    }
    public void nonUniformScale(double factor, boolean isVerticalScale){
        if(isVerticalScale){
            this.hyperbola.setYConstant(this.hyperbola.getYConstant()*factor);
        }else{
            this.hyperbola.setXConstant(this.hyperbola.getXConstant()*factor);
        }
    }
    public void reflect(boolean reflectOverX){
        //empty
    }
}
