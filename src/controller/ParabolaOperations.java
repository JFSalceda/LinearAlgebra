/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.sqrt;
import model.Parabola;
import model.Shape;

/**
 *
 * @author Laptop
 */
public class ParabolaOperations extends ShapeOperations{
    private Parabola parabola;
    private Parabola oldParabola;
    
    public ParabolaOperations(Parabola parabola){
        this.parabola= parabola;
        super.selectShape(false);
    }
    public void draw(Graphics g){
        double constant;
        int centerX, centerY;
        boolean opensVertically;
        if(oldParabola != null){
            g.setColor(new Color(8,120,48));
            constant = this.oldParabola.getConstant();
            centerX = (int)this.oldParabola.getXCoordinate();
            centerY = (int)this.oldParabola.getYCoordinate();
            opensVertically = this.oldParabola.isVertical();
        
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
                    g.drawLine((290+centerY)+y*sign,(290-centerX)+X,(290+centerY)+y*sign,(290-centerX)+X); ////opens horizontally
                    g.drawLine((290+centerY)+y*sign,(290-centerX)-X,(290+centerY)+y*sign,(290-centerX)-X);
                }
//            System.out.println(x +"," + y);
            }
            g.setColor(Color.BLACK);
        }
        constant = this.parabola.getConstant();
        centerX = (int)this.parabola.getXCoordinate();
        centerY = (int)this.parabola.getYCoordinate();
        opensVertically = this.parabola.isVertical();
        
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
                g.drawLine((290+centerY)+y*sign,(290-centerX)+X,(290+centerY)+y*sign,(290-centerX)+X); ////opens horizontally
                g.drawLine((290+centerY)+y*sign,(290-centerX)-X,(290+centerY)+y*sign,(290-centerX)-X);
            }
//            System.out.println(x +"," + y);
        }
    }
     public void shear(double factor, boolean isXShear){
        //empty
    }
    public void rotate(double angle){
        this.oldParabola = new Parabola(this.parabola.getConstant(), new double[]{this.parabola.getXCoordinate(),this.parabola.getYCoordinate()}, this.parabola.isVertical());
        if(angle == 180){
            this.parabola.setConstant(this.parabola.getConstant()*-1);
        }else if(angle == 90){
            if(this.parabola.isVertical())
                this.parabola.setConstant(this.parabola.getConstant()*-1);
            this.parabola.changeOrientation(!this.parabola.isVertical());
        }else if(angle == -90){
            if(!this.parabola.isVertical())
                this.parabola.setConstant(this.parabola.getConstant()*-1);
            this.parabola.changeOrientation(!this.parabola.isVertical());
        }
    }
    public void translate(double x, double y){
        this.oldParabola = new Parabola(this.parabola.getConstant(), new double[]{this.parabola.getXCoordinate(),this.parabola.getYCoordinate()}, this.parabola.isVertical());
        this.parabola.setXCoordinate(this.parabola.getXCoordinate()+x);
        this.parabola.setYCoordinate(this.parabola.getYCoordinate()+y);
    }
    public void dilate(double factor, boolean isVerticalDilate){
        this.oldParabola = new Parabola(this.parabola.getConstant(), new double[]{this.parabola.getXCoordinate(),this.parabola.getYCoordinate()}, this.parabola.isVertical());
        this.parabola.setConstant(this.parabola.getConstant()*factor);
    }
    public void contract(double factor){
        this.oldParabola = new Parabola(this.parabola.getConstant(), new double[]{this.parabola.getXCoordinate(),this.parabola.getYCoordinate()}, this.parabola.isVertical());
        this.parabola.setConstant(this.parabola.getConstant()/factor);
    }
    public void uniformScale(double factor){
        this.oldParabola = new Parabola(this.parabola.getConstant(), new double[]{this.parabola.getXCoordinate(),this.parabola.getYCoordinate()}, this.parabola.isVertical());
        this.parabola.setConstant(this.parabola.getConstant()*factor);
    }
    public void nonUniformScale(double xFactor, double yFactor){
        this.oldParabola = new Parabola(this.parabola.getConstant(), new double[]{this.parabola.getXCoordinate(),this.parabola.getYCoordinate()}, this.parabola.isVertical());
        //this.parabola.setConstant(this.parabola.getConstant()*factor);
    }
    public void reflect(boolean reflectOverX){
        this.oldParabola = new Parabola(this.parabola.getConstant(), new double[]{this.parabola.getXCoordinate(),this.parabola.getYCoordinate()}, this.parabola.isVertical());
        if(reflectOverX){
            if(this.parabola.isVertical())
                this.parabola.setConstant(this.parabola.getConstant()*-1);
        }else{
            if(!this.parabola.isVertical())
                this.parabola.setConstant(this.parabola.getConstant()*-1);
        }
    }
    public Shape getShape(){
        return (Shape)this.parabola;
    }
}
