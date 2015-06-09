package gui;


import applogic.Cell;
import applogic.PlayingField;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tetriminoes.BlockO;
import tetriminoes.Tetrimino;

import java.util.ArrayList;
import java.util.List;

public class PlayingFieldGUITest {

    PlayingFieldGUI testPlayingFieldGUI;
    PlayingFieldGUI smallTestPlayingFieldGUI;

    @Before
    public void createPlayingField() {
        testPlayingFieldGUI = new PlayingFieldGUI(20, 10);
        smallTestPlayingFieldGUI = new PlayingFieldGUI(6, 10);
    }

    @Test
    public void PlayingFieldContainsRightAmountOfCellGUIs() {
        Assert.assertEquals(testPlayingFieldGUI.getCellGUIs().size(), 200);
        for (CellGUI cell : testPlayingFieldGUI.getCellGUIs()) {
            Assert.assertFalse(cell.underlying().getIsCellOccupied());
        }
    }

    @Test
    public void addNewTetriminoToPlayingFIeld() {
        testPlayingFieldGUI.getPlayingField().addNewTetriminoToField(new BlockO());
        List<CellGUI> occupyCells = new ArrayList<>();
        List<CellGUI> emptyCells = new ArrayList<>();
        for (CellGUI cell : testPlayingFieldGUI.getCellGUIs()) {
            if (cell.underlying().getIsCellOccupied()) {
                occupyCells.add(cell);
            } else {
                emptyCells.add(cell);
            }
        }
        Assert.assertEquals(4, occupyCells.size());
        Assert.assertEquals(196, emptyCells.size());
        for (CellGUI cell : occupyCells) {
            Assert.assertEquals(new BlockO().getColor(), cell.getColor());
        }
        for (CellGUI cell : emptyCells){
            Assert.assertEquals(PlayingField.getDEFAULT_EMPTY_COLOR(), cell.getColor());
        }
    }

    @Test
    public void newTetriminoIsAdded() {
        testPlayingFieldGUI.addNewTetrimino();
        Assert.assertNotNull(testPlayingFieldGUI.getPlayingField().getMapper().getTetrimino());
    }

    @Test
    public void newPieceDoesNotFitInFieldTest() {
        Tetrimino firstTetrimino = new BlockO();
        smallTestPlayingFieldGUI.getPlayingField().addNewTetriminoToField(firstTetrimino);
        for (int i = 0; i < 15; i++) {
            smallTestPlayingFieldGUI.tick();
        }
        Assert.assertNotEquals(smallTestPlayingFieldGUI.getPlayingField().getMapper().getTetrimino(), firstTetrimino);
        Assert.assertEquals(smallTestPlayingFieldGUI.gameOver(), true);
    }
}
