package game;

import game.types.Item;
import game.types.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

/******************************************************************************
 * Třída sloužící pro uložení všech herních předmětů.
 ******************************************************************************/

public class ItemDatabase {
    private final HashMap<String, Item> itemDatabase = new HashMap<>();
    private final ArrayList<Recipe> recipes = new ArrayList<>();

    public ItemDatabase() {
        // Základní nastavení předmětů
        itemDatabase.put("naradi", new Item("naradi", "🧰", true));
        itemDatabase.put("alpa", new Item("alpa", "🧊", true));
        itemDatabase.put("absinth", new Item("absinth", "🥃", true));
        itemDatabase.put("doktorzhor", new Item("doktorzhor", "🍾", true));
        itemDatabase.put("zradlo", new Item("zradlo", "🍖", true));
        itemDatabase.put("halonoviny", new Item("halonoviny", "📰", true));
        itemDatabase.put("zradloanoviny", new Item("zradloanoviny", "🗃️", false));
        itemDatabase.put("licence", new Item("licence", "🧾", true));
        itemDatabase.put("papir", new Item("papir", "📋", true));
        itemDatabase.put("heslo", new Item("heslo", "🔏", true));
        itemDatabase.put("penize", new Item("penize", "💵", true));
        itemDatabase.put("stroj", new Item("stroj", "", false));
        itemDatabase.put("tanecnice", new Item("tanecnice", "", false));

        // (Okrasné předměty)
        itemDatabase.put("auto", new Item("auto", "", false));
        itemDatabase.put("lavicka", new Item("lavicka", "", false));
        itemDatabase.put("fontana", new Item("fontana", "", false));

        // Nastavení vyrobitelných předmětů
        recipes.add(new Recipe(itemDatabase.get("doktorzhor"), itemDatabase.get("alpa"), itemDatabase.get("absinth")));
        recipes.add(new Recipe(itemDatabase.get("licence"), itemDatabase.get("papir"), itemDatabase.get("heslo")));
        recipes.add(new Recipe(itemDatabase.get("zradloanoviny"), itemDatabase.get("zradlo"), itemDatabase.get("halonoviny")));
    }

    /**
     * Vrátí daný předmět,
     * @param name Jméno předmětu
     * @return Daný předmět
     */
    public Item getItem(String name) {
        return itemDatabase.getOrDefault(name, new Item("ITEM ERROR", "", false));
    }

    /**
     * Vrátí vyrobený předmět, pokud jde vyrobit.
     * @param firstComponent První komponent
     * @param secondComponent Druhý komponent
     * @return Vyrobený předmět
     */
    public Item getRecipe(String firstComponent, String secondComponent) {
        for (Recipe recipe : recipes)
            if (recipe.isValid(firstComponent, secondComponent))
                return recipe.getItem();

        return null;
    }
}
