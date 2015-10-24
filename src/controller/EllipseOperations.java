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
    //public void shear(Graphics g);
    public void rotate(Graphics g, double angle){
        
    }
    public void translate(Graphics g, double x, double y){
        this.ellipse.setXCoordinate(this.ellipse.getXCoordinate()+x);
        this.ellipse.setYCoordinate(this.ellipse.getYCoordinate()+y);
    }
    public void dilate(Graphics g, double factor, boolean isVerticalDilate){
         if(isVerticalDilate){
            this.ellipse.setYConstant(this.ellipse.getYConstant()/factor);
        }else{
            this.ellipse.setXConstant(this.ellipse.getXConstant()/factor);
        }
    }
    public void contract(Graphics g, double factor){
        
    }
    public void scale(Graphics g, boolean isUniform){
        
    }
    public void reflect(Graphics g, boolean reflectOverX){
        if(reflectOverX){
            this.ellipse.setYCoordinate(this.ellipse.getYCoordinate()*-1);
        }else{
            this.ellipse.setXCoordinate(this.ellipse.getXCoordinate()*-1);
        }
    }
}
