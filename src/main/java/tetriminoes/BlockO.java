package tetriminoes;

import java.awt.*;

/**
 * Sub-Class of Tetrimino that places the O shaped Tetrimino piece in Tetrimino
 * container.
 */
public class BlockO extends Tetrimino {

    /**
     * Puts the 0 shaped Tetrimino piece inside the container.
     */
    @Override
    void setTetriminoInBoxes() {
        boxes[1][1] = 1;
        boxes[1][2] = 1;
        boxes[2][1] = 1;
        boxes[2][2] = 1;
    }

    /**
     * Gets the color of the O shaped Tetrimino piece.
     * @return Color yellow.
     */
    @Override
    public Color getColor() {
        return Color.yellow;
    }
}
