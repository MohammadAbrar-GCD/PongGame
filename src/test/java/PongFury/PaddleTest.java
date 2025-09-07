package PongFury;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Rectangle;
import org.junit.jupiter.api.Test;


class PaddleTest {
	
	Paddle paddle;

	void setUp() {
        // Create a Paddle object before each test
        paddle = new Paddle(50, 100, 20, 100, 1);
    }
	
	 @Test
	    void testSetYDirection() {
	        paddle.setYDirection(5);
	        assertEquals(5, paddle.getYVelocity()); 
	        
	    }


	 @Test
	    void testMove() {
	        paddle.setYDirection(5);
	        paddle.move();
	        assertEquals(105, paddle.y);
	    }
	 
	 void testResetPosition() {
	        paddle.y = 300; // Move paddle somewhere else
	        paddle.resetPosition();
	        assertEquals(100, paddle.y);
	        
	    }
	 
	 


}