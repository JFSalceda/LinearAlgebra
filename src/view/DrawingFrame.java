/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Laptop
 */
public class DrawingFrame extends JFrame{
    
    private DrawingPanel panel;
    public DrawingFrame(){
        super();
        panel = new DrawingPanel();
        this.setSize(600,600);
        this.setTitle("Shape Canvas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}
