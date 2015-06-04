package main;

/**
 * Class for starting the game.
 */
public class Starter {

    /**
     * Creates and starts a new game by creating a new GameManager object.
     * @param args commandline arguments as objects of String tableaux.
     * @throws InterruptedException
     */
    public void start(String[] args) throws InterruptedException {
        new GameManager();
    }
}
