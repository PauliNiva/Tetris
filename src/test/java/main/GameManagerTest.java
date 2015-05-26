package main;


import applogic.PlayingField;
import gui.PlayingFieldGUI;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

public class GameManagerTest {

    GameManager gameManager;

    @Test
    public void GameManagerInitializesPlayingFieldCorrectly() throws InterruptedException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        gameManager = new GameManager();
        PlayingFieldGUI testField = gameManager.getPlayingField();
        Assert.assertEquals(200, testField.getPlayingField().getRows() * testField.getPlayingField().getColumns());
    }
}
