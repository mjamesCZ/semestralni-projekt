package ui;

import java.util.HashMap;

/******************************************************************************
 * Dlouhá, nepřehledná třída, ve které ukládám
 * delší řetězce textu tisknuté na terminálu
 ******************************************************************************/

public class StringVault {
    private final HashMap<String, String> screens = new HashMap<>();
    private final HashMap<String, String[]> sequences = new HashMap<>();

    public StringVault() {
        // Terminal resolution check
        String resolution = """
                %s========================================================================================================================
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                  Správná velikost                                                    ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ‖                                                                                                                      ‖
                ========================================================================================================================

                %sPro ideální zážitek ze hry nastav prosím terminál na velikost %s120x30
                Pokračuj stiskem klávesy ENTER...""".formatted(ColorCodes.YELLOW_BRIGHT, ColorCodes.CYAN_BRIGHT, ColorCodes.CYAN_BOLD_BRIGHT);
        screens.put("resolution", resolution);

        // The intro screen
        String menu = """
                %s








                                                ______      __                                __
                                               / ____/_  __/ /_  ___  _________  __  ______  / /__
                                              / /   / / / / __ \\/ _ \\/ ___/ __ \\/ / / / __ \\/ //_/
                                             / /___/ /_/ / /_/ /  __/ /  / /_/ / /_/ / / / / ,<
                                             \\____/\\__, /_.___/\\___/_/  / .___/\\__,_/_/ /_/_/|_|
                                                  /____/               /_/     %s     ___   ____  _________
                                                                                   |__ \\ / __ \\/__  ( __ )
                                                                                   __/ // / / /  / / __  |
                                                                                  / __// /_/ /  / / /_/ /
                                                                                 /____/\\____/  /_/\\____/
                                                                                 
                                                                                 
                                                                 ©CD PROJEKT BLUE, 2021






                """.formatted(ColorCodes.YELLOW_BRIGHT, ColorCodes.CYAN_BRIGHT);
        screens.put("menu", menu);


        // Oslava
        String oslava = """
                %s
                                
                                
                                                                                .''.
                                                    .''.      .        *''*    :_\\/_:     .
                                                   :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.
                                               .''.: /\\ :    /)\\   ':'* /\\ *  : '..'.  -=:o:=-
                                              :_\\/_:'.:::.  | ' *''*    * '.\\'/.'_\\(/_ '.':'.'
                                              : /\\ : :::::  =  *_\\/_*     -= o =- /)\\     '  *
                                               '..'  ':::' === * /\\ *     .'/.\\'.  ' %s._____
                                                   *        |   *..*         :       |.   |' .---"|
                                                     *      |     _           .--'|  ||   | _|    |
                                                     *      |  .-'|       __  |   |  |    ||      |
                                                  .-----.   |  |' |  ||  |  | |   |  |    ||      |
                                              ___'       ' /"\\ |  '-."".    '-'   '-.'    '`      |____
                                             ~~~~~~~~~~~~~~~~~~~~~~~~~~%sKONEC%s~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                             %s                       ~-~-~-~-~-~-~-~-~-~   /|
                                                       )      ~-~-~-~-~-~-~-~  /|~       /_|\\
                                                     _-H-__  -~-~-~-~-~-~     /_|\\    -~======-~
                                             ~-\\XXXXXXXXXX/~     ~-~-~-~     /__|_\\ ~-~-~-~
                                             ~-~-~-~-~-~    ~-~~-~-~-~-~    ========  ~-~-~-~
                                                   ~-~~-~-~-~-~-~-~-~-~-~-~-~ ~-~~-~-~-~-~
                      
                      
                """.formatted(ColorCodes.YELLOW_BRIGHT, ColorCodes.CYAN_BRIGHT, ColorCodes.PURPLE_BOLD_BRIGHT, ColorCodes.CYAN_BRIGHT, ColorCodes.BLUE);
        screens.put("oslava", oslava);

        // Oznámení o logování
        String[] logs = new String[]{"Hra bude zaznamenávat veškerou aktivitu (vstup a výstup) do textového souboru.",
                "Tento soubor nalezneš v aktuálním adresáři v podsložce 'Logs'."};
        sequences.put("logs", logs);

        // Prolog
        String[] prolog = new String[]{"", ColorCodes.PURPLE_BOLD_BRIGHT + "Probuď se sakra, Samuraji. Máme zde město ke spálení.",
                ColorCodes.BLACK_BOLD_BRIGHT + "\nJe rok 2078. Díky anexaci Slovenska roku 2051 se Česko stalo světovou velmocí.", "Praze se přezdívá Noční město. " +
                "Zemi vládne pevnou rukou Řepkový muž.", "Jsi Shee, Ostravský vandrák, který je odhodlaný stát se novým vládcem. Myslíš, že to dokážeš?", "Převeď významné obyvatele Nočního Města na svou stranu.", "Jenom oni ti umožní dovršit tvou cestu na trůn." + ColorCodes.RESET};
        sequences.put("prolog", prolog);

        String[] epilog = new String[]{"", ColorCodes.PURPLE_BOLD_BRIGHT + "Obyvatelé Prahy se za tebe postavili a ty jsi teď novým vládcem!",
                ColorCodes.BLACK_BOLD_BRIGHT + "\nRežie: Jiří Kára", "Scénář: Svarta Jump"};
        sequences.put("epilog", epilog);
    }

    public String getScreen(String name) {
        if (screens.containsKey(name))
            return screens.get(name);

        return "[DEV ERROR] Tento String není v trezoru!";
    }

    public String[] getSequence(String name) {
        if (sequences.containsKey(name))
            return sequences.get(name);

        return null;
    }
}
