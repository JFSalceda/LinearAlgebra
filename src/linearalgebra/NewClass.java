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
        g.drawLine(0,290,600,290); // x-axis
        g.drawLine(290,0,290,600); // y-axis
        g.setColor(Color.BLACK);
        int a = 81;
        int b = 64;
        int centerX = 100;
        int centerY = 100;
        int x2, y2;
        x2 = 81;
        y2 = 64;
        
//        drawHyperbola(g, a, b, centerX, centerY, true);
//        drawParabola(g, a, centerX, centerY, true);
//        drawEllipse(g, a, b, centerX, centerY);
////        g.drawRect(290+Math.min(a, x2), 290-Math.max(b, y2), Math.abs(a-x2), Math.abs(b-y2));
//        g.drawLine(290+a, 290-b,(290+a)+(int)(2000*Math.cos(Math.toRadians(289))) ,(290-b)-(int)(2000*Math.sin(Math.toRadians(289))) );
//         int[] xpoints = {290+10,290+20,290+50,290+40,290+-50};
//         int[] ypoints = {290-30,290-40,290-60,290-70,290-(-80)};
//         Graphics2D g2 = (Graphics2D)g;
//         g2.setStroke(new BasicStroke(5));
//         g.drawLine((int)56.2342, (int)24.5454, 100, 120);
//         g2.drawLine(xpoints[1], ypoints[1], xpoints[1], ypoints[1]);
//         g2.drawLine(xpoints[2], ypoints[2], xpoints[2], ypoints[2]);
//         g2.drawLine(xpoints[3], ypoints[3], xpoints[3], ypoints[3]);
//         g2.drawLine(xpoints[4], ypoints[4], xpoints[4], ypoints[4]);
//         g2.setStroke(new BasicStroke(1));
//         g.drawPolygon(xpoints, ypoints, 5);
         
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
        g2.draw(new Ellipse2D.Double((290+centerX)-constantX, (290-centerY)-constantY,
                             constantX*2,
                             constantY*2));
        
//        for(int x=-constantX;x<=constantX;x++) //revised Ellipse method. Can possibly be used for diagonal ellipses
//        {
//            double y = sqrt(((double)constantY*constantY)*(1-(((x-centerX)*(x-centerX))/((double)constantX*constantX))));
//            int Y = (int)y;
//            g.drawLine((290-centerY)+x,290+(centerY+Y),(290-centerY)+x,290+(centerY+Y)); ////opens horizontally
//            g.drawLine((290-centerY)+x,290+(centerY-Y),(290-centerY)+x,290+(centerY-Y));
//            
//            System.out.println(x +"," + y);
//        }
        
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

