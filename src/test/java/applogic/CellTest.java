package applogic;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class CellTest {

    @Test
    public void ColorIsSetAndGetCorrectly() {
        Cell testCell = new Cell(4, 4);
        Assert.assertEquals(Color.white, testCell.getDefaultEmptyColor());
        testCell.setColor(Color.magenta);
        Assert.assertEquals(Color.magenta, testCell.getColor());
    }
}
