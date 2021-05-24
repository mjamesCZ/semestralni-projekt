package game.commands;

import game.Game;
import game.types.Item;
import game.types.Room;
import ui.ColorCodes;
import ui.GameUI;

import java.util.stream.Collectors;

/******************************************************************************
 * Provedení příkazu vrátí informace o aktuálním prostoru.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Prostor(Game game, String description) implements ICommand {

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String execute(String[] params) {
		Room currentRoom = game.getGamePlan().getCurrentRoom();
		StringBuilder result = new StringBuilder();

		// Další cíl
		result.append(ColorCodes.PURPLE_BOLD_BRIGHT).append("DALŠÍ CÍL: ").append(ColorCodes.RESET)
				.append(game.getGoals().getNext()).append("\n");

		// Mapa
		result.append(game.processInput("mapa"))
				.append(currentRoom.toString()).append(" ")
				.append(currentRoom.getDescription()).append(" ");

		// Pokud se v prostoru nachází předmět nebo postava, přidej řádek
		if (currentRoom.getItems().size() > 0 || currentRoom.getNpc() != null) {
			result.append("\n");
		}

		// V případě předmětů v prostoru
		if (currentRoom.getItems().size() > 0) {
			result.append("V prostoru se nachází ");

			result.append(currentRoom.getItems().values().stream()
							.map(Item::toString)
							.collect(Collectors.joining(", "))
			).append(". ");
		}

		// V případě postavy
		if (currentRoom.getNpc() != null)
			result.append(currentRoom.getNpc().toString()).append(" ti chce něco říct.");

		// Jediná závislost na konzoli, při refactoringu na GUI stačí odstranit
		GameUI.flush();

		return result.toString();
	}

}
