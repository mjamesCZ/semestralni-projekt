package game.commands;

import game.Goals;
import ui.ColorCodes;

/******************************************************************************
 * Provedení příkazu vrátí nápovědu v závislosti na momentálním úkolu.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Napoveda(Goals goals, String description) implements ICommand {

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String execute(String[] params) {
		return ColorCodes.PURPLE_BOLD_BRIGHT + "TIP: " + ColorCodes.RESET + goals.getHelp();
	}

}
