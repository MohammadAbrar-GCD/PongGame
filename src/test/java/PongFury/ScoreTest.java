package PongFury;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {
    @Test
    public void testScoreInitialization() {
        Score score = new Score(800, 600);

        assertEquals(0, score.player1);
        assertEquals(0, score.player2);
        assertEquals(800, score.GAME_WIDTH);
        assertEquals(600, score.GAME_HEIGHT);
        assertNotNull(score.font);
    }
}