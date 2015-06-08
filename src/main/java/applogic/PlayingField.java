package applogic;

import static applogic.Direction.*;
import tetriminoes.Tetrimino;
import util.TetriminoGenerator;

import java.awt.*;
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
    private static final Color DEFAULT_EMPTY_COLOR = Color.gray;
    private int rows;
    private int columns;
    private int numberOfRemovedRows;
    private Cell[][] cellsInPlayingField;
    private Tetrimino nextTetrimino;
    private TetriminoGenerator tetriminoGenerator;
    private boolean gameOver = false;
    private Mapper mapper;
    private List<TickListener> tickListeners;

    /**
     * Sets up the playing field.
     * @param rows how many rows there are to be in the playing field.
     * @param columns how many columns there are to be in the playing field.
     */
    public PlayingField(int rows, int columns) {
        numberOfRemovedRows = 0;
        this.rows = rows;
        this.columns = columns;
        createCells(rows, columns);
        tetriminoGenerator = new TetriminoGenerator();
        setNextTetrimino();
        mapper = new Mapper(this);
        tickListeners = new ArrayList<>();
    }

    /**
     * Creates the cells into the playing field. Overrides a method
     * in util.CellCallBack.
     * @param rows number of rows that the playing field is going to have.
     * @param columns number of columns that the playing field is going to have.
     */
    public void createCells(int rows, int columns) {
        cellsInPlayingField = new Cell[rows][columns];
        forEachCell(cellsInPlayingField, (row, column) -> {
            cellsInPlayingField[row][column] = (new Cell(row, column));
        });
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
    public Cell getCell(int row, int column) {
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

    /**
     * Gets cells from a specific row as a list.
     * @param row from which the cells are to be put in list.
     * @return cells from a specific row as a list.
     */
    private List<Cell> getCellsInRow(int row) {
        List<Cell> cellsInRow = new ArrayList<>();

        for (Cell cell : cellsInPlayingField[row]) {
            if (cell.getRow() == row) {
                cellsInRow.add(cell);
            }
        }

        return cellsInRow;
    }

    /**
     * Method that removes a specified row.
     * @param rowToBeRemoved that is to be removed.
     */
    public void removeRow(int rowToBeRemoved) {
        for (int row = rowToBeRemoved; row > 0; row--) {
            for (Cell cell : getCellsInRow(row)) {
                Cell cellAbove = getCell(row - 1, cell.getColumn());
                if (getMovingTetriminoContainer().contains(cellAbove)) {
                    cell.setCellIsOccupied(false);
                    cell.setColor(getDEFAULT_EMPTY_COLOR());
                } else {
                    cell.setCellIsOccupied(cellAbove.getIsCellOccupied());
                    cell.setColor(cellAbove.getColor());
                }
            }
        }
    }

    /**
     * Method that removes the complete rows from the playing field.
     * If a row is removed, it adds one to the counter that counts the
     * number of the rows that have been removed.
     */
    public void removeCompletedRows() {
        for (int row = 0; row < rows; row++) {
            boolean rowComplete = true;
            for (Cell cell : getCellsInRow(row)) {
                if (!cell.getIsCellOccupied()) {
                    rowComplete = false;
                }
            }
            if (rowComplete) {
                removeRow(row);
                numberOfRemovedRows++;
            }
        }
    }

    /**
     * Method for getting the falling Tetrimino container as a list of individual cells.
     * @return List of cells.
     */
    public List<Cell> getMovingTetriminoContainer() {
        return mapper.getTetriminoContainerAsList();
    }

    /**
     * Moves the Tetrimino to the direction specified by a parameter.
     * @param direction where the Tetrimino piece is to be moved.
     */
    public void moveTetrimino(Direction direction) {
        mapper.moveTetriminoContainer(direction);
    }

    /**
     * Gets the information if the game is over or not.
     * @return boolean value true is the game is over, false if not.
     */
    public boolean gameOver() {
        return gameOver;
    }

    /**
     * Adds a new Tetrimino piece into the playing field and
     * set the next Tetrimino that is going to appear.
     */
    public void addNewTetrimino() {
        addNewTetriminoToField(nextTetrimino);
        setNextTetrimino();
    }

    /**
     * Moves the game cycle(the internal clock of the game) ahead by one unit
     * by moving the tetrimo piece.
     * if the the tetrimino cannot move in that given cycle, the method calls
     * for a new Tetrimino piece and removal of completed rows.
     * Lastly it adds marking to a list that game has gone ahead one cycle.
     */
    public void tick() {
        if (!mapper.movementToDirectionIsValid(Direction.Down)) {
            addNewTetrimino();
            removeCompletedRows();
        }

        moveTetrimino(Down);

        for (TickListener listener : tickListeners) {
            listener.playingFieldHasTicked();
        }
    }

    /**
     * Gets the Mapper object that is associated with playing field.
     * @return Mapper object
     */
    public Mapper getMapper() {
        return this.mapper;
    }

    /**
     * Gets the default empty color.
     * @return Color white.
     */
    public static Color getDEFAULT_EMPTY_COLOR() {
        return DEFAULT_EMPTY_COLOR;
    }

    /**
     * Method that tells the mapper to rotate the Tetrimino piece clockwise.
     * @param rotation Clockwise.
     */
    public void rotateTetriminoClockwise(Rotation rotation) {
        mapper.rotateTetriminoContainer(rotation);
    }

    /**
     * Method that tells the mapper to rotate the Tetrimino piece counterclockwise.
     * @param rotation Counterclockwise.
     */
    public void rotateTetriminoCounterClockwise(Rotation rotation) {
        mapper.rotateTetriminoContainer(rotation);
    }

    /**
     * Adds classes that implement TickListener to a list containing TickListeners.
     * @param listener TickListener to be added in the list of TickListeners.
     */
    public void addTickListener(TickListener listener) {
        tickListeners.add(listener);
    }

    /**
     * Gets the number of rows that has been removed since the start of the game or last reset of the number.
     * @return number of removed rows as an int.
     */
    public int getNumberOfRemovedRows() {
        return numberOfRemovedRows;
    }

    /**
     * Resets the number of removed rows counter.
     */
    public void resetNumberOfRemovedRows() {
        this.numberOfRemovedRows = 0;
    }
}
