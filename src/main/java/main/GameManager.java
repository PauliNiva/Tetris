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
    private JFrame askForNewGame;
    private JLabel scoreLabel;
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
        delay = 400;
        start();
    }

    /**
     * Method that sets up the JFrame parameters.
     */
    private void newApp() {
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLayout(new FlowLayout());
        app.setSize(600, 600);
        app.setLocation(800, 400);
        app.setTitle("Yet Another Tetris Clone");
        app.addKeyListener(new UserInputListener(this.playingFieldGUI));
        app.add(playingFieldGUI);
        app.add(new NextTetriminoGUI(playingFieldGUI));
        scoreLabel = new JLabel(getScore());
        app.add(scoreLabel);
    }

    /**
     * Method that starts the game and keeps it going until game over.
     * Additionally it checks if the difficulty level should be increased.
     * @throws InterruptedException Thrown if Thread.sleep() is interrupted.
     */
    public void start() throws InterruptedException {
        app.setVisible(true);
        playingFieldGUI.addNewTetrimino();
        playingFieldGUI.repaintPlayingField();

        while (!playingFieldGUI.gameOver()) {
            scoreLabel.setText(getScore());
            if (playingFieldGUI.getPlayingField().getLevelCounter() >= 10) {
                shortenTheDelay(); // Increases the difficulty by shortening the time that the thread sleeps.
                playingFieldGUI.getPlayingField().resetNumberOfRemovedRows();
            }
            playingFieldGUI.tick();
            Thread.sleep(delay);
        }
        app.removeAll();
        app.dispose();

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

    /**
     * Method for getting the score that the player has.
     * @return Score óf the player as int.
     */
    public String getScore() {
        return this.playingFieldGUI.getPlayingField().getScore();
    }
}
