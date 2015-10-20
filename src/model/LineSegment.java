/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**Z
 *
 * @author Laptop
 */
public class LineSegment {
    
    private final double[] x;
    private final double[] y;
    
    public LineSegment(double x[], double y[]){
        if(x.length == 2 && y.length==2){
            this.x = x;
            this.y = y;
        }
        else{
            this.x = new double[]{0,0};
            this.y = new double[]{0,0};
        }
    }
    
    public double[] getPoint(int ptr){
        return new double[]{this.x[ptr], this.y[ptr]};
    }
    
    public void setPoint(double x, double y, int ptr){
        this.x[ptr] = x;
        this.y[ptr] = y;
    }
    
    public double[] getXCoordinates(){
        return this.x;
    }
    
    public void setXCoordinates(double[] x){
        this.x[0] = x[0];
        this.x[1] = x[1];
    }
    
    public double[] getYCoordinates(){
        return this.y;
    }
    
    public void setYCoordinates(double[] y){
        this.y[0] = y[0];
        this.y[1] = y[1];
    }
}
