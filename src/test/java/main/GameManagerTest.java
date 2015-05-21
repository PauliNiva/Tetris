package main;


import applogic.PlayingField;
import org.junit.Assert;
import org.junit.Test;

public class GameManagerTest {

    GameManager gameManager;

    @Test
    public void GameManagerInitializesPlayingFieldCorrectly() {
        gameManager = new GameManager();
        PlayingField testField = gameManager.getPlayingField();
        Assert.assertEquals(200, testField.getAllCellsInPlayingField().size());
    }
}
