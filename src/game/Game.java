package game;

public class Game {
    public static void main(String[] args) {
        // Create instances of objects
        Beaker beaker = new Beaker(2, 6);
        Board board = new Board(2);
        int playerTurn = 0;
        boolean noWinner = true;

        while (noWinner){
            // Announce player turn.

            // Roll the dice and move that number of tiles on the board.

            // Execute tileAction for the given tile.

            // Has the player won? If so, announce winner and break the loop.

            // Change player turn.
        }
    }
}