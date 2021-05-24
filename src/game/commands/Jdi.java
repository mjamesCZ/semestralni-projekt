package game.commands;

import game.Game;
import game.types.Room;
import ui.ColorCodes;

/******************************************************************************
 * Provedení příkazu pošle hráče do zvolené místnosti.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Jdi(Game game, String description) implements ICommand {

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String execute(String[] params) {
        if (params.length == 0)
            return ColorCodes.RED + "Cílový prostor nebyl zadán!" + ColorCodes.RESET;

        String target = params[0];
        Room currentRoom = game.getGamePlan().getCurrentRoom();

        for (Room neighbour : currentRoom.getNeighbours()) {
            if (neighbour.getName().equals(target)) {

                // Špatný konec – neopravené auto
                if (neighbour.getName().equals("namesti") && !game.getGoals().isCompleted("naradi")) {
                    game.setStatus(Game.GameStatus.FAILED);
                    return game.getGoals().fail("naradi");
                }

                game.getGamePlan().setCurrentRoom(neighbour);

                return game.processInput("prostor");
            }
        }

        return ColorCodes.RED + "'" + target + "' nesousedí se současným prostorem!" + ColorCodes.RESET;
    }

}
