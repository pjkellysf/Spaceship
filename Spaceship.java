//********************************************************************
//  Spaceship.java       Authors: Paul Clifford/ Patrick Kelly
//
//  Draws a spaceship and line at the mouse position.
//  Assigment number 6, Due November 5th, CS 111B, 1:00pm section
//********************************************************************

// Algorithm
// 1. Instantiate new Frame
// 2. Add Spaceship Panel to frame

import javax.swing.JFrame;
public class Spaceship
    {
    //-----------------------------------------------------------------
    // Creates and displays the application frame.
    //-----------------------------------------------------------------
    public static void main (String[] args)
    {
        JFrame frame = new JFrame ("Spaceship");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new SpaceshipPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
