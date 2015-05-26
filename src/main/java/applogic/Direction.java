package applogic;

/**
 * Enum for directions that a Tetromino piece can move to.
 * Sub-classes implement method that check if the move is movementToDirectionIsValid
 * and they also implement getters for the row and column changes
 * as the piece moves.
 */
public enum Direction {

    Down {
        @Override
        boolean checkIfMoveIsValid(Cell cell, PlayingField field) {
            return cell.getRow() != field.getRows() - 1;
        }
        @Override
        int getRowChange() {
            return 1;
        }
        @Override
        int getColumnChange() {
            return 0;
        }},

    Left {
        @Override
        boolean checkIfMoveIsValid(Cell cell, PlayingField field) {
            return cell.getColumn() != 0;
        }
        @Override
        int getRowChange() {
            return 0;
        }
        @Override
        int getColumnChange() {
            return -1;
        }},

    Right {
        @Override
        boolean checkIfMoveIsValid(Cell cell, PlayingField field) {
            return cell.getColumn() != field.getColumns() - 1;
        }
        @Override
        int getRowChange() {
            return 0;
        }
        @Override
        int getColumnChange() {
            return 1;
        }};

    abstract boolean checkIfMoveIsValid(Cell cell, PlayingField field);

    abstract int getRowChange();

    abstract int getColumnChange();
}
