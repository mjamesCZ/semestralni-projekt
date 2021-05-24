package game;

import game.types.RoomCoordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamePlanTest {

    @Test
    void getRooms() {
        Game game = new Game();

        assertEquals(8, game.getGamePlan().getRooms().size());
    }

    @Test
    void getCurrentRoom() {
        Game game = new Game();

        assertEquals(0, game.getGamePlan().getCurrentRoom().getCoords().getCol());
        assertEquals(1, game.getGamePlan().getCurrentRoom().getCoords().getRow());

        assertEquals(1, game.getGamePlan().getCurrentRoom().getNeighbours().size());
    }
}