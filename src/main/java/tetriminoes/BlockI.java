package tetriminoes;

import java.awt.*;

/**
 * Sub-Class of Tetrimino that places the I shaped Tetrimino piece in Tetrimino
 * container.
 */
public class BlockI extends Tetrimino {

    /**
     * Puts the I shaped Tetrimino piece inside the container.
     */
    @Override
    void setTetriminoInBoxes() {
        boxes[1][0] = 1;
        boxes[1][1] = 1;
        boxes[1][2] = 1;
        boxes[1][3] = 1;
    }

    /**
     * Gets the color of the I shaped Tetrimino piece.
     * @return Color cyan.
     */
    @Override
    public Color getColor() {
        return Color.cyan;
    }
}
