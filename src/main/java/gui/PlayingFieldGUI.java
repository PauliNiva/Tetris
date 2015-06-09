package gui;


import applogic.Cell;
import applogic.PlayingField;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for GUI for the playing field by using JPanel.
 */
public class PlayingFieldGUI extends JPanel {

    private PlayingField playingField;
    private List<CellGUI> cellGUIs;

    /**
     * Creates a gui for the playing field and calls for the creation of
     * CellGUI objects.
     * @param rows number of rows that are in the playing field.
     * @param columns number of columns that are in the playing field.
     */
    public PlayingFieldGUI(int rows, int columns) {
        setLayout(new GridLayout(rows, columns));
        setBorder(new LineBorder(Color.black));
        this.playingField = new PlayingField(rows, columns);
        createCellGUIs();
    }

    /**
     * Method that creates CellGUI objects for every Cell object in the
     * playing field and stores them in an array list.
     */
    private void createCellGUIs() {
        cellGUIs = new ArrayList<>();

        for (Cell cell : playingField.getAllCellsInPlayingField()) {
            CellGUI cellGUI = new CellGUI(cell);
            add(cellGUI);
            cellGUIs.add(cellGUI);
        }
    }

    /**
     * Moves the game cycle(the internal clock of the game)
     * ahead by one unit and then repaints the playing field.
     */
    public void tick() {
        playingField.tick();
        repaintPlayingField();
    }

    /**
     * Method for repainting the playing field.
     */
    public void repaintPlayingField() {
        for (CellGUI cell : getCellGUIs()) {
            cell.recolor();
        }
    }

    /**
     * Gets the CellGUIs as a list
     * @return list of CellGUI objects.
     */
    public List<CellGUI> getCellGUIs() {
        return cellGUIs;
    }

    /**
     * Adds a new TetriminoPiece by calling the appropriate method from
     * the PlayingField class.
     */
    public void addNewTetrimino() {
        playingField.addNewTetrimino();
    }

    /**
     * Checks if the game is over by calling appropriate method from
     * the PlayingField class.
     * @return boolean value true, if the game is over, false if not.
     */
    public boolean gameOver() {
        return playingField.gameOver();
    }

    /**
     * Gets the playing field as a PlayingField object.
     * @return playing field as a PlayingField object.
     */
    public PlayingField getPlayingField() {
        return this.playingField;
    }
}
