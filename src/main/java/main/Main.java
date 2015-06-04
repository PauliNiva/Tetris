package main;

/**
 * Main class for firing up the application.
 */
public class Main {

    /**
     * Starter for starting the game.
     */
    private static Starter starter = new Starter();

    /**
     * Main method starts the program by calling start() method from a Starter object.
     * @param args Commandline arguments that are associated with the main method.
     * @throws InterruptedException is thrown if Thread.sleep() method is interrupted.
     */
    public static void main(String[] args) throws InterruptedException {
        starter.start(args);
    }


    /**
     * Sets the starter.
     * @param starter
     */
    static void setStarter(Starter starter) {
        Main.starter = starter;
    }
}
