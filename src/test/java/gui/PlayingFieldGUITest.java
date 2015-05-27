package gui;


import org.junit.Assert;
import org.junit.Test;

public class PlayingFieldGUITest {

    @Test
    public void PlayingFieldContainsRightAmountOfCellGUIs() {
        PlayingFieldGUI testPlayingFieldGUI = new PlayingFieldGUI(20, 10);
        Assert.assertEquals(testPlayingFieldGUI.getCellGUIs().size(), 200);
    }
}
