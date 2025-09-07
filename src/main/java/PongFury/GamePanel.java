package PongFury;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Ball ball;
    Paddle player1, player2;
    Score score;

    public GamePanel() {
        this.setPreferredSize(SCREEN_SIZE);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        newBall();
        newPaddles();
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), (GAME_HEIGHT / 2) - (BALL_DIAMETER / 2), BALL_DIAMETER,new Random().nextBoolean() ? 1 : -1);
    }

    public void newPaddles() {
        player1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        player2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        ball.draw(g);
        player1.draw(g);
        player2.draw(g);
        score.draw(g);
    }

    public void move() {
        ball.move();
        player1.move();
        player2.move();
    }

    public void checkCollision() {
        // Bounce ball off top and bottom window edges
        if (ball.y <= 0 || ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }

        // Bounce ball off paddles
        if (ball.intersects(player1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.setXDirection(ball.xVelocity);
        }
        if (ball.intersects(player2)) {
            ball.xVelocity = -Math.abs(ball.xVelocity);
            ball.setXDirection(ball.xVelocity);
        }

        // Stop paddles at window edges
        if (player1.y <= 0) {
            player1.y = 0;
        }
        if (player1.y >= GAME_HEIGHT - PADDLE_HEIGHT) {
            player1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }
        if (player2.y <= 0) {
            player2.y = 0;
        }
        if (player2.y >= GAME_HEIGHT - PADDLE_HEIGHT) {
            player2.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }

        // Check if ball goes out of bounds
        if (ball.x <= 0) {
            score.player2++;
            newBall();
            newPaddles();
        }
        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player1++;
            newBall();
            newPaddles();
        }
    }

    public void run() {
        // Game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
            player2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
            player2.keyReleased(e);
        }
    }
}