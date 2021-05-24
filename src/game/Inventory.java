package game;

import game.types.Item;

import java.util.ArrayList;
import java.util.HashMap;

/******************************************************************************
 * Třída sloužící pro uložení hráčova batohu (inventáře).
 ******************************************************************************/

public class Inventory {
    private final HashMap<String, Item> inventory = new HashMap<>();

    /**
     * Vloží předmět do hráčova inventáře.
     * @param name Jméno předmětu
     * @param itemToAdd Předmět k přidání
     */
    public void putItem(String name, Item itemToAdd) {
        inventory.put(name, itemToAdd);
    }

    /**
     * Odstraní předmět z hráčova inventáře.
     * @param itemToRemove Předmět k odstranění
     */
    public void removeItem(String itemToRemove) {
        inventory.remove(itemToRemove);
    }

    /**
     * Zkontroluje, zda je daný předmět v inventáři
     * @param name Jméno hledaného předmětu
     * @return Je předmět v inventáři?
     */
    public boolean containsItem(String name) {
        return inventory.containsKey(name);
    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(inventory.values());
    }
}
