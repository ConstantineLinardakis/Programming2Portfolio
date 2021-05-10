/*
* @author Constantine Linardakis
* @since Dec/03/2020
* This program gets a x, and y of a cannonball and projects it on the screen using the users input.
* Project 8.13
*/

// Imports
import java.awt.*;
import java.util.ArrayList;

//Declare class
public class Cannonball{
     //Declare variables
     private double xPosition;
     private double yPosition;
     private double xVelocity;
     private double yVelocity;
     //Constructor for Cannonball
     public Cannonball(double xPosition){
          this.xPosition = xPosition;
          yPosition = 0;
          xVelocity = 0;
          yVelocity = 0;
     }

     //Implement the method move
     public void move(double deltaSec){
          //Compute the distance travelled
          double xDistTraveled = xVelocity * deltaSec;
          double yDistTraveled = yVelocity * deltaSec + (1/2)
* -9.81 * deltaSec * deltaSec;
          xPosition = xPosition + xDistTraveled;
          yPosition = yPosition + yDistTraveled;
          yVelocity = yVelocity + -9.81 * deltaSec;
     }

     // Getting the current location of the cannonball
     public Point getLocation(){
          Point point = new Point((int) xPosition, (int) yPosition);
          return point;
     }
     // Shoot Method For Cannonbal
     public ArrayList<Point> shoot (double alpha, double v, double deltaSec){
          ArrayList<Point> points = new ArrayList<Point>();
          xVelocity = v * Math.cos(Math.toRadians(alpha));
          yVelocity = v * Math.sin(Math.toRadians(alpha));
          points.add(getLocation());
          move(deltaSec);
          points.add(getLocation());
          while (yPosition > 0){
               move(deltaSec);
               points.add(getLocation());
          }
          return points;
     }
}
