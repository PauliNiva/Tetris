package gui;


import applogic.Cell;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Class for GUI for the cells of the playing field.
 */
public class CellGUI extends JPanel {

    private Cell cell;
    private static int CELL_SIZE = 100;

    /**
     * Creates CellGUI object for the instance of a Cell object
     * @param cell for which the gui is to be created.
     */
    public CellGUI(Cell cell) {
        this.cell = cell;
        setBackground(cell.getDefaultEmptyColor());
        setBorder(new LineBorder(Color.black));
        setSize(CELL_SIZE, CELL_SIZE);
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

    /**
     * Method to get the size of the individual cell
     * @return size of the cell as int.
     */
    public static int getCELL_SIZE() {
        return CELL_SIZE;
    }
}
