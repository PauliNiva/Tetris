package applogic;


import org.junit.Assert;
import org.junit.Test;

public class RotatorTest {

    @Test
    public void RotateClockwiseTest() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16}};
        matrix = rotateClockwise(matrix);
        Assert.assertArrayEquals( matrix, new int[][]{
                        new int[]{13, 9, 5, 1},
                        new int[]{14, 10, 6, 2},
                        new int[]{15, 11, 7, 3},
                        new int[]{16, 12, 8, 4}});
    }

    private int[][] rotateClockwise(int[][] matrix) {
        Rotator rotator = new Rotator();
        return rotator.getRotatedMatrix(Rotation.ClockwiseRotation, matrix);
    }

    private int[][] rotateCounterclockwise(int[][] matrix) {
        Rotator rotator = new Rotator();
        return rotator.getRotatedMatrix(Rotation.CounterClockwiseRotation, matrix);
    }

    @Test
    public void rotateCountercclockwiseTest() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16}};
        matrix = rotateCounterclockwise(matrix);
        Assert.assertArrayEquals(matrix, new int[][]{
                new int[]{4, 8, 12, 16},
                new int[]{3, 7, 11, 15},
                new int[]{2, 6, 10, 14},
                new int[]{1, 5, 9, 13}});
        matrix = rotateCounterclockwise(matrix);
        Assert.assertArrayEquals(matrix, new int[][]{
                new int[]{16, 15, 14, 13},
                new int[]{12, 11, 10, 9},
                new int[]{8, 7, 6, 5},
                new int[]{4, 3, 2, 1}});
        matrix = rotateCounterclockwise(matrix);
        Assert.assertArrayEquals(matrix, new int[][]{
                new int[]{13, 9, 5, 1},
                new int[]{14, 10, 6, 2},
                new int[]{15, 11, 7, 3},
                new int[]{16, 12, 8, 4}});
        matrix = rotateCounterclockwise(matrix);
        Assert.assertArrayEquals(matrix, new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16}});
    }
}
