package game.commands;

import game.AvailableCommands;
import ui.ColorCodes;

/******************************************************************************
 * Provedení příkazu vrátí všechny dostupné příkazy včetně možných parametrů a popisu.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Prikazy(AvailableCommands availableCommands, String description) implements ICommand {

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String execute(String[] params) {
        StringBuilder result = new StringBuilder();

        result.append(ColorCodes.YELLOW_BOLD + "Můžeš použít následující příkazy:");

        for (String key : availableCommands.getAvailableCommands().keySet())
            result.append("\n").append(ColorCodes.PURPLE_BOLD).append(key)
                    .append(ColorCodes.BLACK_BRIGHT + " ")
                    .append(availableCommands.getCommand(key).getDescription());

        result.append(ColorCodes.RESET);

        return result.toString();
    }
}
