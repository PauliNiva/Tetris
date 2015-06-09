package applogic;

/**
 * Class for counting score.
 */
public class ScoreCounter {

    private PlayingField playingField;
    private int score;

    public ScoreCounter(PlayingField playingField){
        this.playingField = playingField;
        this.score = 0;
    }

    public void updateScore(int numberOfRowsRemoved) {
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
