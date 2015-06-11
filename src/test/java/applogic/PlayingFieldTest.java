package applogic;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tetriminoes.BlockO;
import tetriminoes.Tetrimino;

public class PlayingFieldTest {

    PlayingField testField;
    PlayingField smallTestField;

    @Before
    public void createPlayingField() {
        testField = new PlayingField(20, 10);
        smallTestField = new PlayingField(4, 10);
    }

    @Test
    public void numberOfCellsInFieldIsCorrect() {
        Assert.assertEquals(19, fieldHeight());
        Assert.assertEquals(9, fieldWidth());
    }

    @Test
    public void numberOfRowsInFieldIsCorrect() {
        Assert.assertEquals(20, testField.getRows());
    }

    @Test
    public void numberOfColumnsInFieldIsCorrect() {
        Assert.assertEquals(10, testField.getColumns());
    }

    @Test
    public void START_ROW_IsCorrect() {
        Assert.assertEquals(0, testField.getSTART_ROW());
    }

    @Test
    public void START_COLUMN_IsCorrect() {
        Assert.assertEquals(3, testField.getSTART_COLUMN());
    }

    @Test
    public void nextTetriminoIsSet() {
        boolean tetriminoExists = false;
        if (testField.getNextTetrimino() != null) {
            tetriminoExists = true;
        }
        Assert.assertTrue(tetriminoExists);
    }

    @Test
    public void addNewTetriminoWhenMovingTetriminoStops() {
        Tetrimino firstTetrimino = new BlockO();
        testField.addNewTetriminoToField(firstTetrimino);
        for (int i = 0; i < 17; i++) {
            testField.tick();
        }
        Assert.assertEquals(firstTetrimino, testField.getMapper().getTetrimino());
        testField.tick();
        Assert.assertNotNull(testField.getMapper().getTetrimino());
        Assert.assertNotSame(testField.getMapper().getTetrimino(), firstTetrimino);
    }

    @Test
    public void newPieceDoesNotFitInFieldTest() {
        Tetrimino firstTetrimino = new BlockO();
        smallTestField.addNewTetriminoToField(firstTetrimino);
        for (int i = 0; i < 15; i++) {
            smallTestField.tick();
        }
        Assert.assertEquals(smallTestField.getMapper().getTetrimino(), firstTetrimino);
        Assert.assertEquals(smallTestField.gameOver(), true);
    }

    private int fieldHeight() {
        int height = 0;
        for (Cell cell : testField.getAllCellsInPlayingField()) {
            if (cell.getRow() > height) height = cell.getRow();
        }
        return height;
    }

    private int fieldWidth() {
        int width = 0;
        for (Cell cell : testField.getAllCellsInPlayingField()) {
            if (cell.getColumn() > width) width = cell.getColumn();
        }
        return width;
    }
}
