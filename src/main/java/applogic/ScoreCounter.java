package applogic;

/**
 * Class for score counting..
 */
public class ScoreCounter {

    private PlayingField playingField;
    private int score;

    /**
     * Constructor that initializes a score attribute for specified playing field.
     * @param playingField Playing field which the score counter is associated with.
     */
    public ScoreCounter(PlayingField playingField) {
        this.playingField = playingField;
        this.score = 0;
    }

    /**
     * Method for counting the score that is going to be added. Points are given according
     * to the amount of rows that where removed.
     * @param numberOfRowsRemoved number of rows that where removed.
     */
    public void countScoreToBeAdded(int numberOfRowsRemoved) {
        switch (numberOfRowsRemoved) {
            case 1: {
                addScore(40 * playingField.getLevel());
                break;
            }
            case 2: {
                addScore(100 * playingField.getLevel());
                break;
            }
            case 3: {
                addScore(300 * playingField.getLevel());
                break;
            }
            case 4: {
                addScore(1200 * playingField.getLevel());
                break;
            }
        }
    }

    /**
     * Method for adding the calculated score to the overall score.
     * @param scoreToBeAdded number of point to be added to the overall score.
     */
    public void addScore(int scoreToBeAdded) {
        score += scoreToBeAdded;
    }

    /**
     * Method for getting the score of the player.
     * @return Score the player has as a String.
     */
    public String getScore() {
        return "Score: " + this.score;
    }
}
