package applogic;


import tetriminoes.Tetrimino;

import static util.ForEachCell.forEachCell;

/**
 * Class that maps the whereabouts of the Tetrimino piece in playing field.
 */
public class Mapper {

    private PlayingField map;
    private Tetrimino tetrimino;
    private Cell[][] tetriminoContainer;

    /**
     * Constructor that uses the current playing field as a map.
     * @param playingField field which is to be mapped.
     */
    public Mapper(PlayingField playingField) {
        this.map = playingField;
    }

    /**
     * Method that sets a new Tetrimino piece in the container to a map.
     * @param tetrimino that is about to be placed in a conttainer and set to a map.
     */
    public void setNewTetrimino(Tetrimino tetrimino) {
        this.tetrimino = tetrimino;
        tetriminoContainer = containerForNewTetrimino(map.getSTART_ROW(), map.getSTART_COLUMN());
    }

    /**
     * Method that makes a new container for a new Tetrimino piece.
     * @param startRow place in rows where the container is placed
     * @param startColumn place in columns where the container is placed.
     * @return Tetrimino container that has a Tetrmino inside.
     */
    private Cell[][] containerForNewTetrimino(int startRow, int startColumn) {
        final Cell[][] newTetriminoContainer = new Cell[4][4];
        forEachCell(tetrimino.getLayout(), (row, column) -> {
            newTetriminoContainer[row][column] = tetrimino.getLayout()[row][column] == 0 ? null :
                            map.getCell(startRow + row, startColumn + column).setCellIsOccupied(tetrimino);
        });
        return newTetriminoContainer;
    }
}
