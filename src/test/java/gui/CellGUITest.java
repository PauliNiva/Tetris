package gui;


import applogic.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class CellGUITest {

    @Test
    public void underlyingCellColorIsCorrect() {
        Cell testCell = new Cell(0, 0);
        CellGUI testCellGUI = new CellGUI(testCell);
        testCell.setColor(Color.black);
        Assert.assertEquals(testCellGUI.getColor(), Color.black);
        testCellGUI.recolor();
        Assert.assertEquals(testCellGUI.getColor(), Color.black);
    }
}
