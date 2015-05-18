package tetriminoes;

import java.awt.*;

/**
 * Abstract class for all Tetrimino pieces.
 */
public abstract class Tetrimino {

    /**
     * Tableaux for holding a Tetrimino piece in, ergo Tetrimino piece holder.
     */
    final int[][] boxes;

    /**
     * Creates a new Tetrimino blocks by first making a 4 by 4 empty tableaux and then sets
     * the corresponding cells that are occupied by the specific Tetrimino piece to a value 1.
     * Value 1 marks that the cell contains one block of the specified Tetrimino and 0 marks that
     * it does not.
     */
    Tetrimino() {
        boxes = new int[4][4];
        setTetriminoInBoxes();
    }

    /**
     * Abstract method without an implementation that sets a specific Tetrimino inside the boxes tableaux.
     */
    abstract void setTetriminoInBoxes();

    /**
     * Method that gets the layout of the Tetrimino piece inside the box.
     * This method is used to get the orientation of the piece inside the boxes.
     * @return boxes tableaux that contains one Tetrimino piece.
     */
    public int[][] getLayout() {
        return boxes;
    }

    /**
     * Abstract method without an implementation that is used to get the color of a specific Tetrimino piece.
     * Tetrimino piece colors adhere to the Tetris companys standardization.
     * @return Color of the Tetrimino piece.
     */
    public abstract Color getColor();
}
