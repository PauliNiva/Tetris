package main;

import applogic.Field;

/**
 * Class for managing the game of Tetris.
 */
public class GameManager {

    private final Field field;

    /**
     * Sets up a standard sized playing field.
     */
    public GameManager() {
        field = new Field(20, 10);
    }
}
