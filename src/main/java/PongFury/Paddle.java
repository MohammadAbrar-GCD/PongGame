package PongFury;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
 

public class Paddle extends Rectangle{
	
	int id;
	int yVelocity;
	int speed = 10;
	int startX; 
	int startY;
	
	Paddle(int x, int y, int PADDLE_WIDTH,int PADDLE_HEIGHT, int id){
		super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
        this.startY = y;
        this.startX = x;
       
	}
	
	public void keyPressed(KeyEvent e) {
	    if (id == 1) {  // Player 1 controls
	        if (e.getKeyCode() == KeyEvent.VK_W) yVelocity = -speed;  // Move up
	        if (e.getKeyCode() == KeyEvent.VK_S) yVelocity = speed;   // Move down
	    } else if (id == 2) {  // Player 2 controls
	        if (e.getKeyCode() == KeyEvent.VK_UP) yVelocity = -speed;  // Move up
	        if (e.getKeyCode() == KeyEvent.VK_DOWN) yVelocity = speed; // Move down
	    }
	}

	public void keyReleased(KeyEvent e) {
	    if (id == 1) {  // Player 1 stops moving
	        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
	            yVelocity = 0;
	        }
	    } else if (id == 2) {  // Player 2 stops moving
	        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
	            yVelocity = 0;
	        }
	    }
	}


	public void setYDirection(int yDirection) {
	    yVelocity = yDirection;
	}

	public int getYVelocity() {
	    return yVelocity; 
	}

	public void move() {
	    y += yVelocity;

	    // Prevent paddle from going off screen
	    if (y < 0) y = 0;
	    if (y > GamePanel.GAME_HEIGHT - height) y = GamePanel.GAME_HEIGHT - height;
	}

	public void resetPosition() {
	    this.y = startY; 
	}

	public void draw(Graphics g) {
	    g.setColor(Color.WHITE);
	    g.fillRect(x, y, width, height);
	}
}

    
	 

	
	

