package start;

import game.*;

/******************************************************************************
 *  Z této třídy se spouští celá hra.
 *
 *  Kompilace:  javac StartGame.java
 *  Spuštění:   java -jar StartGame
 *  Dependencies: In.java StdIn.java StdOut.java
 ******************************************************************************/

public class StartGame {
    public static void main(String[] args) {
        System.out.println("Mapa:");

        System.out.println("=============\t\t=============");
        System.out.println("[\t    \uD83C\uDFDC️\t     |_____|\t    \uD83C\uDFD9️\t     ]");
        System.out.println("[\t Venkov\t     | _ _ _ |\t  Město\t     ]");
        System.out.println("[\t      ^\t     |_____|\t\t\t     ]");
        System.out.println("=============\t\t=============");
    }
}
