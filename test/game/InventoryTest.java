package game;

import game.types.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void containsItem() {
        Game game = new Game();

        game.getInventory().putItem("success", new Item("success", "", true));
        game.getInventory().putItem("removed", new Item("removed", "", true));

        game.getInventory().removeItem("removed");

        assertTrue(game.getInventory().containsItem("success"));
        assertFalse(game.getInventory().containsItem("removed"));
    }

    @Test
    void getItems() {
        Game game = new Game();

        game.getInventory().putItem("test", new Item("test", "", true));
        game.getInventory().putItem("success", new Item("success", "", true));
        game.getInventory().putItem("fail", new Item("fail", "", false));

        assertEquals(3, game.getInventory().getItems().size());
    }
}