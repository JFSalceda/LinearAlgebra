/*

UNSOLVED PROBLEMS

    - diagonal conics
    - how to properly close polygons

*/
package linearalgebra;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
 
import static java.lang.Math.sqrt;
public class NewClass extends Component {
    
    public void paint(Graphics g) //parabola
    {
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
        g2.setStroke(new BasicStroke(1));
        int a = 4;
        int b = 64;
        int centerX = 0;
        int centerY = 0;
        int x2, y2;
        x2 = 81;
        y2 = 64;
        
//        drawHyperbola(g, a, b, centerX, centerY, true);
        drawParabola(g, a, centerX, centerY, false);
//        drawEllipse(g, a, b, centerX, centerY);
////        g.drawRect(290+Math.min(a, x2), 290-Math.max(b, y2), Math.abs(a-x2), Math.abs(b-y2));
//        g.drawLine(290+a, 290-b,(290+a)+(int)(2000*Math.cos(Math.toRadians(289))) ,(290-b)-(int)(2000*Math.sin(Math.toRadians(289))) );
//        g.drawLine(290+(int)56.2342, 290-(int)24.5454, 290+100, 290-120);
//         int[] xpoints = {290+100,290+200,290+170,290+140,290+150};
//         int[] ypoints = {290-130,290-140,290-160,290-170,290-(-180)};
//         g2.drawLine(xpoints[0], ypoints[0], xpoints[0], ypoints[0]);
//         g2.drawLine(xpoints[1], ypoints[1], xpoints[1], ypoints[1]);
//         g2.drawLine(xpoints[2], ypoints[2], xpoints[2], ypoints[2]);
//         g2.drawLine(xpoints[3], ypoints[3], xpoints[3], ypoints[3]);
//         g2.drawLine(xpoints[4], ypoints[4], xpoints[4], ypoints[4]);
//         g2.setStroke(new BasicStroke(1));
//         int[] tempX = new int[xpoints.length], tempY = new int[xpoints.length];
//         for(int k=0;k<xpoints.length;k++){
//            tempX[k] = xpoints[k];
//            tempY[k] = ypoints[k];
//         }
//         int handle;
//         
//         g.fillPolygon(xpoints, ypoints, 4);
//         for(int i=0; i<xpoints.length-1;i++){
//             for(int j=i+1;j<xpoints.length;j++){
//                 handle = xpoints[i];
//                 xpoints[i] = xpoints[j];
//                 xpoints[j] = handle;
//                 handle = ypoints[i];
//                 ypoints[i] = ypoints[j];
//                 ypoints[j] = handle;
//                 g.fillPolygon(xpoints, ypoints, 4);
//                 for(int k=0;k<xpoints.length;k++){
//                     xpoints[k] = tempX[k];
//                     ypoints[k] = tempY[k];
//                 }
////                System.out.println("");
//             }
//         }
         
         
    }
    
    public void drawParabola(Graphics g, int constant, int centerX, int centerY, boolean opensVertically){
        int sign = (int) Math.signum(constant);
        int ySign = (int) Math.signum(centerY);
        for(int y=0;y<=300+(centerY*ySign);y++)
        {
            double x = sqrt(sign*4*constant*y);//formula for parabola. look for formulae for other conics that look for y
            int X = (int)x;
            if(opensVertically){
                g.drawLine((290+centerX)+X,(290-centerY)-sign*y,(290+centerX)+X,(290-centerY)-sign*y);   ////opens vertically
                g.drawLine((290+centerX)-X,(290-centerY)-sign*y,(290+centerX)-X,(290-centerY)-sign*y);
            }else{
                g.drawLine((290-centerY)+y*sign,(290+centerX)+X,(290-centerY)+y*sign,(290+centerX)+X); ////opens horizontally
                g.drawLine((290-centerY)+y*sign,(290+centerX)-X,(290-centerY)+y*sign,(290+centerX)-X);
            }
//            System.out.println(x +"," + y);
        }
        
    }
    
    public void drawEllipse(Graphics g, int constantX, int constantY, int centerX, int centerY){
        Graphics2D g2 = (Graphics2D)g;
        //g2.setStroke(new BasicStroke(5));
//        g2.draw(new Ellipse2D.Double((290+centerX)-constantX, (290-centerY)-constantY,
//                             constantX*2,
//                             constantY*2));
        
//        for(int x=-constantX;x<=constantX;x++) //revised Ellipse method. Can possibly be used for diagonal ellipses
//        {
//            double y = sqrt(((double)constantY*constantY)*(1-((((double)x*x))/((double)constantX*constantX))));
//            int Y = (int)y;
//            g.drawLine((290+centerX)+x,290-(centerY+Y),(290+centerX)+x,290-(centerY+Y)); ////opens horizontally
//            g.drawLine((290+centerX)+x,290-(centerY-Y),(290+centerX)+x,290-(centerY-Y));
//            
//            System.out.println(x +"," + y);
//        }
        
        for(int x=-constantX;x<=constantX;x++) //rotated Ellipse method.
        {
            double y = (((double)constantX*constantX)*(1.0/Math.sin(Math.toRadians(25)))*(1.0/Math.cos(Math.toRadians(25))))/(4*x);
            int Y = (int)y;
            g.drawLine((290+centerX)+x,290-(centerY+Y),(290+centerX)+x,290-(centerY+Y)); ////opens horizontally
            g.drawLine((290+centerX)+x,290-(centerY-Y),(290+centerX)+x,290-(centerY-Y));
            
            System.out.println(x +"," + y);
        }
        
    }
    
    public void drawHyperbola(Graphics g, int constantX, int constantY, int centerX, int centerY, boolean opensVertically){ //constantX is always the larger value
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(1));
        
        for(int x=-400;x<=400;x++) //revised Ellipse method. Can possibly be used for diagonal ellipses
        {
            double y = constantY*sqrt((((double)x-centerX)*(x-centerX)/((double)constantX*constantX))+1);
            int Y = (int)y;
            if(opensVertically){
                g.drawLine(290+x,(290-centerY)+Y,290+x,(290-centerY)+Y); ////opens vertically
                g.drawLine(290+x,(290-centerY)-Y,290+x,(290-centerY)-Y);
            }else{
                g.drawLine((290+centerX)+Y,(290-centerY)+x,(290+centerX)+Y,(290-centerY)+x); ////opens horizontally
                g.drawLine((290+centerX)-Y,(290-centerY)+x,(290+centerX)-Y,(290-centerY)+x);
            }
            System.out.println(x +"," + y);
        }
        
    }
    
    
}

