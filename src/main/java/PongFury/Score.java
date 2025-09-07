package PongFury;

import java.awt.*;

/**
 * Manages and displays the game score
 * Team Member: ISAAC BATUNGA 3132606
 */
public class Score {
    // These need to be public for the test to access them
    public int player1;
    public int player2;
    public final int GAME_WIDTH;
    public final int GAME_HEIGHT;
    public Font font;

    /**
     * Constructor for Score class
     * @param gameWidth width of the game window
     * @param gameHeight height of the game window
     */
    public Score(int gameWidth, int gameHeight) {
        this.player1 = 0;
        this.player2 = 0;
        this.GAME_WIDTH = gameWidth;
        this.GAME_HEIGHT = gameHeight;
        this.font = new Font("Consolas", Font.PLAIN, 60);
    }

    /**
     * Draws the score on the game panel
     * @param g Graphics context for drawing
     */
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(font);

        // Draw player 1 score on the left side
        g.drawString(String.valueOf(player1), GAME_WIDTH/4, 50);

        // Draw player 2 score on the right side
        g.drawString(String.valueOf(player2), (GAME_WIDTH*3)/4, 50);
    }

    /**
     * Increments player 1's score
     */
    public void player1Scores() {
        player1++;
    }

    /**
     * Increments player 2's score
     */
    public void player2Scores() {
        player2++;
    }

    /**
     * Resets both players' scores to 0
     */
    public void resetScores() {
        player1 = 0;
        player2 = 0;
    }
}