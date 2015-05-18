package applogic;

import tetriminoes.Tetrimino;

import java.awt.*;

/**
 * Class for the boxes which together form the grid called the playing field.
 */
public class Box {

    private final int row;
    private final int column;
    private Color color;
    private static final Color DEFAULT_EMPTY_COLOR = Color.white;
    private boolean boxIsOccupied;

    /**
     * Makes a new box in a specific location as dictated by the coordinates from
     * the parametres.
     * @param row int that serves as an Y coordinate. That is at which row the box's place is
     *            in the box tableaux called the playing field.
     * @param column int that serves as an X coordinate. That is at which column the box's place is
     *            in the box tableaux called the playing field
     */
    public Box(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Sets that the box is occupied by Tetrimino block and changes the color of the block
     * accordingly.
     * @param tetrimino Which kind of Tetrimino is occupying the box.
     * @param boxIsOccupied boolean value telling that is there a Tetromino block in the box.
     * @return information about the color and the occupation of the box.
     */
    public Box setBoxIsOccupied(Tetrimino tetrimino, boolean boxIsOccupied) {
        this.boxIsOccupied = boxIsOccupied;
        color = ((boxIsOccupied && tetrimino != null) ? tetrimino.getColor() : DEFAULT_EMPTY_COLOR);
        return this;
    }

    /**
     * Method for checking if the box is occupied.
     * @return boolean value telling if the box is occupied.
     */
    public boolean getIsBoxOccupied() {
        return boxIsOccupied;
    }

    /**
     * Method for getting the color of the box.
     * @return color of the box.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Method for setting the color of the box.
     * @param color that the box is to be set.
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
