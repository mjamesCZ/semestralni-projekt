package start;

import game.Game;
import ui.GameUI;

/******************************************************************************
 * Z této třídy se spouští celá hra.
 *
 * @author Jakub Šlambor
 * @version 20.7.8
 ******************************************************************************/

public class StartGame {

    public static void main(String[] args) {
        Game game = new Game();
        GameUI gameUI = new GameUI(game);

        gameUI.start();
    }

}
