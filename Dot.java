// Assignment #: 12
//         Name: Jose Zegarra
//    StudentID: 1208051893
//      Lecture: Lecture 4 10:30-11:45 TTH
//  Description: The Dot class represents a dot that is used for
//               drawing in the drawing panel.

import java.awt.*;

public class Dot {
	
	//Instance variables
	private int x; //x coordinate of dot
	private int y; //y coordinate of dot
	private Color color;
	private int DIAMETER; //diameter of dot
	
	//Constructor initializes instance variables
	public Dot(int x1, int y1, Color color1, int diameter)
	{
		x = x1;
		y = y1;
		color = color1;
		DIAMETER = diameter;
	}
	
	//Used for drawing the dot which is actually a small
	//oval
	public void draw(Graphics page)
	{
		page.setColor(color);
		page.fillOval(x, y, DIAMETER, DIAMETER);
	}
}
