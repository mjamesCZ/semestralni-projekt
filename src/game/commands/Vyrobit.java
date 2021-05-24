package game.commands;

import game.Game;
import game.Inventory;
import game.types.Item;
import ui.ColorCodes;

/******************************************************************************
 * Provedením příkazu se hráč pokusí vyrobit nový předmět z dvou komponentů.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Vyrobit(Game game, String description) implements ICommand {

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String execute(String[] params) {
		if (params.length < 2)
			return ColorCodes.RED + "Musíš zadat kombinaci alespoň 2 předmětů." + ColorCodes.RESET;

		String firstComponent = params[0];
		String secondComponent = params[1];

		Item crafted = game.getItemDatabase().getRecipe(firstComponent, secondComponent);

		if (crafted != null) {
			Inventory inventory = game.getInventory();

			if (inventory.containsItem(firstComponent) && inventory.containsItem(secondComponent)) {
				inventory.removeItem(firstComponent);
				inventory.removeItem(secondComponent);

				inventory.putItem(crafted.getName(), crafted);

				return "Vyrobil jsi " + crafted + " a přidal ho do svého batohu.";
			}

			return ColorCodes.RED + "Snažíš se vyrábět z předmětů, které nemáš!" + ColorCodes.RESET;
		}

		return ColorCodes.BLACK_BRIGHT + "Z této kombinace předmětů nic vyrobit nejde." + ColorCodes.RESET;
	}

}
