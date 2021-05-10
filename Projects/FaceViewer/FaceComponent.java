import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class FaceComponent extends JComponent{
  public void paintComponent(Graphics g){

    // Recover Graphics2D
    Graphics2D g2 = (Graphics2D) g;

    // Color Set 1
    Color creme = new Color(210,180,140);
    g2.setColor(creme);

    // Face Shape
    Ellipse2D.Double face = new Ellipse2D.Double(165, 145, 185, 185);
    g2.draw(face);
    g2.fill(face);

    // Color Set 2
    Color BLACK = new Color(0,0,0);
    g2.setColor(Color.BLACK);

    // Eyes
    Ellipse2D.Double eye = new Ellipse2D.Double(205, 190, 30, 30);
    Ellipse2D.Double eye2 = new Ellipse2D.Double(280, 190, 30, 30);
    g2.draw(eye);
    g2.fill(eye);
    g2.draw(eye2);
    g2.fill(eye2);

    // Mouth
    Line2D.Double mouth = new Line2D.Double(210,280,313,280);
    g2.draw(mouth);

    // Color Set 3
    Color WHITE = new Color(255,255,255);
    g2.setColor(Color.WHITE);

    // Clouds
    Ellipse2D.Double cloud = new Ellipse2D.Double(55,50,70,50);
    Ellipse2D.Double cloud2 = new Ellipse2D.Double(70,70,80,40);
    Ellipse2D.Double cloud3 = new Ellipse2D.Double(20,70,80,40);
    Ellipse2D.Double cloud4 = new Ellipse2D.Double(330,70,70,50);
    Ellipse2D.Double cloud5 = new Ellipse2D.Double(350,90,80,40);
    Ellipse2D.Double cloud6 = new Ellipse2D.Double(310,90,80,40);
    g2.draw(cloud);
    g2.fill(cloud);
    g2.draw(cloud2);
    g2.fill(cloud2);
    g2.draw(cloud3);
    g2.fill(cloud3);
    g2.draw(cloud4);
    g2.fill(cloud4);
    g2.draw(cloud5);
    g2.fill(cloud5);
    g2.draw(cloud6);
    g2.fill(cloud6);

  }
}
