package tetriminoes;

import java.awt.*;

/**
 * Sub-Class of Tetrimino that places the L shaped Tetrimino piece in Tetrimino
 * container.
 */
public class BlockL extends Tetrimino {

    /**
     * Puts the L shaped Tetrimino piece inside the container.
     */
    @Override
    void setTetriminoInBoxes() {
        boxes[2][0] = 1;
        boxes[1][0] = 1;
        boxes[1][1] = 1;
        boxes[1][2] = 1;
    }

    /**
     * Gets the color of the L shaped Tetrimino piece.
     * @return Color orange.
     */
    @Override
    public Color getColor() {
        return Color.orange;
    }
}
