package applogic;

import gui.PlayingFieldGUI;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Class for listening the inputs made by user.
 */
public class UserInputListener implements KeyListener {

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
     * Method that listens to key presses. If key pressed is left arrow, it moves the Tetrimino piece
     * to the left. If key pressed is right arrow, it moves the Tetrimino piece to the right. If the key
     * pressed is space bar, then the Tetrimino piece is moved all the way down as far as it goes. If the
     * pressed key is up arrow, the Tetrimino will rotate counterclockwise and if the pressed key is down
     * arrow, then the piece will rotate clockwise.
     * @param event KeyEvent (the key that was pressed (or the pressing was simulated) on keyboard).
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
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            playingFieldGUI.getPlayingField().rotateTetriminoCounterClockwise(Rotation.CounterClockwiseRotation);
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            playingFieldGUI.getPlayingField().rotateTetriminoClockwise(Rotation.ClockwiseRotation);
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
