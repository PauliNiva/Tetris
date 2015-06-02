package applogic;


import gui.PlayingFieldGUI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tetriminoes.BlockI;
import tetriminoes.BlockL;
import tetriminoes.BlockO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class UserInputListenerTest {

    PlayingField playingField;
    UserInputListener userInputListener;
    PlayingFieldGUI playingFieldGUI;
    JFrame app;
    Robot robot;
    MockGameManager mockGameManager;

    @Before
    public void createPlayingField() throws AWTException, InterruptedException {
        playingField = new PlayingField(20, 10);
        app = new JFrame();
        mockGameManager = new MockGameManager(1);
        robot = new Robot();
    }

    @Test
    public void moveTetriminoAround() {
        playingField.addNewTetriminoToField(new BlockL());
        List<Cell> startCells = playingField.getMapper().getTetriminoContainerAsList();
        playingField.moveTetrimino(Direction.Left);
        assertTetriminoHasMoved(startCells, 0, -1);
        playingField.moveTetrimino(Direction.Left);
        assertTetriminoHasMoved(startCells, 0, -2);
        playingField.tick();
        assertTetriminoHasMoved(startCells, 1, -2);
        playingField.moveTetrimino(Direction.Right);
        assertTetriminoHasMoved(startCells, 1, -1);
        playingField.tick();
        assertTetriminoHasMoved(startCells, 2, -1);
        playingField.moveTetrimino(Direction.Right);
        playingField.moveTetrimino(Direction.Right);
        assertTetriminoHasMoved(startCells, 2, 1);
        playingField.tick();
        playingField.moveTetrimino(Direction.Left);
        playingField.moveTetrimino(Direction.Left);
        playingField.moveTetrimino(Direction.Left);
        playingField.moveTetrimino(Direction.Left);
        assertTetriminoHasMoved(startCells, 3, -3);
        playingField.moveTetrimino(Direction.Left);
        assertTetriminoHasMoved(startCells, 3, -3); //checks that tetrimino does not move out of the field from left
        for (int i = 0; i < 15; i++) {
            playingField.moveTetrimino(Direction.Right);
        }
        assertTetriminoHasMoved(startCells, 3, 4); //checks that tetrimino does not move out of the field from right
        playingField.tick();
        assertTetriminoHasMoved(startCells, 4, 4);
    }

    @Test
    public void moveTetriminoToBottomwithKeys() {
        mockGameManager.getPlayingField().getPlayingField().addNewTetriminoToField(new BlockL());
        List<Cell> startCells = mockGameManager.getPlayingField().getPlayingField().getMapper().getTetriminoContainerAsList();
        mockGameManager.getApp().requestFocus();
        robot.keyPress(KeyEvent.VK_SPACE);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        robot.keyRelease(KeyEvent.VK_SPACE);
        System.out.println();
        assertTetriminoHasMovedWithKeys(startCells, 18, 0);
    }

    @Test
    public void moveTetriminoWithWrongKey() {
        mockGameManager.getPlayingField().getPlayingField().addNewTetriminoToField(new BlockL());
        List<Cell> startCells = mockGameManager.getPlayingField().getPlayingField().getMapper().getTetriminoContainerAsList();
        mockGameManager.getApp().requestFocus();
        robot.keyPress(KeyEvent.VK_TAB);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        robot.keyRelease(KeyEvent.VK_TAB);
        assertTetriminoHasMovedWithKeys(startCells, 0, 0);
    }

    @Test
     public void moveTetriminoToTheLeftWithKeys() {
        mockGameManager.getPlayingField().getPlayingField().addNewTetriminoToField(new BlockL());
        List<Cell> startCells = mockGameManager.getPlayingField().getPlayingField().getMapper().getTetriminoContainerAsList();
        mockGameManager.getApp().requestFocus();
        robot.keyPress(KeyEvent.VK_LEFT);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        robot.keyRelease(KeyEvent.VK_LEFT);
        assertTetriminoHasMovedWithKeys(startCells, 0, -1);
    }

    @Test
    public void moveTetriminoToTheRightWithKeys() {
        mockGameManager.getPlayingField().getPlayingField().addNewTetriminoToField(new BlockL());
        List<Cell> startCells = mockGameManager.getPlayingField().getPlayingField().getMapper().getTetriminoContainerAsList();
        mockGameManager.getApp().requestFocus();
        robot.keyPress(KeyEvent.VK_RIGHT);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        robot.keyRelease(KeyEvent.VK_RIGHT);
        assertTetriminoHasMovedWithKeys(startCells, 0, 1);
    }

    @Test
    public void removeCompleteBottomRow() {
        mockGameManager.getPlayingField().getPlayingField().addNewTetriminoToField(new BlockO());
        moveTetriminoToBottom();
        mockGameManager.getPlayingField().getPlayingField().addNewTetriminoToField(new BlockI());
        moveTetriminoSidewaysToFarLeft();
        moveTetriminoToBottom();
        mockGameManager.getPlayingField().getPlayingField().addNewTetriminoToField(new BlockI());
        moveTetriminoSidewaysToFarRight();
        moveTetriminoToBottom();
        for (Cell cell : mockGameManager.getPlayingField().getPlayingField().getAllCellsInPlayingField()) {
            if (cell.getRow() == 20) {
                Assert.assertTrue(cell.getIsCellOccupied());
            }
        }
        mockGameManager.getPlayingField().getPlayingField().removeCompletedRows();
        for (Cell cell : mockGameManager.getPlayingField().getPlayingField().getAllCellsInPlayingField()) {
            if (cell.getRow() == 20) {
                Assert.assertFalse(cell.getIsCellOccupied());
            }
        }
    }

    @Test
    public void removeRow() {
        mockGameManager.getPlayingField().getPlayingField().addNewTetriminoToField(new BlockO());
        moveTetriminoToBottom();
        mockGameManager.getPlayingField().getPlayingField().addNewTetriminoToField(new BlockI());
        moveTetriminoSidewaysToFarLeft();
        moveTetriminoToBottom();
        mockGameManager.getPlayingField().getPlayingField().addNewTetriminoToField(new BlockI());
        moveTetriminoSidewaysToFarRight();
        moveTetriminoToBottom();
        for (Cell cell : mockGameManager.getPlayingField().getPlayingField().getAllCellsInPlayingField()) {
            if (cell.getRow() == 20) {
                Assert.assertTrue(cell.getIsCellOccupied());
            }
        }
        mockGameManager.getPlayingField().getPlayingField().removeRow(19);
        for (Cell cell : mockGameManager.getPlayingField().getPlayingField().getAllCellsInPlayingField()) {
            if (cell.getRow() == 20) {
                Assert.assertFalse(cell.getIsCellOccupied());
            }
        }
    }

    private void assertTetriminoHasMoved(List<Cell> startCells, int rows, int columns) {
        List<Cell> newCells = playingField.getMapper().getTetriminoContainerAsList();
        Assert.assertEquals(startCells.size(), newCells.size());
        for (Cell cell : startCells) {
            Assert.assertTrue(playingField.getAllCellsInPlayingField().contains(new Cell(cell.getRow() + rows,
                    cell.getColumn() + columns)));
            Assert.assertTrue(newCells.contains(playingField.getCell(cell.getRow() + rows, cell.getColumn() + columns)));
        }
    }

    private void assertTetriminoHasMovedWithKeys(List<Cell> startCells, int rows, int columns) {
        List<Cell> newCells = mockGameManager.getPlayingField().getPlayingField().getMapper().getTetriminoContainerAsList();
        Assert.assertEquals(startCells.size(), newCells.size());
        for (Cell cell : startCells) {
            Assert.assertTrue(mockGameManager.getPlayingField().getPlayingField().getAllCellsInPlayingField().contains(new Cell(cell.getRow() + rows,
                    cell.getColumn() + columns)));
            Assert.assertTrue(newCells.contains(mockGameManager.getPlayingField().getPlayingField().getCell(cell.getRow() + rows,
                    cell.getColumn() + columns)));
        }
    }

    private void moveTetriminoToBottom() {
        for (int i = 0; i < 21; i++) {
            mockGameManager.getPlayingField().getPlayingField().moveTetrimino(Direction.Down);
        }
    }

    private void moveTetriminoSidewaysToFarLeft() {
        for (int i = 0; i < 5; i++) {
            mockGameManager.getPlayingField().getPlayingField().moveTetrimino(Direction.Left);
        }
    }

    private void moveTetriminoSidewaysToFarRight() {
        for (int i = 0; i < 5; i++) {
            mockGameManager.getPlayingField().getPlayingField().moveTetrimino(Direction.Right);
        }
    }

    private class MockGameManager {

        PlayingFieldGUI playingFieldGUI;

        public MockGameManager(int i) throws InterruptedException {
            playingFieldGUI = new PlayingFieldGUI(20, 10);
            app = new JFrame();
            newApp();
            app.add(playingFieldGUI);
        }

        private void newApp() {
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setLayout(new FlowLayout());
            app.setSize(500, 600);
            app.setLocation(800, 400);
            app.setVisible(true);
            app.setTitle("Yet Another Tetris Clone");
            app.addKeyListener(new UserInputListener(this.playingFieldGUI));
        }

        public JFrame getApp() {
            return app;
        }

        public PlayingFieldGUI getPlayingField() {
            return playingFieldGUI;
        }
    }
}
