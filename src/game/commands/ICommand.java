package game.commands;

public interface ICommand {
	/**
	 * Provede daný příkaz.
	 * @param params Parametry příkazu
	 * @return Textová odpoveď výsledku příkazu
	 */
	String execute(String[] params);

	/**
	 * Vrátí popis daného příkazu.
	 * @return Popis příkazu
	 */
	String getDescription();
}
