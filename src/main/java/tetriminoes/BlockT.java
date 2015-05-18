package tetriminoes;

import java.awt.*;

/**
 * Sub-Class of Tetrimino that places the T shaped Tetrimino piece in Tetrimino
 * container.
 */
public class BlockT extends Tetrimino {

    /**
     * Puts the T shaped Tetrimino piece inside the container.
     */
    @Override
    void setTetriminoInBoxes() {
        boxes[1][1] = 1;
        boxes[1][2] = 1;
        boxes[1][3] = 1;
        boxes[2][2] = 1;
    }

    /**
     * Gets the color of the T shaped Tetrimino piece.
     * @return Color magenta.
     */
    @Override
    public Color getColor() {
        return Color.magenta;
    }
}
