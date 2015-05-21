package applogic;


import org.junit.Assert;
import org.junit.Test;
import tetriminoes.BlockO;

public class MapperTest {

    private PlayingField testField;
    private Mapper testMapper;
    private BlockO testBlockO;
    private Cell[][] testCell;

    @Test
    public void containerForNewTetriminoWorksCorrectly() {
        int occupiedCellCount = 16;
        testBlockO = new BlockO();
        testField = new PlayingField(20,10);
        testMapper = new Mapper(testField);
        testMapper.setNewTetrimino(testBlockO);
        testCell = testMapper.getTetriminoContainer();
        for (Cell[] row : testCell) {
            for (Cell isOccupied : row) {
                if (isOccupied == null || isOccupied.getIsCellOccupied() == false){
                    occupiedCellCount--;
                }
            }
        }
        Assert.assertEquals(4, occupiedCellCount);
    }
}
