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
    void setTetriminoInCells() {
        cells[0][1] = 1;
        cells[0][2] = 1;
        cells[0][3] = 1;
        cells[1][2] = 1;
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
