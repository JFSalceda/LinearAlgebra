/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import static java.lang.Math.sqrt;
import model.Parabola;

/**
 *
 * @author Laptop
 */
public class ParabolaOperations implements ShapeOperations{
    private Parabola parabola;
    
    public ParabolaOperations(Parabola parabola){
        this.parabola= parabola;
    }
    public void draw(Graphics g){
        double constant = this.parabola.getConstant();
        int centerX = (int)this.parabola.getXCoordinate();
        int centerY = (int)this.parabola.getYCoordinate();
        boolean opensVertically = this.parabola.isVertical();
        
        int sign = (int) Math.signum(constant);
        int ySign = (int) Math.signum(centerY);
        
        for(int y=0;y<=300+(centerY*ySign);y++)
        {
            double x = sqrt(sign*4*constant*y);//formula for parabola. look for formulae for other conics that look for y
            int X = (int)x;
            if(opensVertically){
                g.drawLine((290+centerX)+X,(290-centerY)-sign*y,(290+centerX)+X,(290-centerY)-sign*y);   ////opens vertically
                g.drawLine((290+centerX)-X,(290-centerY)-sign*y,(290+centerX)-X,(290-centerY)-sign*y);
            }else{
                g.drawLine((290-centerY)+y*sign,(290+centerX)+X,(290-centerY)+y*sign,(290+centerX)+X); ////opens horizontally
                g.drawLine((290-centerY)+y*sign,(290+centerX)-X,(290-centerY)+y*sign,(290+centerX)-X);
            }
//            System.out.println(x +"," + y);
        }
    }
    //public void shear(Graphics g);
    public void rotate(Graphics g, double angle){
         //static rotate only
    }
    public void translate(Graphics g, double x, double y){
        this.parabola.setXCoordinate(this.parabola.getXCoordinate()+x);
        this.parabola.setYCoordinate(this.parabola.getYCoordinate()+y);
    }
    public void dilate(Graphics g, double factor, boolean isVerticalDilate){
        this.parabola.setConstant(this.parabola.getConstant()*factor);
    }
    public void contract(Graphics g, double factor){
        this.parabola.setConstant(this.parabola.getConstant()/factor);
    }
    public void uniformScale(Graphics g, double factor){
        this.parabola.setConstant(this.parabola.getConstant()*factor);
    }
    public void nonUniformScale(Graphics g, double factor, boolean isVerticalScale){
        this.parabola.setConstant(this.parabola.getConstant()*factor);
    }
    public void reflect(Graphics g, boolean reflectOverX){
        if(reflectOverX){
            if(this.parabola.isVertical())
                this.parabola.setConstant(this.parabola.getConstant()*-1);
        }else{
            if(!this.parabola.isVertical())
                this.parabola.setConstant(this.parabola.getConstant()*-1);
        }
    }
}
