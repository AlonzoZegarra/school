// Assignment #: 12
//         Name: Jose Zegarra
//    StudentID: 1208051893
//      Lecture: Lecture 4 10:30-11:45 TTH
//  Description: The DrawingPanel class defines a panel where dots
//               are drawn using javax.swing.Timer

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel
 {
  private int diameter; //diameter of a dot
  private Color currentColor;
  private ArrayList dotList;
  private int currentX, currentY;
  private int moveX, moveY; //how much to move horizontally or vertically
  private Timer timer;
  private int delay;   //delay of Timer

  //The constructor initializes instance variables, and starts the timer
  public DrawingPanel(Color color, Color backColor)
   {

 /**********************************************************
 To be completed
**********************************************************/
	  currentColor = color;
	  this.setBackground(backColor);
	  currentX = 0;
	  currentY = 0;
	  moveX = 3;
	  moveY = 3;
	  diameter = 5;
	  delay = 20;
	  dotList = new ArrayList();
	  MoveListener task = new MoveListener();
	  timer = new Timer(delay, task);
	  timer.start();
   }

/**********************************************************
multiple methods to be completed
**********************************************************/
  
  //Starts the timer
  public void resume()
  {
	  timer.start();
  }
  
  //Stops the timer
  public void suspend()
  {
	  timer.stop();
  }
  
  //Reverses the direction of the horizontal movement
  public void reverseX()
  {
	  if(moveX < 0)
		  moveX = moveX * (-1);
	  else if(moveX > 0)
		  moveX = moveX * (-1);
  }
  
  //Reverse the direction of the vertical movement
  public void reverseY()
  {
	  if(moveY < 0)
		  moveY = moveY * (-1);
	  else if(moveY > 0)
		  moveY = moveY * (-1);
  }
  
  //set the color of the dot
  public void setColor(Color another)
   {
       currentColor = another;
   }

  //get the color of the dot
  public Color getColor()
   {
       return currentColor;
   }
  
  //Used for setting the delay of the timer
  public void setDelay(int delayValue)
  {
	  timer.setDelay(delayValue);
  }
  
  //paintComponent method draws multiple dots in the dotList
  public void paintComponent(Graphics page)
   {
       super.paintComponent(page);
       
       //Goes through each object in the array list and
       //draws the dot.
       for(int i = 0; i < dotList.size(); i++)
       {
    	   ((Dot) dotList.get(i)).draw(page); //Draws the dot
       }
   }
  
  //MoveListener defined an action to be taken for each tick of the Timer.
  //It changes the dot's x and y coordinate using moveX and moveY
  //and draw a dot with the new coordinate. The dots drawn before will
  //remain in the panel. If the dot reaches any boundary, it will rebound
  //into the opposite direction
  private class MoveListener implements ActionListener
   {
        public void actionPerformed(ActionEvent event)
          {
        	currentX += moveX; //change x coordinate
        	currentY += moveY; //change y coordinate
        	
        	//If the x coordinate reaches the boundaries of the panel,
        	//it reverses the horizontal direction.
        	if(currentX <= 0 || currentX >= getSize().getWidth()-diameter)
        		reverseX();
        	
        	//If the y coordinate reaches the boundaries of the panel,
        	//it reverses the vertical direction.
        	if(currentY <= 0 || currentY >= getSize().getHeight()-diameter)
        		reverseY();
        	
        	//Creates a new Dot object and adds it to the list then repaints
        	//the panel
        	Dot newDot = new Dot(currentX,currentY,currentColor,diameter);
        	dotList.add(newDot);
        	repaint();
          }
   }
 }

