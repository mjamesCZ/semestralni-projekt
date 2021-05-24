package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvailableCommandsTest {

    @Test
    void isAvailable() {
        Game game = new Game();
        AvailableCommands availableCommands = new AvailableCommands(game);

        assertTrue(availableCommands.isAvailable("sebrat"));
        assertFalse(availableCommands.isAvailable("vybrat"));
    }

    @Test
    void getAvailableCommands() {
        Game game = new Game();
        AvailableCommands availableCommands = new AvailableCommands(game);

        assertEquals(11, availableCommands.getAvailableCommands().size());
    }
}