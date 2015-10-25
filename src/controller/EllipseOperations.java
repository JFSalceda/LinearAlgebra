/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import static java.lang.Math.sqrt;
import model.Ellipse;

/**
 *
 * @author Laptop
 */
public class EllipseOperations implements ShapeOperations{
    
    private Ellipse ellipse;
    
    public EllipseOperations(Ellipse ellipse){
        this.ellipse = ellipse;
    }
    
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        int centerX = (int)this.ellipse.getXCoordinate();
        int centerY = (int)this.ellipse.getYCoordinate();
        double constantX = this.ellipse.getXConstant();
        double constantY = this.ellipse.getYConstant();
        g2.draw(new Ellipse2D.Double((290+centerX)-constantX, (290-centerY)-constantY,
                             constantX*2,
                             constantY*2));
        
//        for(int x=(int)-constantX;x<=(int)constantX;x++) //revised Ellipse method. Can possibly be used for diagonal ellipses
//        {
//            double y = sqrt(((double)constantY*constantY)*(1-((((double)x*x))/((double)constantX*constantX))));
//            int Y = (int)y;
//            g.drawLine((290+centerX)+x,290-(centerY+Y),(290+centerX)+x,290-(centerY+Y)); ////opens horizontally
//            g.drawLine((290+centerX)+x,290-(centerY-Y),(290+centerX)+x,290-(centerY-Y));
//            
//            System.out.println(x +"," + y);
//        }
    }
    public void shear(double factor, boolean isXShear){
        //empty
    }
    public void rotate(double angle){
        double handle = this.ellipse.getXConstant();
        this.ellipse.setXConstant(this.ellipse.getYConstant());
        this.ellipse.setYConstant(handle);
    }
    public void translate(double x, double y){
        this.ellipse.setXCoordinate(this.ellipse.getXCoordinate()+x);
        this.ellipse.setYCoordinate(this.ellipse.getYCoordinate()+y);
    }
    public void dilate(double factor, boolean isVerticalDilate){
         if(isVerticalDilate){
            this.ellipse.setYConstant(this.ellipse.getYConstant()*factor);
        }else{
            this.ellipse.setXConstant(this.ellipse.getXConstant()*factor);
        }
    }
    public void contract(double factor){
        //le ask miki
    }
    public void uniformScale(double factor){
        this.ellipse.setYConstant(this.ellipse.getYConstant()*factor);
        this.ellipse.setXConstant(this.ellipse.getXConstant()*factor);
    }
    public void nonUniformScale(double factor, boolean isVerticalScale){
         if(isVerticalScale){
            this.ellipse.setYConstant(this.ellipse.getYConstant()*factor);
        }else{
            this.ellipse.setXConstant(this.ellipse.getXConstant()*factor);
        }
    }
    public void reflect(boolean reflectOverX){
        if(reflectOverX){
            this.ellipse.setYCoordinate(this.ellipse.getYCoordinate()*-1);
        }else{
            this.ellipse.setXCoordinate(this.ellipse.getXCoordinate()*-1);
        }
    }
}
