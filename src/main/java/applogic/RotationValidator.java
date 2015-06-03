package applogic;


import tetriminoes.Tetrimino;

/**
 * Class for validating the rotations of the Tetrimino piece.
 */
public class RotationValidator {

    PlayingField playingField;
    Mapper mapper;
    Tetrimino tetrimino;

    public RotationValidator(PlayingField playingField, Tetrimino tetrimino, Mapper mapper) {
        this.playingField = playingField;
        this.tetrimino = tetrimino;
        this.mapper = mapper;
    }

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

    public boolean tetriminoWillRotateOffPlayingfield(int[][] newMatrix) {
        return tetriminoWillRotateOffLeftEdge(newMatrix) ||
                tetriminoWillRotateOffRightEdge(newMatrix);
    }

    public boolean tetriminoWillRotateOffRightEdge(int[][] newMatrix) {
        return (tetriminoWillMoveToRight(newMatrix) && tetriminoIsInColumn(playingField.getColumns() - 1));
    }

    private boolean tetriminoWillRotateOffLeftEdge(int[][] newMatrix) {
        return (tetriminoWillMoveToLeft(newMatrix) && tetriminoIsInColumn(0));
    }

    private boolean tetriminoWillMoveToRight(int[][] newMatrix) {
        return matrixContainsCellInColumn(newMatrix, 3) &&
                !matrixContainsCellInColumn(tetrimino.getLayout(), 3);
    }

    private boolean tetriminoWillMoveToLeft(int[][] newMatrix) {
        return matrixContainsCellInColumn(newMatrix, 0) &&
                !matrixContainsCellInColumn(tetrimino.getLayout(), 0);
    }

    private boolean matrixContainsCellInColumn(int[][] newMatrix, int column) {
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
     * @return boolean value trua if column has a piece of Tetrimino in it, otherwise false.
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
