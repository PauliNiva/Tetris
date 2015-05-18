package applogic;

/**
 * Class for the playing field used as a container for the individual boxes
 * that make up the playing field.
 */
public class Field {

    private final int rows;
    private final int columns;
    private Box[][] boxesInBoard;

    /**
     * Sets up the playing field.
     * @param rows how many rows there are to be in the playing field.
     * @param colums how many columns there are to be in the playing field.
     */
    public Field(int rows, int colums) {
        this.rows = rows;
        this.columns = colums;
    }

    /**
     * Method for getting the number of rows in the playing field.
     * @return number of rows in the field.
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Method for getting the number of columns in the playing field.
     * @return number of columns in the field.
     */
    public int getColumns() {
        return this.columns;
    }

    /**
     * Method for getting a specified box in the playing field.
     * @param row at which row the specific box resides.
     * @param column at which column the specific box resides.
     * @return the box which resides at the corresponding coordinates.
     */
    public Box getBox(int row, int column){
        return boxesInBoard[row][column];
    }
}
