package game;

public interface IGame {
    /**
     * Metoda zpracovávající vstup uživatele.
     * @param input Vstup uživatele
     * @return Textový výstup
     */
    String processInput(String input);

    /**
     * Metoda pro zkontrolování stavu hry (ještě se hraje, nebo už je hra ukončena?)
     * @return Status hry (PLAYING; FAILED; COMPLETED; EXITED)
     */
    Game.GameStatus getStatus();

    /**
     * Nastavení stavu hry
     * @param status Status hry (FAILED; COMPLETED; EXITED)
     */
    void setStatus(Game.GameStatus status);
}
