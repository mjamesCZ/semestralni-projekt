package game;

import java.util.LinkedList;

public class GamePlan {
    private final LinkedList<Room> rooms = new LinkedList<>();

    public GamePlan() {
        initializeGamePlan();
    }

    public void initializeGamePlan() {
        rooms.add(new Room("Venkov", 0, 1));
        rooms.add(new Room("Bar", 1, 0));
        rooms.add(new Room("Náměstí", 1, 1));
        rooms.add(new Room("Továrna", 1, 2));
        rooms.add(new Room("Park", 2, 0));
        rooms.add(new Room("Klub", 2, 1));
        rooms.add(new Room("Kancelář", 2, 2));
        rooms.add(new Room("Mrakodrap", 3, 1));
    }

    public void print() {
        for (Room room : rooms)
            System.out.println(room);
    }

}
