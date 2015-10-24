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
    //public void shear(Graphics g);
    public void rotate(Graphics g, double angle);
    public void translate(Graphics g, double x, double y);
    public void dilate(Graphics g, double factor, boolean isVerticalDilate);
    public void contract(Graphics g, double factor);
    public void scale(Graphics g, boolean isUniform);
    public void reflect(Graphics g, boolean reflectOverX);
    
}
