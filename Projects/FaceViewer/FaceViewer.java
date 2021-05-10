import javax.swing.*;
import java.awt.Color;

public class FaceViewer{
  public static void main(String[] args) {

    // Creating new "Main Frame"
    JFrame frame = new JFrame();
    frame.setSize(500,500);
    frame.setTitle("Face");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Color for background
    Color blue = new Color(176,226,255);
    frame.getContentPane().setBackground(blue);

    // Adding the new Frame Component
    FaceComponent component = new FaceComponent();
    frame.add(component);

    // Setting the frame to "Visible"
    frame.setVisible(true);

  }
}


// Made by Constantine Linardakis
// 2020 / 23 / Sept.
// Project : Graphics P2.14Write a program to plot the face at right.
// Provide a class FaceViewer and a class FaceComponent.
