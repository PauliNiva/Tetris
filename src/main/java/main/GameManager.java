package main;

import applogic.PlayingField;

/**
 * Class for managing the game of Tetris.
 */
public class GameManager {

    private final PlayingField playingField;

    /**
     * Sets up a standard sized playing field.
     */
    public GameManager() {
        playingField = new PlayingField(20, 10);
    }

    /**
     * Gets the playing field.
     * @return PlayingField object.
     */
    public PlayingField getPlayingField() {
        return playingField;
    }
}
