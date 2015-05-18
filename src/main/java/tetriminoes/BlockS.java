package tetriminoes;

import java.awt.*;

/**
 * Sub-Class of Tetrimino that places the S shaped Tetrimino piece in Tetrimino
 * container.
 */
public class BlockS extends Tetrimino {

    /**
     * Puts the S shaped Tetrimino piece inside the container.
     */
    @Override
    void setTetriminoInBoxes() {
        boxes[2][1] = 1;
        boxes[2][2] = 1;
        boxes[1][2] = 1;
        boxes[1][3] = 1;
    }

    /**
     * Gets the color of the S shaped Tetrimino piece.
     * @return Color green.
     */
    @Override
    public Color getColor() {
        return Color.green;
    }
}
