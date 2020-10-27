package game;

public class Player {
    //Variable
    final private String PlayerName;
    final private Account account;

    //Constructor: Defining variables
    public Player(String inputPlayerName, int startBalance) {
        account = new Account(startBalance);
        PlayerName = inputPlayerName;
    }
    // Get player account balance.
    public int getBalance(){ return this.account.getBalance(); }

    // Set player account balance.
    public void setBalance(int newBalance){ this.account.setBalance(newBalance); }

    // Attempt to make a transaction, returns true if successful.
    public boolean makeTransaction (int points){ return this.account.makeTransaction(points); }

    // Getting the player name, then returning it.
    public String getPlayerName() {
        return this.PlayerName;
    }
}
