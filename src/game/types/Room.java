package game.types;

import ui.ColorCodes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Room {
    private final String name;
    private final String symbol;
    private final String description;

    private final RoomCoordinates coords;
    private List<Room> neighbours = new LinkedList<>();

    private final HashMap<String, Item> items = new HashMap<>();
    private Npc npc = null;


    public Room(String name, String symbol, RoomCoordinates coordinates, String description) {
        this.name = name;
        this.symbol = symbol;
        this.coords = coordinates;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }

    public RoomCoordinates getCoords() {
        return coords;
    }

    public List<Room> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Room> neighbours) {
        this.neighbours = neighbours;
    }

    public void addItem(String name, Item itemToAdd) {
        items.put(name, itemToAdd);
    }

    public void removeItem(String name) {
        items.remove(name);
    }

    public Item getItem(String name) {
        return items.get(name);
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }

    public Npc getNpc() {
        return npc;
    }

    @Override
    public String toString() {
        return symbol + " " + ColorCodes.YELLOW_BOLD_BRIGHT + name + ColorCodes.RESET;
    }
}
