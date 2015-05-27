package applogic;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class CellTest {

    @Test
    public void ColorIsSetAndGetCorrectly() {
        Cell testCell = new Cell(4, 4);
        Assert.assertEquals(PlayingField.getDEFAULT_EMPTY_COLOR(), testCell.getColor());
        testCell.setColor(Color.magenta);
        Assert.assertEquals(Color.magenta, testCell.getColor());
    }
}
