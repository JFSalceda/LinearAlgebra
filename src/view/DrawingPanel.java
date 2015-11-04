/*
x * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.HyperbolaOperations;
import controller.LineSegmentOperations;
import controller.ParabolaOperations;
import controller.PolygonOperations;
import controller.ShapeOperations;
import controller.VectorOperations;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Hyperbola;
import model.LineSegment;
import model.Parabola;
import model.Polygon;
import model.Vector;
/**
 *
 * @author Laptop
 */
public class DrawingPanel extends JPanel{
    private ArrayList shapes;
    private JButton button;
    
    public DrawingPanel(){
        shapes = new ArrayList<ShapeOperations>();
//        shapes.add(new VectorOperations(new Vector(128,25)));
//        shapes.add(new LineSegmentOperations(new LineSegment(new int[]{-34,75}, new int[]{-56,90} )));
        shapes.add(new PolygonOperations(new Polygon(new int[]{10, -56, 73}, new int[]{32, -78, -65})));
//        shapes.add(new ParabolaOperations(new Parabola(25,new double[]{25,25},true)));
        button = new JButton("click");
        button.setBounds(0, 0, 100, 100);
//        button.addActionListener((java.awt.event.ActionEvent e) -> {nonUniformScaleShape(0,2,0.5);});
//        button.addActionListener((java.awt.event.ActionEvent e) -> {contractShape(0,2);});
//        button.addActionListener((java.awt.event.ActionEvent e) -> {dilateShape(0,2,false);});
//        button.addActionListener((java.awt.event.ActionEvent e) -> {uniformScaleShape(0,2);});
//        button.addActionListener((java.awt.event.ActionEvent e) -> {translateShape(0,-150,-50);});
//        button.addActionListener((java.awt.event.ActionEvent e) -> {rotateShape(0,45);});
//        button.addActionListener((java.awt.event.ActionEvent e) -> {reflectShape(0,false);});
//        button.addActionListener((java.awt.event.ActionEvent e) -> {shearShape(0,2,false);});
              
        this.add(button); 
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for(int i=0;i<=600;i++){
            if(i%30==0){
                g.drawLine(0,i+290,600,i+290); 
                g.drawLine(i+290,0,i+290,600); 
                g.drawLine(0,290-i,600,290-i); 
                g.drawLine(290-i,0,290-i,600); 
            }
        }
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawLine(0,290,600,290); // x-axis
        g.drawLine(290,0,290,600); // y-axis
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        for(int i=0;i<shapes.size();i++){
            if(((ShapeOperations)shapes.get(i)).isShapeSelected()){
                g.setColor(new Color(8,120,48));
            }
            ((ShapeOperations)shapes.get(i)).draw(g);
        }
    }
    
    public void AddShape(ShapeOperations shape){
        this.shapes.add(shape);
        
        this.repaint();
    }
    
    public void RemoveShape(int index){
        this.shapes.remove(index);
        this.repaint();
    }
    
    public void shearShape(int index, double factor, boolean isXShear){
        ((ShapeOperations)shapes.get(index)).shear(factor, isXShear);
        ((ShapeOperations)shapes.get(index)).selectShape(true);
        this.repaint();
    }
    public void translateShape(int index, double x, double y){
        ((ShapeOperations)shapes.get(index)).translate(x, y);
        this.repaint();
    }
    public void contractShape(int index, double factor){
        ((ShapeOperations)shapes.get(index)).contract(factor);
        this.repaint();
    }
    public void uniformScaleShape(int index, double factor){
        ((ShapeOperations)shapes.get(index)).uniformScale(factor);
        this.repaint();
    }
    public void nonUniformScaleShape(int index, double xFactor, double yFactor){
        ((ShapeOperations)shapes.get(index)).nonUniformScale(xFactor, yFactor);
        this.repaint();
    }
    public void reflectShape(int index, boolean reflectOverX){
        ((ShapeOperations)shapes.get(index)).reflect(reflectOverX);
        this.repaint();
    }
    public void rotateShape(int index, double angle){
        ((ShapeOperations)shapes.get(index)).rotate(angle);
        this.repaint();
    }
    public void dilateShape(int index, double factor, boolean isVerticalDilate){
        ((ShapeOperations)shapes.get(index)).dilate(factor, isVerticalDilate);
        this.repaint();
    }
    public void selectShape(int index, boolean isSelected){
        ((ShapeOperations)shapes.get(index)).selectShape(isSelected);
    }
}

