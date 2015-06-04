package applogic;

/**
 * Class for rotating the Tetrimino pieces.
 */
public class Rotator {

    /**
     * Empty constructor.
     */
    public Rotator() {
    }

    /**
     * Method for rotating the Tetrimino.
     * @param rotation Direction of the rotation.
     * @param matrixToBeRotated Tetrimino container as int tableaux.
     * @return Matrix that has been rotated.
     */
    public int[][] rotate(Rotation rotation, int[][] matrixToBeRotated) {
        return getRotatedMatrix(rotation, matrixToBeRotated);
    }

    /**
     * Method to get the rotated matrix of the Tetrimino container.
     * @param rotation Direction of the rotation.
     * @param currentMatrix Matrix that is to be rotated.
     * @return int[][] tableauc that has been rotated.
     */
    @SuppressWarnings("UnusedDeclaration")
    public int[][] getRotatedMatrix(Rotation rotation, int[][] currentMatrix) {
        int[][] newMatrix = new int[4][4];
        int rowCount = 0;
        for (int[] row : currentMatrix) {
            int columnCount = 0;
            for (int column = currentMatrix.length - 1; column >= 0; column--) {
                if (rotation.equals(Rotation.ClockwiseRotation)) {
                    rotateMatrixPositionClockwise(currentMatrix, newMatrix, rowCount, columnCount, column);
                    columnCount++;
                } else {
                    rotateMatrixPositionCounterclockwise(currentMatrix, newMatrix, rowCount, columnCount, column);
                    columnCount++;
                }
            }
            rowCount++;
        }
        return newMatrix;
    }

    /**
     * Rotates the position of the matrix that makes up the Tetrimino container clockwise.
     * @param currentMatrix int[][] tableaux that is to be rotated.
     * @param newMatrix int[][] tableaux where the rotated tableuax objects are set.
     * @param rowCount number of rows that has been handled already.
     * @param columnCount number of columns that has been handled already.
     * @param column column that is to be handled.
     */
    public void rotateMatrixPositionClockwise(int[][] currentMatrix, int[][] newMatrix, int rowCount, int columnCount, int column) {
        newMatrix[currentMatrix.length - 1 - columnCount][currentMatrix.length - 1 - rowCount] = currentMatrix[rowCount][column];
    }

    /**
     * Rotates the position of the matrix that makes up the Tetrimino container counterclockwise.
     * @param currentMatrix int[][] tableaux that is to be rotated.
     * @param newMatrix int[][] tableaux where the rotated tableuax objects are set.
     * @param rowCount number of rows that has been handled already.
     * @param columnCount number of columns that has been handled already.
     * @param column column that is to be handled.
     */
    public void rotateMatrixPositionCounterclockwise(int[][] currentMatrix, int[][] newMatrix, int rowCount, int columnCount, int column) {
        newMatrix[columnCount][rowCount] = currentMatrix[rowCount][column];
    }
}
