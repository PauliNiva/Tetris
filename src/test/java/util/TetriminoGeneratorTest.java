package util;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tetriminoes.Tetrimino;

import java.util.HashMap;
import java.util.Map;

public class TetriminoGeneratorTest {

    Map<Tetrimino, Integer> tetriminoCount;

    @Before
    public void tetriminoCounter() {
        tetriminoCount = new HashMap<Tetrimino, Integer>();
        for (TetriminoGenerator.Tetriminoes tetrimino : TetriminoGenerator.Tetriminoes.values()){
            tetriminoCount.put(tetrimino.getTetrimino(), 0);
        }
    }

    @Test
    public void tetriminoGenerationWorksCorrectly() {
        TetriminoGenerator tetriminoGenerator = new TetriminoGenerator();
        for (int i = 0; i < 1000; i++) {
            Tetrimino newTetrimino = tetriminoGenerator.createNewTetrimino();
            for (Tetrimino tetrimino : tetriminoCount.keySet()) {
                if (newTetrimino.getClass().getName().equals(tetrimino.getClass().getName())) {
                    Integer count = tetriminoCount.get(tetrimino);
                    Assert.assertFalse(tetrimino.equals(newTetrimino));
                    Assert.assertTrue(tetrimino.getColor().equals(newTetrimino.getColor()));
                    tetriminoCount.put(tetrimino, ++count);
                }
            }
        }
        Assert.assertFalse(tetriminoCount.containsValue(0));
    }
}
