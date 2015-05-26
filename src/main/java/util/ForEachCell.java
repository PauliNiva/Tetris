package util;

/**
 * Utility class for iterating through two-dimensional array.
 */
public class ForEachCell {

    /**
     * Method for iterating through two dimensional object array.
     * @param array that is to be iterated through.
     * @param callback Instance of CellCallback.
     */
    public static void forEachCell(Object[][] array, CellCallback callback) {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[0].length; column++) {
                callback.cell(row, column);
            }
        }
    }

    /**
     * Method for iterating through two dimensional int array.
     * @param array that is to be iterated through.
     * @param callback Instance of CellCallback.
     */
    public static void forEachCell(int[][] array, CellCallback callback) {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[0].length; column++) {
                callback.cell(row, column);
            }
        }
    }
}
