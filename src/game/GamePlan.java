package game;

import game.types.Npc;
import game.types.Room;
import game.types.RoomCoordinates;
import ui.ColorCodes;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/******************************************************************************
 * Třída herního plánu.
 ******************************************************************************/

public class GamePlan {
    private final LinkedList<Room> rooms = new LinkedList<>();
    private Room currentRoom;

    private final Game game;

    /**
     * Nastaví všechny prostory, předměty, postavy a jejich atributy.
     */
    public GamePlan(Game game) {
        this.game = game;

        // Základní nastavení prostorů
        rooms.add(new Room("bar", "🥂", new RoomCoordinates(0, 1), "Jsi v útulném baru, barman nalévá všem bez otázek."));
        rooms.add(new Room("park", "🌳", new RoomCoordinates(0, 2), "Jsi v rozkvetlém oparku plném tulipánů a starobylých stromů, pozůstatků staré civilizace."));
        rooms.add(new Room("venkov", "🏜", new RoomCoordinates(1, 0), "Jsi v ošunťelém servisu uprostřed pouště. Na obzoru však již vidíš svůj cíl, Night City."));
        rooms.add(new Room("namesti", "⛲", new RoomCoordinates(1, 1), "Jsi uprostřed rušného náměstí, desítky lidí zde sledují známou vodní show."));
        rooms.add(new Room("klub", "🕺", new RoomCoordinates(1, 2), "Jsi v moderním klubu. Hudba hraje tak hlasitě, že skoro nesylšíš sám sebe. Právě hraje: Yzomandias :)."));
        rooms.add(new Room("mrakodrap", "🏢", new RoomCoordinates(1, 3), "Jsi v mrakodrapu, který stoupá do nebes. Je to tady, poslední výzva. " + ColorCodes.RED + "Pořádně si rozmysli, jestli jsi připravený postavit se Řepkovému muži!" + ColorCodes.RESET));
        rooms.add(new Room("tovarna", "🏭", new RoomCoordinates(2, 1), "Jsi v obří továrně, ze které se naposledy kouřilo před mnoha lety."));
        rooms.add(new Room("kancelar", "📠", new RoomCoordinates(2, 2), "Jsi ve sterilně vypadající kanceláři přeplněné pracovníky pracujícími na počítačích. Všichni mají otevřený stejný program: Excel 420."));

        // Nastavení sousedních prostorů
        for (Room room : rooms)
            setNeighbours(room);

        // Nastavení předmětů v místnostech
        addItems(0, "absinth");
        addItems(1, "papir", "lavicka");
        addItems(2, "naradi", "auto", "zradlo");
        addItems(3, "penize", "fontana");
        addItems(4, "alpa", "tanecnice");
        addItems(6, "stroj");
        addItems(7, "halonoviny");

        // Nastavení postav a jejich odpovědí
        String[] barman = new String[] {"Nazdar.\nDělám tady pořádnou míchanici.\nVyrob a přines mi nový drink, " + ColorCodes.CYAN_UNDERLINED + "Doktor z hor" + ColorCodes.RESET + ", a pomůžu ti.", "S tím co máš drink nenamíchám.", "Správně! Konečně můžu pořádně mixovat.", "*škyt* Dáme ještě další rundu?"};
        String[] husky = new String[] {"Woof.\nDobrý den. Mohl bych poprosit o jedno pohlazení?\n"+ ColorCodes.BLACK_BRIGHT + "*pet* Kdo je hodný pejsek?" + ColorCodes.RESET + "\nJá!\nPokud chceš získat mojí přízeň, musíš mi přinést " + ColorCodes.CYAN_UNDERLINED + "žrádlo a něco na čtení" + ColorCodes.RESET + ".", "Přines mi žrádlo a něco ke čtení. A ještě to spoj dohromady.", "Woof! Tak se mi to líbí. Kvalitní žrádlo a počtení.", "Woof! Čekám na sysly, každou chvílí už musí vylézt."};
        String[] mechanik = new String[] {"Tahle stará herka už má svoje nejlepší dny za sebou, to je jistý.\nAle do města by tě dostat měla.\nDones mi " + ColorCodes.CYAN_UNDERLINED + "nářadí" + ColorCodes.RESET + " a já se na ni podívám.", "Přines mi nářadí, abych ti mohl pomoct.", "To je ono!\nAuto jsem ti opravil, tak štastnou cestu.", "Už jeď, mám tady v poušti hodně práce."};
        String[] krysa = new String[] {"Pozdrav pánbůh. Mé jméno je Martin Šlachta.\nUž jenom 20 dalších let v mé kóji než splatím svůj byt i auto.\nPřines mi WinRAR " + ColorCodes.CYAN_UNDERLINED + "licenci" + ColorCodes.RESET + " a pomůžu ti proti Řepkovému muži.", "Pořád čekám na tu licenci, bez ní tu hypotéku neslatím.", "Paráda! Konečně můžu jít dělat mou oblíbenou činnost.\nPracovat.", "Neruš mě, pracuju."};
        String[] boss = new String[] {"Tak to ty se mi hodláš postavit? Dobrá, tak uvidíme."};

        rooms.get(0).setNpc(new Npc("Barman Joe", barman, "doktorzhor"));
        rooms.get(1).setNpc(new Npc("Husky Juk", husky, "zradloanoviny"));
        rooms.get(2).setNpc(new Npc("Mechanik Tom", mechanik, "naradi"));
        rooms.get(7).setNpc(new Npc("Kancelářská Krysa", krysa, "licence"));
        rooms.get(5).setNpc(new Npc("Řepkový muž", boss, ""));

        // Hráč začíná na venkově
        currentRoom = rooms.get(2);
    }


    /**
     * Metoda pro automatické nastavení sousedních prostorů podle jejich souřadnic
     * @param center Prostor, kterému se sousedi nastavují
     */
    private void setNeighbours(Room center) {
        int centerRow = center.getCoords().getRow();
        int centerColumn = center.getCoords().getCol();

        List<Room> neighbours = rooms
                .stream()
                .filter(r -> Math.abs(centerRow - r.getCoords().getRow()) == 1 && centerColumn == r.getCoords().getCol() ||
                        Math.abs(centerColumn - r.getCoords().getCol()) == 1 && centerRow == r.getCoords().getRow())
                .collect(Collectors.toList());

        center.setNeighbours(neighbours);
    }


    /**
     * Metoda pro snadné přiřazení více předmětů do zadaného prostoru
     * @param roomIndex Index prostoru
     * @param items Jména předmětů, které chcete přidat
     */
    private void addItems(int roomIndex, String... items) {
        ItemDatabase itemDatabase = game.getItemDatabase();

        for (String item : items) {
            rooms.get(roomIndex).addItem(item, itemDatabase.getItem(item));
        }
    }

    public LinkedList<Room> getRooms() {
        return rooms;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
