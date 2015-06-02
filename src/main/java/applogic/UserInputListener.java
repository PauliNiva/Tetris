package applogic;

import gui.PlayingFieldGUI;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Class for listening the inputs made by user.
 */
public class UserInputListener implements KeyListener{

    private final PlayingFieldGUI playingFieldGUI;

    /**
     * Creates the object that listens to the inputs made by user.
     * @param playingFieldGUI
     */
    public UserInputListener(PlayingFieldGUI playingFieldGUI) {
        this.playingFieldGUI = playingFieldGUI;
    }

    /**
     * Empty method, here because of the implementation of KeyListener.
     * @param event
     */
    @Override
    public void keyTyped(KeyEvent event) {
    }

    /**
     * Method that listens to key presses. If key pressed is left arrow, it moves the tetrimino piece
     * to the left. If key pressed is right arrow, it moves the tetrimino piece to the right. If the key
     * pressed is space bar, then the tetrimino piece is moved all the way down as far as it goes.
     * @param event
     */
    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            playingFieldGUI.getPlayingField().moveTetrimino(Direction.Left);
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            playingFieldGUI.getPlayingField().moveTetrimino(Direction.Right);
        }
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            while (playingFieldGUI.getPlayingField().getMapper().movementToDirectionIsValid(Direction.Down)) {
                playingFieldGUI.tick();
            }
        }

        playingFieldGUI.repaintPlayingField();
    }

    /**
     * Empty method, here because of the implementation of KeyListener.
     * @param event
     */
    @Override
    public void keyReleased(KeyEvent event) {
    }
}
