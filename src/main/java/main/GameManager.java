package main;


import applogic.UserInputListener;
import gui.PlayingFieldGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Class for managing the game of Tetris.
 */
public class GameManager {

    private final PlayingFieldGUI playingFieldGUI;
    private JFrame app;

    /**
     * Sets up a standard sized playing field and new JFrame
     * and parameters of to it. Then adds the playing field to
     * JFrame and starts the game.
     * @throws InterruptedException
     */
    public GameManager() throws InterruptedException {
        playingFieldGUI = new PlayingFieldGUI(20, 10);
        app = new JFrame();
        newApp();
        app.add(playingFieldGUI);
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
     * Method that starts the game.
     * @throws InterruptedException
     */
    private void start() throws InterruptedException {
        playingFieldGUI.addNewTetrimino();
        playingFieldGUI.repaintPlayingField();

        while (!playingFieldGUI.gameOver()) {
            playingFieldGUI.tick();
            Thread.sleep(300);
        }
    }

    /**
     * Gets the playing field.
     * @return PlayingFieldGUI object.
     */
    public PlayingFieldGUI getPlayingField() {
        return playingFieldGUI;
    }
}
