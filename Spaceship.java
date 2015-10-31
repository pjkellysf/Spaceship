//********************************************************************
//  Spaceship.java       Authors: Clifford/Dos Santos/Kelly
//
//  Draws a spaceship and line at the mouse position.
//********************************************************************

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
