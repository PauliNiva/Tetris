package main;


import gui.PlayingFieldGUI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;

public class GameManagerTest {

    GameManager gameManager;

    @Before
    public void createPlayingField() throws AWTException, InterruptedException  {
        gameManager = new GameManager();
    }

    @Test
    public void GameManagerInitializesPlayingFieldCorrectly() throws InterruptedException {
        PlayingFieldGUI testField = gameManager.getPlayingField();
        Assert.assertEquals(200, testField.getPlayingField().getRows() * testField.getPlayingField().getColumns());
    }
}
