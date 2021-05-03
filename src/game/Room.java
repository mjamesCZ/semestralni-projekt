package game;

import game.util.RoomCoordinates;

public class Room {
    private String roomName;
    private RoomCoordinates roomCoords;

//    postavy
//    itemy
//    lokální příkazy

    public Room(String roomName, int xCoord, int yCoord) {
        this.roomName = roomName;
        this.roomCoords = new RoomCoordinates(xCoord, yCoord);
    }

}
