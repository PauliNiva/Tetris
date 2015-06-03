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
    void setTetriminoInCells() {
        cells[1][1] = 1;
        cells[1][2] = 1;
        cells[2][1] = 1;
        cells[2][0] = 1;
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
