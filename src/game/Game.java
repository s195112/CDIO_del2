package game;

import java.util.Scanner;

public class Game {

    final static int DICE = 2;
    final static int DIE_MAXVALUE = 6;
    final static int PLAYERS = 2;
    final static int POINTS_GOAL = 3000;

    public static void main(String[] args) {


        String newInput;
        Scanner scan = new Scanner(System.in);

        String[] playerNames = new String[PLAYERS];

        // Make an array with the requested number of players.
        for (int i = 0; i < PLAYERS; i++) {
            System.out.println("Please enter name of player " + (i + 1) + ":");
            // While loop to ensure that all players get names, also prevents whitespaces in console.
            while (true) {
                newInput = scan.nextLine();
                if (newInput.equals("")) {
                    System.out.println("Invalid input.");
                    System.out.println("Please enter name of player " + (i + 1) + ":");
                } else {
                    playerNames[i] = newInput;
                    break;
                }
            }
        }

        int playerTurn;
        boolean end = true;

        do {

            // Create instances of objects
            Beaker beaker = new Beaker(DICE, DIE_MAXVALUE);
            Board board = new Board(PLAYERS, playerNames);
            playerTurn = 0;

            // Play game until someone wins
            while (true) {

                // Announce player turn
                System.out.printf("\nIt is %s's turn.\n", board.getName(playerTurn));

                // Prompt player for input and wait
                Utility.awaitEnter();

                // Roll the dice and move that number of tiles on the board
                beaker.roll();
                int diceResult = beaker.getSum();
                System.out.printf("You rolled %d\n", diceResult);
                board.movePlayer(playerTurn, diceResult);

                // Execute tileAction for the given tile
                board.tileAction(playerTurn);

                // Has the player won? If so, announce winner and break the loop
                if (board.getBalance(playerTurn) >= POINTS_GOAL) {
                    System.out.printf("You have reached the goal of %d points, and win! Congratulations, %s!\n", POINTS_GOAL, board.getName(playerTurn));
                    break;

                } else { // Go on to next turn

                    // Check if current player got an extra turn
                    if (!board.getExtraTurn(playerTurn)) {

                        // If they didn't get an extra turn, move on to the next one
                        playerTurn = (playerTurn + 1) % PLAYERS;
                        
                    } else {

                        // If they did get an extra turn, remove it for next round
                        board.setExtraTurn(playerTurn, false);
                    }
                }
            }

            // Check if user wants to play again
            System.out.print("\nGG. Play again? (Y/N) ");
            newInput = scan.nextLine();

            char c = newInput.charAt(0);
            switch (c) {
                case 'Y', 'y' -> end = false;
                case 'N', 'n' -> end = true;
                default -> System.out.println("Input not recognized: Ending game.");
            }
        } while (!end);
        scan.close();
    }
}
