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
    void setTetriminoInCells() {
        cells[0][0] = 1;
        cells[0][1] = 1;
        cells[0][2] = 1;
        cells[0][3] = 1;
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
