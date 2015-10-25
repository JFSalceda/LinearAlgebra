/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.ParabolaOperations;
import controller.PointOperations;
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
import model.Parabola;
import model.Point;
import model.Polygon;
import model.Shape;
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
            ((ShapeOperations)shapes.get(i)).draw(g);
        }
    }
    
    public void AddShape(Shape shape){
        this.shapes.add(shape);
    }
}
