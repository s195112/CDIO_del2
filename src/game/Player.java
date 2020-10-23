package game;

public class Player {
    //Variable
    private int PlayerScore;
    final private String PlayerName;

    //Constructor: Defining variables
    public Player(String inputPlayerName) {
        PlayerName = inputPlayerName;
        PlayerScore = 0;
    }

    // Setting the player score
    public void setPlayerScore(int Point) {
        this.PlayerScore = this.PlayerScore + Point;
    }

    // Getting the player score, then returning it.
    public int getPlayerScore() {
        return this.PlayerScore;
    }

    // Getting the player name, then returning it.
    public String getPlayerName() {
        return this.PlayerName;
    }
}
