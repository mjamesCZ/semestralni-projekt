package game;

import game.types.Goal;
import ui.ColorCodes;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/******************************************************************************
 * Třída sloužící pro ukládání cílů a nápovědy.
 ******************************************************************************/

public class Goals {
    private final LinkedHashMap<String, Goal> goals = new LinkedHashMap<>();
    private final ArrayList<String> help = new ArrayList<>();

    public Goals() {
        // Nastavení úkolů
        goals.put("naradi", new Goal("Oprav auto a dojeď do Night City. " + ColorCodes.BLACK_BOLD_BRIGHT + "Pokud si kdykoliv nebudeš vědět rady, použij příkaz 'napoveda'." + ColorCodes.RESET, "seqNeopravil jsi své auto.\nNo nic, zkusíš to dojít pěšky.\n" + ColorCodes.BLACK_BRIGHT + "O 3 dny později..." + ColorCodes.RESET + "\nJít pěšky asi nakonec nebyl ten nejlepší nápad. Jsi vyčerpaný, dehydratovaný.\nMusíš si odpočinout, už nemůžeš dál. Zavíráš oči.", "Auto bylo opraveno, můžeš vyrazit!"));

        goals.put("doktorzhor", new Goal("Najdi barmana a splň jeho úkol.", "", "Barman je spokojený a podpoří tě."));
        goals.put("zradloanoviny", new Goal("Najdi psa a splň jeho úkol.", "", "Pes je spokojený a podpoří tě."));
        goals.put("licence", new Goal("Najdi Kancelářskou Krysu a splň její úkol.", "", "Kancelářská Krysa je spokojena a podpoří tě."));

        goals.put("boss", new Goal("Poraz Řepkového muže.", "seqNezískal si dostatečnou podporu od obyvatel města.\nŘepkový muž zůstává vládcem Česka.", "Řepkový muž si vzal příliš mnoho dotací ze slovenské národní banky."));
        goals.put("penize", new Goal("", "seqUtratil si peníze za tanečnice v klubu.\nMoc se ti to líbilo, ale už nemůžeš získat všechny předměty pro Kancelářskou Krysu.", "Utratil si peníze v továrně a získal tak potřebné heslo! Zkus ho zkombinovat s papírem."));

        // Nastavení nápovědy
        help.add("Seber nářadí a poté si znovu promluv s mechanikem.");
        help.add("Najdi alpu a absinth (jsou někde na mapě) a poté je příkazem 'vyrobit' spoj dohromady.");
        help.add("Najdi žrádlo a Haló noviny a poté je příkazem 'vyrobit' spoj dohromady.");
        help.add("Nejdříve najdi papír a peníze, poté utrať peníze v továrně a získané heslo spoj s papírem příkazem 'vyrobit'.");
        help.add("Vše je splněno! Jdi do mrakodrapu a promluv si s Řepkovým mužem.");
    }

    public boolean isCompleted(String name) {
        return goals.containsKey(name) && goals.get(name).isCompleted();
    }

    public String complete(String name) {
        if (goals.containsKey(name))
            return goals.get(name).complete();

        return null;
    }

    public String fail(String name) {
        if (goals.containsKey(name))
            return goals.get(name).fail();

        return null;
    }

    /**
     * Vrátí další cíl podle toho, jestli jsou předchozí dokončené.
     * @return Další cíl
     */
    public String getNext() {
        for (Goal goal : goals.values())
            if (!goal.isCompleted())
                return goal.toString();

        return null;
    }

    /**
     * Vrátí korespondující nápovědu k aktiálnímu cíli.
     * @return Nápověda
     */
    public String getHelp() {
        int index = -1;

        for (Goal goal : goals.values()) {
            index++;

            if (!goal.isCompleted())
                break;
        }

        return help.get(index);
    }
}
