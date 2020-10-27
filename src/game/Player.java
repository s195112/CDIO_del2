package game;

public class Player {
    //Variable
    final private String PlayerName;
    final private Account account;
    private int position;
    private boolean extraTurn;

    //Constructor: Defining variables
    public Player(String inputPlayerName, int startBalance) {
        account = new Account(startBalance);
        PlayerName = inputPlayerName;
    }

    // Relevant setters
    public int getBalance() { return this.account.getBalance(); }
    public String getPlayerName() {
        return this.PlayerName;
    }
    public int getPosition() { return this.position; }
    public boolean getExtraTurn() { return this.extraTurn; }

    // Relevant setters
    public void setBalance(int newBalance) { this.account.setBalance(newBalance); }
    public void setPosition(int newPosition) { this.position = newPosition; }
    public void setExtraTurn(boolean b) { this.extraTurn = b; }

    // Attempt to make a transaction, returns true if successful.
    public boolean makeTransaction(int points) { return this.account.makeTransaction(points); }

}
