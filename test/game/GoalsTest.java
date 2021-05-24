package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoalsTest {

    @Test
    void isCompleted() {
        Game game = new Game();

        game.getGoals().complete("naradi");
        assertTrue(game.getGoals().isCompleted("naradi"));
        assertFalse(game.getGoals().isCompleted("doktorzhor"));
    }
}