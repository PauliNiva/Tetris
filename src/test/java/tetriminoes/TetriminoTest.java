package tetriminoes;


import org.junit.Assert;
import org.junit.Test;

public class TetriminoTest {

    @Test
    public void TetriminoIsInsertedIntoContainerTest() {
        int occupiedCellCount = 0;
        BlockO testBlockO = new BlockO();
        int[][] cells = testBlockO.getLayout();
        for (int[] row : cells) {
            for (int i : row) {
                if (i != 0) {
                    occupiedCellCount++;
                }
            }
        }
        Assert.assertEquals(4, occupiedCellCount);
    }
}
