package PongFury;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GamePanelTest {

    GamePanel gamePanel;

    // This method runs before each test to set up a new GamePanel instance
    @BeforeEach
    void setUp() {
        gamePanel = new GamePanel();
    }

    // Test to ensure the GamePanel and its components are initialized correctly
    @Test
    void testGamePanelInitialization() {
        assertNotNull(gamePanel, "GamePanel should be initialized");
        assertNotNull(gamePanel.ball, "Ball should be initialized");
        assertNotNull(gamePanel.player1, "Player 1 paddle should be initialized");
        assertNotNull(gamePanel.player2, "Player 2 paddle should be initialized");
        assertNotNull(gamePanel.score, "Score should be initialized");
    }

    // Test to verify that the newBall() method creates a new Ball object
    @Test
    void testNewBall() {
        gamePanel.newBall();
        assertNotNull(gamePanel.ball, "Ball should be created by newBall()");
    }

    // Test to verify that the newPaddles() method creates paddles for both players
    @Test
    void testNewPaddles() {
        gamePanel.newPaddles();
        assertNotNull(gamePanel.player1, "Player 1 paddle should be created by newPaddles()");
        assertNotNull(gamePanel.player2, "Player 2 paddle should be created by newPaddles()");
    }

    // Test to ensure the GamePanel's screen size matches the defined constants
    @Test
    void testScreenSize() {
        assertEquals(GamePanel.GAME_WIDTH, gamePanel.getPreferredSize().width, "Game width should match the defined constant");
        assertEquals(GamePanel.GAME_HEIGHT, gamePanel.getPreferredSize().height, "Game height should match the defined constant");
    }
}