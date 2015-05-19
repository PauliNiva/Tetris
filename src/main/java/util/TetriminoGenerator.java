package util;

import tetriminoes.*;

import java.util.Random;

/**
 * Class for generating Tetrimino pieces randomly.
 */
public class TetriminoGenerator {

    /**
     * Enum for differerent kinds of Tetrimino pieces.
     * Sub-classes implement method getTetrimino and returns
     * the corresponding Tetrimino piece.
     */
    public enum Tetriminoes {
        BlockI{
            public Tetrimino getTetrimino(){
                return new BlockI();
            }
        },
        BlockJ{
            public Tetrimino getTetrimino(){
                return new BlockJ();
            }
        },
        BlockL{
            public Tetrimino getTetrimino(){
                return new BlockL();
            }
        },
        BlockO{
            public Tetrimino getTetrimino(){
                return new BlockO();
            }
        },
        BlockS{
            public Tetrimino getTetrimino(){
                return new BlockS();
            }
        },
        BlockT{
            public Tetrimino getTetrimino(){
                return new BlockT();
            }
        },
        BlockZ{
            public Tetrimino getTetrimino(){
                return new BlockZ();
            }
        };

        public abstract Tetrimino getTetrimino();
    }

    /**
     * Creates new Tetrimino piece randomly.
     * @return random Tetrimino piece.
     */
    public Tetrimino createNewTetrimino() {
        return Tetriminoes.values()[new Random().nextInt(Tetriminoes.values().length)].getTetrimino();
    }
}
