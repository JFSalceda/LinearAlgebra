/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import model.Shape;

/**
 *
 * @author Laptop
 */
public abstract class ShapeOperations {
    public boolean isSelected;
    public boolean isShapeSelected(){
        return this.isSelected;
    }
    public void selectShape(boolean isSelected){
        this.isSelected = isSelected;
    }
    public abstract void draw(Graphics g);
    public abstract void shear(double factor, boolean isXShear);
    public abstract void rotate(double angle);
    public abstract void translate(double x, double y);
    public abstract void dilate(double factor, boolean isVerticalDilate);
    public abstract void contract(double factor);
    public abstract void nonUniformScale(double xFactor, double yFactor);
    public abstract void uniformScale(double factor);
    public abstract void reflect(boolean reflectOverX);
    
}
