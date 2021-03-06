package applogic;


import tetriminoes.Tetrimino;

import java.util.ArrayList;
import java.util.List;

import static util.ForEachCell.forEachCell;

/**
 * Class that maps the whereabouts of the Tetrimino piece in playing field.
 */
public class Mapper {

    private PlayingField playingField;
    private Tetrimino tetrimino;
    private Cell[][] tetriminoContainer;
    private Rotator rotator;
    private RotationValidator rotationValidator;
    int rowFixPoint; // cell at the x-coordinate 0 of the Tetrimino container.
    int columnFixPoint; // cell at the y-coordinate 0 of the Tetrimino container.

    /**
     * Constructor that uses the current playing field as a playingField.
     * @param playingField field which is to be mapped.
     */
    public Mapper(PlayingField playingField) {
        this.playingField = playingField;
        rotator = new Rotator();
    }

    /**
     * Method that sets a new Tetrimino piece in the container to a playingField.
     * @param tetrimino that is about to be placed in a conttainer and set to a playingField.
     */
    public void setNewTetrimino(Tetrimino tetrimino) {
        this.tetrimino = tetrimino;
        tetriminoContainer = containerForNewTetrimino(playingField.getSTART_ROW(), playingField.getSTART_COLUMN());
    }

    /**
     * Method that makes a new container for a new Tetrimino piece.
     * @param startRow place in rows where the container is placed.
     * @param startColumn place in columns where the container is placed.
     * @return Tetrimino container that has a Tetrmino inside.
     */
    public Cell[][] containerForNewTetrimino(int startRow, int startColumn) {
        Cell[][] newTetriminoContainer = new Cell[4][4];

        rowFixPoint = startRow;
        columnFixPoint = startColumn;

        forEachCell(tetrimino.getLayout(), (row, column) -> {
            newTetriminoContainer[row][column] = tetrimino.getLayout()[row][column] == 0 ? null :
                    playingField.getCell(startRow + row, startColumn + column).setCellIsOccupied(tetrimino);
        });

        return newTetriminoContainer;
    }

    /**
     * Gets the Tetrimino container.
     * @return Cell[][] object that acts as a Tetrimino container.
     */
    public Cell[][] getTetriminoContainer() {
        return this.tetriminoContainer;
    }

    /**
     * Method for getting the cells from a Tetrimino container as a list.
     * @return List of cells.
     */
    public List<Cell> getTetriminoContainerAsList() {
        List<Cell> cellList = new ArrayList<>();

        for (Cell[] cells : tetriminoContainer) {
            for (Cell cell : cells) {
                if (cell != null) cellList.add(cell);
            }
        }

        return cellList;
    }

    /**
     * Moves the Tetrimino container to a direction specified by the parameter.
     * @param direction specifies the direction where the Tetrimino piece is to be moved.
     */
    public void moveTetriminoContainer(Direction direction) {
        if (movementToDirectionIsValid(direction)) {
            setAllCells(tetriminoContainer, false);

            rowFixPoint += direction.getRowChange();
            columnFixPoint += direction.getColumnChange();

            forEachCell(tetriminoContainer, (row, column) -> {
                tetriminoContainer[row][column] = cellInNewPosition(direction, tetriminoContainer[row][column]);
            });
        }
    }

    /**
     * Method that checks that the movement of the Tetrimino piece is valid.
     * @param direction direction where the Tetrimino piece is moving.
     * @return boolean value for the validity of the movement. True if valid. False if not.
     */
    public boolean movementToDirectionIsValid(Direction direction) {
        for (Cell cell : getTetriminoContainerAsList()) {
            if (newCellIsAlreadyOccupied(direction, cell)) {
                return false;
            }
            if (!direction.checkIfMoveIsValid(cell, this.playingField)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Gets the cell at a new position if the cell is not null.
     * @param direction direction where the new cell is at.
     * @param cell that is moving at the playing field.
     * @return the moving Cell object.
     */
    public Cell cellInNewPosition(Direction direction, Cell cell) {
        if (cell != null) {
            return playingField.getCell(cell.getRow() + direction.getRowChange(),
                    cell.getColumn() + direction.getColumnChange()).setCellIsOccupied(tetrimino);
        }

        return cell;
    }

    /**
     * Sets the boolean value for all cells in a two dimensional Cell object tableux.
     * @param cells two dimensional tableaux consisting Cell objects.
     * @param occupied boolean value which the cells in the tableaux are to be set.
     */
    public void setAllCells(Cell[][] cells, boolean occupied) {
        forEachCell(cells, (row, column) -> {
            if (cells[row][column] != null) {
                cells[row][column].setCellIsOccupied(tetrimino, occupied);
            }
        });
    }

    /**
     * Method that checks if the new cell is already occupied.
     * @param direction where the Tetrimino piece is moving.
     * @param cell of a Tetrimino piece.
     * @return boolean value true if the cell is already occupied by another tetrimino piece, false otherwise.
     */
    private boolean newCellIsAlreadyOccupied(Direction direction, Cell cell) {
        return getMapCell(direction, cell).getIsCellOccupied() &&
                (!getTetriminoContainerAsList().contains(new Cell(newRow(direction, cell), newColumn(direction, cell))));
    }

    /**
     * Gets a Cell object from the direction where the Tetrimino piece is heading.
     * @param direction where the Tetrimino piece is heading.
     * @param cell that is part of the moving Tetrimino piece.
     * @return The corresponding Cell object.
     */
    private Cell getMapCell(Direction direction, Cell cell) {
        return playingField.getCell(newRow(direction, cell), newColumn(direction, cell));
    }

    /**
     * Utility method for another methods to know which column the new cell is going to be.
     * @param direction where the cell that is part of a Tetrimino piece is heading.
     * @param cell that is moving as a part of a moving Tetrimino piece.
     * @return the new column as a int.
     */
    private int newColumn(Direction direction, Cell cell) {
        return cell.getColumn() + direction.getColumnChange() > getTotalMapColumns() - 1 ? getTotalMapColumns() - 1 :
                (cell.getColumn() + direction.getColumnChange() < 0 ? 0 : cell.getColumn() + direction.getColumnChange());
    }

    /**
     * Utility method for another methods to know which row the new cell is going to be.
     * @param direction where the cell that is part of a Tetrimino piece is heading.
     * @param cell that is moving as a part of a moving Tetrimino piece.
     * @return the new row as a int.
     */
    private int newRow(Direction direction, Cell cell) {
        return cell.getRow() + direction.getRowChange() > getTotalMapRows() - 1 ? getTotalMapRows() - 1 : cell.getRow() + direction.getRowChange();
    }

    /**
     * Gets to total number of of rows in playingField.
     * @return numbers of rows in playingField as int.
     */
    public int getTotalMapRows() {
        return playingField.getRows();
    }

    /**
     * Gets to total number of of columns in playingField.
     * @return number of columns in playingField as int.
     */
    public int getTotalMapColumns() {
        return playingField.getColumns();
    }

    /**
     * Gets the current Tetrimino piece.
     * @return current Tetrimino piece.
     */
    public Tetrimino getTetrimino() {
        return this.tetrimino;
    }

    /**
     * Method that initializes rotation of the Tetrimino container. First it check if the
     * rotation is valid and then is sets up a new layout for the rotated
     * Tetrimino as it rotates the piece at the same time and lastly it sets up a container for it.
     * @param rotation Direction of the rotation (either clockwise or counterclockwise).
     */
    public void rotateTetriminoContainer(Rotation rotation) {
        if (rotationIsValid(rotation)) {
            setNewTetriminoLayout(getRotatedTetriminoLayout(rotation));

            setNewTetriminoContainer(getCellsInPlayingFieldForNewTetrimino());
        }
    }

    /**
     * Rotates the Tetrimino and gets a new layout for it after the rotation.
     * @param rotation Direction of the rotation.
     * @return the rotated matrix which contains the layout of the Tetrimino piece
     * in the Tetrimino container.
     */
    private int[][] getRotatedTetriminoLayout(Rotation rotation) {
            return rotator.rotate(rotation, tetrimino.getLayout());
    }

    /**
     * Gets the cells for a rotated Tetrimino container.
     * @return new Tetrimino container that holds the rotated Tetrimino.
     */
    private Cell[][] getCellsInPlayingFieldForNewTetrimino() {
        return containerForNewTetrimino(rowFixPoint, columnFixPoint);
    }

    /**
     * Method that checks if the rotation of the Tetrimino is valid. ie. rotated Tetrimino
     * would not end up occupying an already occupied cell or would not move out of playing field
     * bounds as a result of the rotation.
     * @param rotation Direction of the rotation.
     * @return boolean value true, if the rotation is valid, false otherwise.
     */
    private boolean rotationIsValid(Rotation rotation) {
        rotationValidator = new RotationValidator(this.playingField, this.tetrimino, this);
        int[][] newMatrix = getRotatedTetriminoLayout(rotation);

        return (!rotationValidator.tetriminoWillRotateOffPlayingfield(newMatrix) &&
                !rotationValidator.rotatedTetriminoWillOccupyAnOccupiedCell(newMatrix));
    }

    /**
     * Sets a new layout for a rotated Tetrimino.
     * @param newTetriminoMatrix int[][]tableaux of an already rotated Tetrimino.
     */
    private void setNewTetriminoLayout(final int[][] newTetriminoMatrix) {
        final int[][] currentMatrix = tetrimino.getLayout();
        forEachCell(currentMatrix, (row, column) -> {
            currentMatrix[row][column] = newTetriminoMatrix[row][column];
        });
    }

    /**
     * Sets a new Tetrimino container.
     * @param tetriminoContainerToBeSet Tetrimino container which boolean values are to be set.
     */
    private void setNewTetriminoContainer(Cell[][] tetriminoContainerToBeSet) {
        setAllCells(tetriminoContainer, false);
        setAllCells(tetriminoContainerToBeSet, true);
        tetriminoContainer = tetriminoContainerToBeSet;
    }

    /**
     * This method is used to check collisions when rotating a Tetrimino piece.
     * @param row where the specific cell is against the Tetrimino containers fix point.
     * @param column where the specific cell is against the Tetrimino containers fix point.
     * @return a specific cell from a playing field.
     */
    public Cell getPlayingfieldCellAt(int row, int column) {
        return playingField.getCell(playingfieldRow(row), playingfieldColumn(column));
    }

    /**
     * Ternary operator for deciding which cell column is where the wanted cell is.
     * @param column column that is queried.
     * @return If the column would go outside of playing field it returns the column closest to edge
     * otherwise it returns the column that is parameters distance away from the Tetrimino containers
     * fixed point.
     */
    private int playingfieldColumn(int column) {
        return (columnFixPoint + column) >= playingField.getColumns() ? playingField.getColumns() - 1 :
                (columnFixPoint + column) < 0 ? 0 : columnFixPoint + column;
    }

    /**
     * Ternary operator for deciding which cell row is where the wanted cell is.
     * @param row row that is queried.
     * @return If the row would go outside of playing field it returns the row closest to edge
     * otherwise it returns the row that is parameters distance away from the Tetrimino containers
     * fixed point.
     */
    private int playingfieldRow(int row) {
        return (rowFixPoint + row) >= playingField.getRows() ? playingField.getRows() - 1 :
                (rowFixPoint + row) < 0 ? 0 : rowFixPoint + row;
    }
}
