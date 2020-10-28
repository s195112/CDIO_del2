package game;

import java.util.Scanner;

public class Board {
    // Declarations
    final private Tile[] gameBoard;
    final private Player[] scoreBoard;

    // Constructor. Loads XML info into Tile array. Sets Player names.
    public Board (int players) {
        this.gameBoard = Utility.tileGenerator("src/game/tileList.xml");
        Scanner input = new Scanner(System.in);
        String newInput;
        boolean blank;
        this.scoreBoard = new Player[players];

        // Make an array with the requested number of players.
        for (int i = 0; i < players; i++) {
            System.out.println("Please enter name of player " + (i + 1) + ":");
            blank = true;
            // While loop to ensure that all players get names, also prevents whitespaces in console.
            while (blank) {
                newInput = input.nextLine();
                if (newInput.equals("")) {
                    System.out.println("Invalid input.");
                    System.out.println("Please enter name of player " + (i + 1) + ":");
                } else {
                    this.scoreBoard[i] = new Player(newInput, 1000);
                    blank = false;
                }
            }
        }
    }
    // Move the player on the board.
    public void movePlayer(int player,int increment){
        int currentPosition = this.scoreBoard[player].getPosition();
        int newPosition = (currentPosition + increment) % gameBoard.length;
        this.scoreBoard[player].setPosition(newPosition);
    }
    // Execute action of the tile the player is on
    public void tileAction(int player){
        int tile = this.scoreBoard[player].getPosition();
        int value = this.gameBoard[tile].getPoints();

        System.out.println("You've landed on tile " + (tile + 1) + ".");
        System.out.println(this.gameBoard[tile].getName());
        System.out.println(this.gameBoard[tile].getFlavorText());

        // Announce the coming change in player balance.
        if (value > 0){ System.out.println("You get " + value + " gold coins."); }
        else if (value < 0){ System.out.println("You lose " + (-value) + " gold coins."); }
        else { System.out.println("You don't get any gold coins, but you don't lose any either."); }

        // Attempt to make the transaction. If transaction fails, set balance to 0, and announce player broke.
        boolean transaction = this.scoreBoard[player].makeTransaction(value);
        if (!transaction){
            System.out.println("You don't have enough gold coins. You are broke.");
            this.scoreBoard[player].setBalance(0);
        }

        // Announce new balance
        System.out.println("You now have " + this.scoreBoard[player].getBalance() + " gold coins in total.");

        // Set extra turn
        if (this.gameBoard[tile].getExtraTurn()) {
            System.out.println("You get an extra turn.");
            this.scoreBoard[player].setExtraTurn(true);
        }
    }
    // Relevant getters for players
    public int getPosition(int player){ return this.scoreBoard[player].getPosition(); }
    public int getBalance(int player){ return this.scoreBoard[player].getBalance(); }
    public String getName(int player){ return this.scoreBoard[player].getName(); }

    // Relevant setters for players
    public void setPosition(int player,int newPosition){ this.scoreBoard[player].setPosition(newPosition); }
    public void setBalance(int player,int newBalance){ this.scoreBoard[player].setPosition(newBalance); }
    public void setExtraTurn(int player, boolean extraTurn){ this.scoreBoard[player].setExtraTurn(extraTurn); }
}
