package applogic;

import tetriminoes.Tetrimino;

import java.awt.*;

/**
 * Class for the cells which together form the grid called the playing field.
 */
public class Cell {

    private final int row;
    private final int column;
    private Color color;
    private static final Color DEFAULT_EMPTY_COLOR = Color.white;
    private boolean cellIsOccupied;

    /**
     * Makes a new cell in a specific location as dictated by the coordinates from
     * the parametres.
     * @param row int that serves as an Y coordinate. That is at which row the cells place is
     *            in the cell tableaux called the playing field.
     * @param column int that serves as an X coordinate. That is at which column the cells place is
     *            in the cell tableaux called the playing field
     */
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Sets that the cell is occupied by Tetrimino block and changes the color of the cell
     * accordingly.
     * @param tetrimino Which kind of Tetrimino is occupying the cell.
     * @param cellIsOccupied boolean value telling that is there a Tetromino block in the cell.
     * @return information about the color and the occupation of the cell.
     */
    public Cell setCellIsOccupied(Tetrimino tetrimino, boolean cellIsOccupied) {
        this.cellIsOccupied = cellIsOccupied;
        color = ((cellIsOccupied && tetrimino != null) ? tetrimino.getColor() : DEFAULT_EMPTY_COLOR);
        return this;
    }

    /**
     * Method to set cell as occupied with one parameter.
     * @param tetrimino piece that is occupying the cell.
     * @return calls setCellIsOccupied method with two parameters.
     */
    public Cell setCellIsOccupied(Tetrimino tetrimino) {
        return setCellIsOccupied(tetrimino, true);
    }

    /**
     * Changes the state of cell occupation (used after the piece
     * leaves the cell).
     * @param occupied boolean value that the cells value is to be changed.
     * @return calls setCellIsOccupied method with two parameters.
     */
    public Cell setCellIsOccupied(boolean occupied) {
        return setCellIsOccupied(null, occupied);
    }

    /**
     * Method for checking if the cell is occupied.
     * @return boolean value telling if the cell is occupied.
     */
    public boolean getIsCellOccupied() {
        return cellIsOccupied;
    }

    /**
     * Method for getting the color of the cell.
     * @return color of the cell.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Method for setting the color of the cell.
     * @param color which the cell is to be set.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the number of row.
     * @return number of row as an int.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Gets the number of column.
     * @return number of column as an int.
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Gets the default empty color.
     * @return Color white.
     */
    public Color getDefaultEmptyColor() {
        return DEFAULT_EMPTY_COLOR;
    }
}
