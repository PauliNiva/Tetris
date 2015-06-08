package main;


import applogic.UserInputListener;
import gui.NextTetriminoGUI;
import gui.PlayingFieldGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Class for managing the game of Tetris.
 */
public class GameManager {

    private final PlayingFieldGUI playingFieldGUI;
    private JFrame app;
    private int delay;

    /**
     * Sets up a standard sized playing field and new JFrame
     * and parameters of to it. Then adds the playing field and next
     * Tetrimino shower to the JFrame and starts the game.
     * @throws InterruptedException is thrown if Thread.sleep() method is interrupted.
     */
    public GameManager() throws InterruptedException {
        playingFieldGUI = new PlayingFieldGUI(20, 10);
        app = new JFrame();
        newApp();
        app.add(playingFieldGUI);
        app.add(new NextTetriminoGUI(playingFieldGUI));
        delay = 400;
        start();
    }

    /**
     * Method that sets up the JFrame parameters.
     */
    private void newApp() {
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLayout(new FlowLayout());
        app.setSize(500, 600);
        app.setLocation(800, 400);
        app.setVisible(true);
        app.setTitle("Yet Another Tetris Clone");
        app.addKeyListener(new UserInputListener(this.playingFieldGUI));
    }

    /**
     * Method that starts the game and keeps it going until game over.
     * Additionally it checks if the difficulty level should be increased.
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {
        playingFieldGUI.addNewTetrimino();
        playingFieldGUI.repaintPlayingField();

        while (!playingFieldGUI.gameOver()) {
            if (playingFieldGUI.getPlayingField().getNumberOfRemovedRows() >= 10) {
                shortenTheDelay(); // Increases the difficulty by shortening the time that the thread sleeps.
                playingFieldGUI.getPlayingField().resetNumberOfRemovedRows();
            }
            playingFieldGUI.tick();
            Thread.sleep(delay);
        }
    }

    /**
     * Gets the playing field.
     * @return PlayingFieldGUI object.
     */
    public PlayingFieldGUI getPlayingField() {
        return playingFieldGUI;
    }

    /**
     * Method that sortens the delay by 25 milliseconds. Used when level
     * of difficulty is increased.
     */
    public void shortenTheDelay() {
        this.delay = this.delay - 25;
    }
}
