package gui;


import applogic.Cell;
import applogic.PlayingField;
import applogic.TickListener;
import tetriminoes.Tetrimino;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for drawing the next Tetrimino piece that is about to appear in the playing field.
 */
public class NextTetriminoGUI extends JPanel implements TickListener {

    private PlayingField playingField;
    private List<CellGUI> cells;

    /**
     * Constructor for a new NextTetriminoGUI object. Gets the playing field and
     * adds itself to TickListeners. Then draws the layout of the field that shows
     * the next Tetrimino piece.
     * @param playingFieldGUI PlayingFieldGUI that is going to be associated with the
     *                        the NextTetriminoGUI.
     */
    public NextTetriminoGUI(PlayingFieldGUI playingFieldGUI) {
        this.playingField = playingFieldGUI.getPlayingField();
        this.playingField.addTickListener(this);
        setLayout(new GridLayout(4, 4));

        setBorder(new LineBorder(Color.black));
        cells = new ArrayList<>();

        for (int row = 0; row < 4; row++){
            for (int column = 0; column < 4; column++){
                CellGUI cell = new CellGUI(new Cell(row, column));
                add(cell);
                cells.add(cell);
            }
        }
    }

    /**
     * Method for getting and drawing the next Tetrimino piece that is going to appear after the playing field has ticked.
     */
    @Override
    public void playingFieldHasTicked() {
        Tetrimino nextTetrimino = playingField.getNextTetrimino();
        for (int row = 0; row < nextTetrimino.getLayout().length; row++){
            for (int column = 0; column < nextTetrimino.getLayout()[0].length; column++) {
                getCellGUIAt(row, column).underlying().setCellIsOccupied(nextTetrimino, nextTetrimino.getLayout()[row][column] == 1);
                getCellGUIAt(row, column).recolor();
            }
        }
    }

    /**
     * Gets the specified cell from the list of CellGUIs.
     * @param row where the specified cell is at.
     * @param column where the specified cell is at.
     * @return CellGUI object that resides in the coordinates specied in the parameters.
     */
    private CellGUI getCellGUIAt(int row, int column) {
        for (CellGUI cell : cells){
            if (cell.underlying().getRow() == row && cell.underlying().getColumn() == column) {
                return cell;
            }
        }
        throw new RuntimeException("Cannot locate the cell from a list of CellGUIs");
    }
}
