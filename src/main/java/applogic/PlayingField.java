package applogic;

import tetriminoes.Tetrimino;
import util.TetriminoGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.ForEachCell.forEachCell;

/**
 * Class for the playing field used as a container for the individual cells
 * that make up the playing field.
 */
public class PlayingField {

    private static final int START_ROW = 0;
    private static final int END_ROW = 3;
    private static final int START_COLUMN = 3;
    private static final int END_COLUMN = 6;
    private final int rows;
    private final int columns;
    private Cell[][] cellsInPlayingField;
    private Tetrimino nextTetrimino;
    private TetriminoGenerator tetriminoGenerator;
    private boolean gameOver = false;
    private Mapper mapper;

    /**
     * Sets up the playing field.
     * @param rows how many rows there are to be in the playing field.
     * @param columns how many columns there are to be in the playing field.
     */
    public PlayingField(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        createCells(rows, columns);
        tetriminoGenerator = new TetriminoGenerator();
        setNextTetrimino();
        mapper = new Mapper(this);
    }

    /**
     * Creates the cells into the playing field.
     * @param rows number of rows that the playing field is going to have.
     * @param columns number of columns that the playing field is going to have.
     */
    public void createCells(int rows, int columns) {
        cellsInPlayingField = new Cell[rows][columns];
        forEachCell(cellsInPlayingField, (row, col) -> cellsInPlayingField[row][col] = (new Cell(row, col)));
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
     * Method for getting a specified cell in the playing field.
     * @param row at which row the specific box resides.
     * @param column at which column the specific box resides.
     * @return the box which resides at the corresponding coordinates.
     */
    public Cell getCell(int row, int column){
        return cellsInPlayingField[row][column];
    }

    /**
     * Method for getting all the cells that make up the playing field.
     * @return all cells in the playing field as an arraylist.
     */
    public List<Cell> getAllCellsInPlayingField() {
        List<Cell> cellList = new ArrayList<>();
        for (Cell[] row : cellsInPlayingField) {
            cellList.addAll(Arrays.asList(row));
        }
        return cellList;
    }

    /**
     * Sets the next Tetrimino that is going to appear in the playing field.
     */
    public void setNextTetrimino() {
        nextTetrimino = tetriminoGenerator.createNewTetrimino();
    }

    /**
     * Gets the next Tetrimino that is going to appear in the playing field.
     * @return Tetrimino piece that is appearing next.
     */
    public Tetrimino getNextTetrimino() {
        return nextTetrimino;
    }

    /**
     * Method that checks if next Tetrimino piece fits in to the playing field.
     * @return false, if the piece overlaps another piece when it enters the field.
     * if not, then return value is true.
     */
    private Boolean newPieceFitsInField() {
        for (int row = START_ROW; row <= END_ROW; row++) {
            for (int column = START_COLUMN; column <= END_COLUMN;  column++) {
                if (getCell(row, column).getIsCellOccupied()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method that adds a new Tetrimino piece to the playing field if it fits in,
     * otherwise the game ends.
     * @param tetrimino piece that is going to be added next.
     */
    public void addNewTetriminoToField(Tetrimino tetrimino) {
        if (newPieceFitsInField()) {
            mapper.setNewTetrimino(tetrimino);
        } else {
            gameOver = true;
        }
    }

    /**
     * Gets the starting row where the tetrimino container appears.
     * @return int marking the row where the tetrimino container appears.
     */
    public int getSTART_ROW() {
        return START_ROW;
    }

    /**
     * Gets the starting column where the tetrimino container appears.
     * @return int marking the column where the tetrimino container appears.
     */
    public int getSTART_COLUMN() {
        return START_COLUMN;
    }
}
