package game.commands;

import game.Game;
import ui.ColorCodes;

/******************************************************************************
 * Provedení příkazu použije vybraný předmět na druhý.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Pouzit(Game game, String description) implements ICommand {

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String execute(String[] params) {
		if (params.length < 2)
			return ColorCodes.RED + "Musíš zadat kombinaci alespoň 2 předmětů." + ColorCodes.RESET;

		String first = params[0];
		String second = params[1];

		String currentRoomName = game.getGamePlan().getCurrentRoom().getName();

		if (game.getInventory().containsItem("penize")) {

			if (currentRoomName.equals("klub") && first.equals("penize") && second.equals("tanecnice")) {
				game.setStatus(Game.GameStatus.FAILED);
				return game.getGoals().fail("penize");
			}

			if (currentRoomName.equals("tovarna") && first.equals("penize") && second.equals("stroj")) {
				game.getInventory().removeItem("penize");
				game.getInventory().putItem("heslo", game.getItemDatabase().getItem("heslo"));
				return game.getGoals().complete("penize");
			}

		}

		return ColorCodes.BLACK_BRIGHT + "Tato kombinace použít nejde." + ColorCodes.RESET;
	}

}
