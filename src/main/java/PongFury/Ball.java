package PongFury;

import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle{

    Random random;
    int xVelocity;
    int yVelocity;

    // Constructor for the Ball class.
    Ball(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
        int  randomXDirection = random.nextInt(2);
        if(randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection);


        int  randomYDirection = random.nextInt(2);
        if(randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection);
    }

    // Stub method for the 'setXDirection' method.
    public void setXDirection(int randomXDirection){
        xVelocity = randomXDirection;
    }

    // Stub method for the 'setYDirection' method.
    public void setYDirection(int randomYDirection){
        yVelocity = randomYDirection;
    }

    // Stub method for the 'move' method.
    public void move(){
        x += xVelocity;
        y += yVelocity;
    }

    // Stub method for the 'draw' method.
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y, height, width);
    }
}
