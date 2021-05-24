package game;

import game.commands.ICommand;
import ui.ColorCodes;

import java.util.Arrays;
import java.util.Locale;

/******************************************************************************
 * Hlavní herní třída, poskytuje komunikaci mezi jednotlivými herními systémy
 ******************************************************************************/

public class Game implements IGame {
    private final ItemDatabase itemDatabase = new ItemDatabase();
    private final GamePlan gamePlan = new GamePlan(this);
    private final Inventory inventory = new Inventory();
    private final Goals goals = new Goals();
    private final AvailableCommands availableCommands = new AvailableCommands(this);

    private GameStatus status = GameStatus.PLAYING;
    public enum GameStatus {
        PLAYING,
        FAILED,
        COMPLETED,
        EXITED
    }


    public String processInput(String input) {
        String[] destructured = input.toLowerCase(Locale.ROOT).split("\\s+");

        String command = destructured[0];
        String[] params = Arrays.copyOfRange(destructured, 1, destructured.length);

        if (command.isEmpty())
            return null;

        if (availableCommands.isAvailable(command)) {
            ICommand newCommand = availableCommands.getCommand(command);
            return newCommand.execute(params);
        }

        return ColorCodes.RED + "Zadaný příkaz neexistuje. Dostupné příkazy zobrazíš napsáním '" +
                        ColorCodes.RED_BOLD + "PRIKAZY" + ColorCodes.RED + "'" + ColorCodes.RESET;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public ItemDatabase getItemDatabase() {
        return itemDatabase;
    }

    public GamePlan getGamePlan() {
        return gamePlan;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Goals getGoals() {
        return goals;
    }
}
