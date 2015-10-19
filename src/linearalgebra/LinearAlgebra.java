/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearalgebra;

/**
 *
 * @author Laptop
 */
import javax.swing.JFrame;

public class LinearAlgebra {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setTitle("Parabola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new NewClass());
        frame.setVisible(true);
        
    }
    
}
