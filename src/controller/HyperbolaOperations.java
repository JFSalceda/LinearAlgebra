/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.sqrt;
import model.Hyperbola;
import model.Shape;

/**
 *
 * @author Laptop
 */
public class HyperbolaOperations extends ShapeOperations{
    
    private Hyperbola hyperbola;
    private Hyperbola oldHyperbola;
    
    public HyperbolaOperations(Hyperbola hyperbola){
        this.hyperbola = hyperbola;
        super.selectShape(false);
    }
    
    public void draw(Graphics g){
        int centerY, centerX;
        double constantX, constantY;
        boolean opensVertically;
        if(oldHyperbola != null){
            g.setColor(new Color(8,120,48));
            centerY = (int)this.oldHyperbola.getYCoordinate();
            centerX = (int)this.oldHyperbola.getXCoordinate();
            constantY = this.oldHyperbola.getYConstant();
            constantX = this.oldHyperbola.getXConstant();
            opensVertically = this.oldHyperbola.isVertical();
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
            g.setColor(Color.BLACK);
        }
        centerY = (int)this.hyperbola.getYCoordinate();
        centerX = (int)this.hyperbola.getXCoordinate();
        constantY = this.hyperbola.getYConstant();
        constantX = this.hyperbola.getXConstant();
        opensVertically = this.hyperbola.isVertical();
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
        if(angle == 90 || angle == -90)
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
        this.hyperbola.setYConstant(this.hyperbola.getYConstant()/factor);
        this.hyperbola.setXConstant(this.hyperbola.getXConstant()/factor);
    }
    public void uniformScale(double factor){
        this.hyperbola.setYConstant(this.hyperbola.getYConstant()*factor);
        this.hyperbola.setXConstant(this.hyperbola.getXConstant()*factor);
    }
    public void nonUniformScale(double xFactor, double yFactor){
            this.hyperbola.setYConstant(this.hyperbola.getYConstant()*xFactor);
            this.hyperbola.setXConstant(this.hyperbola.getXConstant()*yFactor);
    }
    public void reflect(boolean reflectOverX){
        //empty
    }
    public Shape getShape(){
        return (Shape)this.hyperbola;
    }
}
