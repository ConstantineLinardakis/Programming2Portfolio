//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;

//Driver class
public class CannonballDriver extends JPanel{
         // Main method
          public static void main(String[] args){
               //Declare local variables
               double alpha;
               double v;
               double deltaSec=0.1;
               //create scanner object
               Scanner sc = new Scanner(System.in);
               //Prompt and read the angle and velocity
               System.out.print("Enter angle:");
               alpha = sc.nextDouble();
               System.out.print("Enter initial velocity:");
               v = sc.nextDouble();
               Cannonball cannonObject=new Cannonball(0);
               // Instantiate cannon object with the parameters
               points=cannonObject.shoot(alpha,v,deltaSec);
               JFrame frame = new JFrame("Cannon Shoot Points");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.add(new CannonballDriver());
               frame.setSize(500, 500);
               frame.setVisible(true);
          }

     //Declare Array List
     private static ArrayList<Point> points;
     //Constructor
     public CannonballDriver(){
     }
     @Override
     //Implement the method paint
     public void paintComponent(Graphics g){
          // Calling Super Method
          super.paintComponent(g);

          Graphics2D gr = (Graphics2D) g;

          gr.setColor(Color.blue);

          gr.setStroke(new BasicStroke(10));

          gr.setPaintMode();

          for (Point p : points){
               int x1 = (int)p.getX();
               int y1 = (int)p.getY();
               gr.drawLine(500-x1, 500-y1, 500-x1,500-y1);
          }
     }

     //Paint method
     public void paint(Graphics g){
          super.paint(g);
          Toolkit.getDefaultToolkit().sync();
          g.dispose();
     }

     //Implement the method action performed
     public void actionPerformed(ActionEvent e){
          repaint();
     }
}
