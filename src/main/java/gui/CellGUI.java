package gui;


import applogic.Cell;
import applogic.PlayingField;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Class for GUI for the cells of the playing field.
 */
public class CellGUI extends JPanel {

    private Cell cell;

    /**
     * Creates CellGUI object for the instance of a Cell object
     * @param cell for which the gui is to be created.
     */
    public CellGUI(Cell cell) {
        this.cell = cell;
        setBackground(PlayingField.getDEFAULT_EMPTY_COLOR());
        setBorder(new LineBorder(Color.black));
        Dimension dimension = new Dimension(25,25);
        setPreferredSize(dimension);
        setVisible(true);
    }

    /**
     * Method that gets the actual cell that underlies the drawn cell.
     * @return the underlying actual cell.
     */
    public Cell underlying() {
        return cell;
    }

    /**
     * Method that gets the color of the cell.
     * @return color of the cell.
     */
    public Color getColor() {
        return underlying().getColor();
    }

    /**
     * Recolors the cells.
     */
    public void recolor() {
        setBackground(underlying().getColor());
    }
}
