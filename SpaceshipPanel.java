//********************************************************************
//  SpaceshipPanel.java       Authors: Clifford/Dos Santos/Kelly
//
//  Represents the primary drawing panel for the Spaceship program.
//********************************************************************
    import javax.swing.JPanel;
    import javax.swing.JButton;
    import javax.swing.JLabel;
    import java.awt.*;
    import java.awt.event.*;

    public class SpaceshipPanel extends JPanel
{
        private Point clickPoint = null;
        private Boolean lineFlag = false;
        private int shotCount   = 0;
        private int shipWidth   = 40;
        private int shipHeight  = 20;
        private int frameWidth  = 400;
        private int frameHeight = 400;
        private JButton btnReset;
        private JLabel counterLabel;
        private Color color1 = Color.red;
        private Color color2 = Color.cyan;
        private Color color3 = Color.green;
        private Color ranColor;
        //-----------------------------------------------------------------
        // Constructor: Sets up this panel to listen for mouse events.
        //-----------------------------------------------------------------
        public SpaceshipPanel()
       {
            ShipMouseListener listener = new ShipMouseListener();
            addMouseListener (listener);
            addMouseMotionListener (listener);
            // Reset button
            btnReset = new JButton ("Reset Count");
            counterLabel = new JLabel("Shots Fired: 0");
            counterLabel.setForeground(Color.red);
            btnReset.addActionListener (new ButtonListener());
            setLayout(new FlowLayout(FlowLayout.LEFT));
            add (btnReset);
            add (counterLabel);
            //Frame preferences
            setBackground (Color.black);
            setPreferredSize (new Dimension(frameWidth, frameHeight));
        }
        //-----------------------------------------------------------------
        // Draws a spaceship, random line, shot count, and project members names.
        //-----------------------------------------------------------------
        public void paintComponent (Graphics page)
        {
            super.paintComponent (page);
            page.setColor (Color.yellow);
            page.drawString("Paul Clifford, Amy Dos Santos, Patrick Kelly", 40, 390);
            if (clickPoint != null)
                page.fillOval (clickPoint.x - shipWidth/2, clickPoint.y - shipHeight/2, shipWidth, shipHeight);
            //Draw a random line
            int ranX = (int) Math.floor(Math.random()*frameWidth);
            int ranY = (int) Math.floor(Math.random()*frameHeight);
            //Random Color - Rewrite to use Array
            int ranColorNum = (int) Math.floor(Math.random()*3) + 1;
            if (ranColorNum == 1) {
                ranColor = (color1);     
            }
            if (ranColorNum == 2) {
                ranColor = (color2);
            }
            if (ranColorNum == 3) {
                ranColor = (color3);
            }
            //Draw Random Line with New Random Color
            if ((clickPoint != null) && (lineFlag == true)) {
                page.setColor (ranColor); 
                page.drawLine (clickPoint.x, clickPoint.y, ranX, ranY);
                counterLabel.setForeground(ranColor);
                counterLabel.setText("Shots Fired: " + shotCount);
                lineFlag = false;
            }            
        }
        // Sets the point at which to draw the next dot
        public void setPoint(Point pnt) {
            clickPoint = pnt;
        }
        //*****************************************************************
        // Represents the listener for all mouse events.
        //*****************************************************************

        private class ShipMouseListener implements MouseListener,
                                            MouseMotionListener
        {
        //--------------------------------------------------------------
        //  Updates the x and y position of the mouse when moved
        //--------------------------------------------------------------
        public void mouseMoved (MouseEvent event)
        {
            Point pnt = event.getPoint();
            setPoint(pnt);
            repaint();
        }
        //--------------------------------------------------------------
        //  Reports the x and y position of the mouse when clicked
        //--------------------------------------------------------------
        public void mousePressed (MouseEvent event)
        {
            Point pnt = event.getPoint();
            setPoint(pnt);
            lineFlag = true;
            shotCount += 1;
            repaint();
        }

        public void mouseReleased (MouseEvent event) {
			lineFlag = false;
			repaint();
			}

        //--------------------------------------------------------------
        //  Provide empty definitions for unused event methods.
        //--------------------------------------------------------------
        public void mouseEntered (MouseEvent event) {}
        public void mouseExited (MouseEvent event) {}
        public void mouseClicked (MouseEvent event) {}
        public void mouseDragged (MouseEvent event) {}
        }

        private class ButtonListener implements ActionListener
        {
        //--------------------------------------------------------------
        // Updates the counter and label when the button is pushed.
        //--------------------------------------------------------------
            public void actionPerformed (ActionEvent event)
            {
                shotCount = 0;
                counterLabel.setText("Shots Fired: " + shotCount);
                repaint();
            }
        }
    }
