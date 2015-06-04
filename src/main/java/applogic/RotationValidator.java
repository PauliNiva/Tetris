package applogic;


import tetriminoes.Tetrimino;

/**
 * Class for validating the rotations of the Tetrimino piece.
 */
public class RotationValidator {

    PlayingField playingField;
    Mapper mapper;
    Tetrimino tetrimino;

    /**
     * Creates a RotationValidator object with the currently falling Tetrimino,
     * Playingfield and it's mapper at their current state.
     * @param playingField PlayingField object at it's current state.
     * @param tetrimino Tetrimino piece that is currently falling in the field.
     * @param mapper Mapper at it's current state.
     */
    public RotationValidator(PlayingField playingField, Tetrimino tetrimino, Mapper mapper) {
        this.playingField = playingField;
        this.tetrimino = tetrimino;
        this.mapper = mapper;
    }

    /**
     * Method that checks if the rotated Tetrimino will end up occupying an already occupied cell.
     * @param newMatrix Matrix that contains the layout of the rotated Tetrimino container.
     * @return boolean value true, it the cell is already occupied, false otherwise.
     */
    public boolean rotatedTetriminoWillOccupyAnOccupiedCell(int[][] newMatrix) {
        for (int row = 0; row < newMatrix.length; row++) {
            for (int column = 0; column < newMatrix[0].length; column++) {
                if (playingField.getCell(row, column).getIsCellOccupied() && newMatrix[row][column] == 1 &&
                        !(mapper.getTetriminoContainerAsList().contains(playingField.getCell(row, column)))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method that checks if the rotated Tetrimino would rotate off the playingfield.
     * @param newMatrix Matrix that contains the layout of the rotated Tetrimino container.
     * @return boolean value true if the piece would rotate of the field, false otherwise.
     */
    public boolean tetriminoWillRotateOffPlayingfield(int[][] newMatrix) {
        return tetriminoWillRotateOffLeftEdge(newMatrix) ||
                tetriminoWillRotateOffRightEdge(newMatrix);
    }

    /**
     * Utility method for checking if the Tetrimino would rotate off the right edge of the playing field.
     * @param newMatrix Matrix that contains the layout of the rotated Tetrimino container.
     * @return boolean value true is the rotating Tetrimino would move off the field from right edge,
     * false otherwise.
     */
    public boolean tetriminoWillRotateOffRightEdge(int[][] newMatrix) {
        return (tetriminoWillMoveToRight(newMatrix) && tetriminoIsInColumn(playingField.getColumns() - 1));
    }

    /**
     * Utility method for checking if the Tetrimino would rotate off the left edge of the playing field.
     * @param newMatrix Matrix that contains the layout of the rotated Tetrimino container.
     * @return boolean value true is the rotating Tetrimino would move off the field from left edge,
     * false otherwise.
     */
    private boolean tetriminoWillRotateOffLeftEdge(int[][] newMatrix) {
        return (tetriminoWillMoveToLeft(newMatrix) && tetriminoIsInColumn(0));
    }

    /**
     * Utility method to check if rotation would move the Tetrimino to the right.
     * @param newMatrix int[][] tableaux of a layout of an already rotated Tetrimino.
     * @return boolean value true, if the Tetrimino would move to the right, false otherwise.
     */
    private boolean tetriminoWillMoveToRight(int[][] newMatrix) {
        return matrixContainsOccupiedCellInColumn(newMatrix, 3) &&
                !matrixContainsOccupiedCellInColumn(tetrimino.getLayout(), 3);
    }

    /**
     * Utility method to check if rotation would move the Tetrimino to the left.
     * @param newMatrix int[][] tableaux of a layout of an already rotated Tetrimino.
     * @return boolean value true, if the Tetrimino would move to the left, false otherwise.
     */
    private boolean tetriminoWillMoveToLeft(int[][] newMatrix) {
        return matrixContainsOccupiedCellInColumn(newMatrix, 0) &&
                !matrixContainsOccupiedCellInColumn(tetrimino.getLayout(), 0);
    }

    /**
     * Checks if matrix contains a occupied cell in specified column.
     * @param newMatrix int[][] tableaux that contains the cells to be checked.
     * @param column column that is to be checked if it has any occupied matrix cells in it.
     * @return boolean value true, if matrix has a cell in specified column, false otherwise.
     */
    private boolean matrixContainsOccupiedCellInColumn(int[][] newMatrix, int column) {
        for (int[] row : newMatrix) {
            if (row[column] == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that checks if Tetrimino is in certain column.
     * @param column that is to be checked if it does contain piece of Tetrimino piece.
     * @return boolean value true if column has a piece of Tetrimino in it, otherwise false.
     */
    private boolean tetriminoIsInColumn(int column) {
        for (Cell cell : mapper.getTetriminoContainerAsList()) {
            if (cell.getColumn() == column) {
                return true;
            }
        }
        return false;
    }

}
