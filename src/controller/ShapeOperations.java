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
public interface ShapeOperations {
    public void draw(Graphics g);
    public void shear(double factor, boolean isXShear);
    public void rotate(double angle);
    public void translate(double x, double y);
    public void dilate(double factor, boolean isVerticalDilate);
    public void contract(double factor);
    public void nonUniformScale(double factor, boolean isVerticalScale);
    public void uniformScale(double factor);
    public void reflect(boolean reflectOverX);
    
}
