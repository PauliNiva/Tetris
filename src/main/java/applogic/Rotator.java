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
     *
     * @param rotation
     * @param rotateMe
     * @return
     */
    public int[][] rotate(Rotation rotation, int[][] rotateMe) {
        return getRotatedMatrix(rotation, rotateMe);
    }

    /**
     *
     * @param rotation
     * @param currentMatrix
     * @return
     */
    @SuppressWarnings({"UnusedDeclaration"})
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
     * @param currentMatrix
     * @param newMatrix
     * @param rowCount
     * @param columnCount
     * @param col
     */
    public void rotateMatrixPositionClockwise(int[][] currentMatrix, int[][] newMatrix, int rowCount, int columnCount, int col) {
        newMatrix[currentMatrix.length - 1 - columnCount][currentMatrix.length - 1 - rowCount] = currentMatrix[rowCount][col];
    }

    /**
     * Rotates the position of the matrix that makes up the Tetrimino container counterclockwise.
     * @param currentMatrix
     * @param newMatrix
     * @param rowCount
     * @param columnCount
     * @param col
     */
    public void rotateMatrixPositionCounterclockwise(int[][] currentMatrix, int[][] newMatrix, int rowCount, int columnCount, int col) {
        newMatrix[columnCount][rowCount] = currentMatrix[rowCount][col];
    }}
