package ui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/******************************************************************************
 * Z této třídy se tiskne text na konzoli a do souboru.
 ******************************************************************************/

public class Display {
    private final String fileName;

    public Display() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();

        String destination = "./Logs/";

        try {
            Path path = Paths.get(destination);
            Files.createDirectory(path);
        } catch (IOException ignored) {}

        fileName = destination + "Log_" + dtf.format(now) + ".txt";
    }

    /**
     * Tiskne řádek na konzoli a do souboru.
     * @param line Vstup
     */
    public void line(String line) {
        System.out.println(line);
        writeToFile(line);
    }

    /**
     * Tiskne sekvenci na konzoli a do souboru.
     * @param lines Vstup
     */
    public void sequence(String[] lines) {
        for (String line : lines) {
            System.out.println(line);
            writeToFile(line);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Ukládá výstup konzole do souboru
     * @param input Vstup
     */
    private void writeToFile(String input) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            writer.append(input);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
