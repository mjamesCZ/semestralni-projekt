package game.commands;

import game.Game;
import game.types.Item;
import game.types.Room;
import ui.ColorCodes;

/******************************************************************************
 * Provedením příkazu se hráč pokusí sebrat vybraný předmět.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Sebrat(Game game, String description) implements ICommand {

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String execute(String[] params) {
		if (params.length == 0)
			return ColorCodes.RED + "Nebyl zadán předmět k sebrání!" + ColorCodes.RESET;

		Room currentRoom = game.getGamePlan().getCurrentRoom();
		Item itemToGet = currentRoom.getItem(params[0]);

		if (itemToGet == null)
			return ColorCodes.RED + "Takový předmět v tomto prostoru není." + ColorCodes.RESET;

		if (!itemToGet.isPickable())
			return ColorCodes.RED + "Tento předmět nesebereš." + ColorCodes.RESET;

		currentRoom.removeItem(params[0]);
		game.getInventory().putItem(params[0], itemToGet);
		return "Přidal jsi " + itemToGet + " do svého batohu.";
	}

}
