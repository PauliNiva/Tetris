package tetriminoes;

import java.awt.*;

/**
 * Sub-Class of Tetrimino that places the J shaped Tetrimino piece in Tetrimino
 * container.
 */
public class BlockJ extends Tetrimino {

    /**
     * Puts the J shaped Tetrimino piece inside the container.
     */
    @Override
    void setTetriminoInCells() {
        cells[0][0] = 1;
        cells[0][1] = 1;
        cells[0][2] = 1;
        cells[1][2] = 1;
    }

    /**
     * Gets the color of the J shaped Tetrimino piece.
     * @return Color blue.
     */
    @Override
    public Color getColor() {
        return Color.blue;
    }
}
