package PongFury;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    void testSetXDirectionMethod(){
        //Arrange
        Ball ball = new Ball(0, 0, 1, 1);
        //Act
        ball.setXDirection(4);
        //Assert
        assertEquals(4, ball.xVelocity);
    }

    @Test
    void testSetYDirectionMethod(){
        //Arrange
        Ball ball = new Ball(0, 0, 1, 1);
        //Act
        ball.setYDirection(6);
        //Assert
        assertEquals(6, ball.yVelocity);
    }

    @Test
    void testMoveMethod(){
        //Arrange
        Ball ball = new Ball(0, 0, 1, 1);
        //Act
        ball.move();
        //Assert
        assertEquals(1, ball.getX(), "X position should be 1 after moving");
        assertEquals(1, ball.getY(), "Y position should be 1 after moving");
    }

    @Test
    void testDraw() {
        // Create a BufferedImage and get Graphics
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // Create Ball and call draw()
        Ball ball = new Ball(50, 50, 10, 10);
        ball.draw(g);

        // Check that the color is set to WHITE
        assertEquals(Color.WHITE, ((Graphics2D) g).getPaint(), "Expected color to be set to WHITE.");
    }

}