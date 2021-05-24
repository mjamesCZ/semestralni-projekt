package game.commands;

import game.Inventory;
import game.types.Item;
import ui.ColorCodes;

import java.util.ArrayList;

/******************************************************************************
 * Provedení příkazu vrátí obsah batohu (inventář) hráče.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Batoh(Inventory inventory, String description) implements ICommand {

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String execute(String[] params) {
		ArrayList<Item> inventory = inventory().getItems();

		if (inventory.size() == 0)
			return ColorCodes.BLACK_BRIGHT + "V batohu zatím nic není." + ColorCodes.RESET;

		StringBuilder result = new StringBuilder();

		result.append(ColorCodes.YELLOW_BOLD + "V batohu máš následující předměty:");

		for (Item item : inventory)
			result.append("\n").append(ColorCodes.BLACK_BRIGHT + "╚ ")
					.append(item.getSymbol()).append(" ").append(item);

		result.append(ColorCodes.RESET);

		return result.toString();
	}

}
