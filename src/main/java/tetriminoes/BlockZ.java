package tetriminoes;

import java.awt.*;

/**
 * Sub-Class of Tetrimino that places the Z shaped Tetrimino piece in Tetrimino
 * container.
 */
public class BlockZ extends Tetrimino {

    /**
     * Puts the Z shaped Tetrimino piece inside the container.
     */
    @Override
    void setTetriminoInBoxes() {
        boxes[1][1] = 1;
        boxes[1][2] = 1;
        boxes[2][2] = 1;
        boxes[2][3] = 1;
    }

    /**
     * Gets the color of the Z shaped Tetrimino piece.
     * @return Color red.
     */
    @Override
    public Color getColor() {
        return Color.red;
    }
}
