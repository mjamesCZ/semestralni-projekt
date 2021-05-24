package game.commands;

import game.Game;

/******************************************************************************
 * Provedení příkazu ukončí hru.
 *
 * Implementuje: ICommand
 ******************************************************************************/

public record Konec(Game game, String description) implements ICommand {

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String execute(String[] params) {
		game.setStatus(Game.GameStatus.EXITED);
		return null;
	}

}
