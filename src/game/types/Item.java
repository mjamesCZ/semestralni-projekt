package game.types;

import ui.ColorCodes;

public class Item {
    private final String name;
    private final String symbol;
    private final boolean pickable;

    public Item(String name, String symbol, boolean pickable) {
        this.name = name;
        this.symbol = symbol;
        this.pickable = pickable;
    }


    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isPickable() {
        return pickable;
    }

    @Override
    public String toString() {
        return ColorCodes.CYAN_UNDERLINED + name + ColorCodes.RESET;
    }
}
