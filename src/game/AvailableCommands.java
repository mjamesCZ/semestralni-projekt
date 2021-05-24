package game;

import game.commands.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

/******************************************************************************
 * Třída sloužící pro ukládání globálně dostupných příkazů
 ******************************************************************************/

public class AvailableCommands {
    private final LinkedHashMap<String, ICommand> availableCommands = new LinkedHashMap<>();

    public AvailableCommands(Game game) {
        // Základní příkazy
        availableCommands.put("prikazy", new Prikazy(this, "Zobrazí všechny dostupné příkazy."));
        availableCommands.put("jdi", new Jdi(game, "\033[0;96m[prostor]\033[0;90m Přejde do vybraného prostoru, pokud sousedí s tím současným."));
        availableCommands.put("napoveda", new Napoveda(game.getGoals(), "Poradí, pokud jsi se zasekl a nevíš, jak pokročit ve hře."));
        availableCommands.put("konec", new Konec(game, "Ukončí hru."));

        // Příkazy bez parametrů
        availableCommands.put("batoh", new Batoh(game.getInventory(), "Zobrazí obsah tvého batohu."));
        availableCommands.put("mapa", new Mapa(game.getGamePlan(), "Zobrazí mapu a prostory, kam můžeš jít."));
        availableCommands.put("prostor", new Prostor(game, "Zobrazí informace o tomto prostoru."));
        availableCommands.put("promluvit", new Promluvit(game, "Promluvíš si s postavou v tomto prostoru."));

        // Příkazy s parametry
        availableCommands.put("sebrat", new Sebrat(game, "\033[0;96m[předmět]\033[0;90m Sebere vybraný předmět, který se nachází v této místnosti."));
        availableCommands.put("pouzit", new Pouzit(game, "\033[0;96m[předmět v inventáři] [něco v prostoru]\033[0;90m Zkusí použít daný předmět."));
        availableCommands.put("vyrobit", new Vyrobit(game, "\033[0;96m[předmět v inventáři] [předmět v inventáři]\033[0;90m Pokusí se vyrobit něco nového z vybraných předmětů."));
    }


    public boolean isAvailable(String name) {
        return availableCommands.containsKey(name);
    }

    public ICommand getCommand(String name) {
        return availableCommands.get(name);
    }

    public HashMap<String, ICommand> getAvailableCommands() {
        return availableCommands;
    }
}
