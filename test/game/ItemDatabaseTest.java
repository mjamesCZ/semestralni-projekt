package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDatabaseTest {

    @Test
    void getItem() {
        Game game = new Game();

        assertNotNull(game.getItemDatabase().getItem("naradi"));
        assertEquals("ITEM ERROR", game.getItemDatabase().getItem("pneumatika").getName());
    }

    @Test
    void getRecipe() {
        Game game = new Game();

        assertEquals("doktorzhor", game.getItemDatabase().getRecipe("alpa", "absinth").getName());
        assertEquals("doktorzhor", game.getItemDatabase().getRecipe("absinth", "alpa").getName());
    }
}