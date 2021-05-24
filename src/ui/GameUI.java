package ui;

import game.Game;

import java.util.Scanner;

/******************************************************************************
 * Hlavní třída textového rozhraní.
 ******************************************************************************/

public class GameUI {
    private final Game game;
    private final StringVault stringVault = new StringVault();

    public GameUI(Game game) {
        this.game = game;
    }

    public void start() {
        Display display = new Display();

        // Zkrontroluje velikost terminálu při spuštění
        display.line(stringVault.getScreen("resolution"));

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // Zpráva oznamující záznam logů do složky
        display.sequence(stringVault.getSequence("logs"));

        // Hlavní menu a prolog
        display.line(stringVault.getScreen("menu"));
        display.sequence(stringVault.getSequence("prolog"));

        display.line(game.processInput("prostor"));

        // Hlavní herní smyčka
        while (game.getStatus().equals(Game.GameStatus.PLAYING)) {
            String callback = readInput();

            if (callback == null)
                continue;
            if (callback.startsWith("seq"))
                display.sequence(toArray(callback));
            else
                display.line(callback);
        }

        // Zprávy při ukončení
        switch (game.getStatus()) {
            case FAILED -> display.line(ColorCodes.RED_BOLD_BRIGHT + "Špatný konec. Hodně štěstí příště :)");
            case COMPLETED -> display.line(ColorCodes.GREEN_BOLD_BRIGHT + "VYHRÁL JSI! Díky, že jsi si zahrál :)");
            case EXITED -> display.line(ColorCodes.BLACK_BOLD_BRIGHT + "Hra byla ukončena uživatelem.");
        }

        // Extra oslava :)
        if (game.getStatus() == Game.GameStatus.COMPLETED) {
            display.sequence(stringVault.getSequence("epilog"));
            display.line(stringVault.getScreen("oslava"));
        }
    }

    /**
     * Přečte vstup uživatele.
     * @return Odpověď příkazu
     */
    private String readInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ColorCodes.CYAN_BOLD_BRIGHT + "\n> ");
        String input = scanner.nextLine();
        System.out.print(ColorCodes.RESET);

        return game.processInput(input);
    }

    private String[] toArray(String stirng) {
        return stirng.substring(3).split("\n");
    }

    public static void flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
