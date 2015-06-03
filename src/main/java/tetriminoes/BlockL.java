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
    void setTetriminoInCells() {
        cells[0][1] = 1;
        cells[1][1] = 1;
        cells[2][1] = 1;
        cells[2][2] = 1;
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
