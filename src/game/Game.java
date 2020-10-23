package game;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean sixTurn = false, extraTurn = false;
        int a, b, turn = 0;

        String playerName1;
        String playerName2;
        Beaker beaker = new Beaker(2);


        //Scanning for player names
        System.out.println("Input player one");
        Scanner inputs = new Scanner(System.in);
        playerName1 = inputs.next();

        System.out.println("Input player two");
        playerName2 = inputs.next();

        //Making array with players
        Player player1 = new Player(playerName1);

        Player player2 = new Player(playerName2);

        Player[] scoreboard = new Player[]{player1, player2};

        //As long as each players point doesn't reach 40 game continues
        while (true) {

            System.out.println("Player " + scoreboard[turn].getPlayerName() + "'s turn");
            //new turn begins and player rolls
            beaker.roll();

            //show dice faceValue
            a = beaker.getFaceValue(0);
            b = beaker.getFaceValue(1);
            System.out.println(a + " " + b);


            if (sixTurn && beaker.isIdentical() && beaker.getFaceValue(0) == 6) {
                System.out.println("Player " + scoreboard[turn].getPlayerName() + " won");
                break;
            } else {
                sixTurn = false;
            }
            //check if faceValue is identical and if it is 1 if so then reset score for current player
            if (beaker.isIdentical() && beaker.getFaceValue(0) == 1) {
                System.out.println("You have rolled a pair of 1. Your score will be reset");
                scoreboard[turn].setPlayerScore(-scoreboard[turn].getPlayerScore());

            }

            if (beaker.isIdentical() && beaker.getFaceValue(0) == 6) {
                sixTurn = true;
            }


            if (scoreboard[turn].getPlayerScore() >= 40 && beaker.isIdentical()) {
                System.out.println("Player " + scoreboard[turn].getPlayerName() + " won");
                break;
            }

            //add points to scoreBoard with setScore
            scoreboard[turn].setPlayerScore(beaker.getSum());
            //print score
            System.out.println("Your current score is " + scoreboard[turn].getPlayerScore());
            //change turn if faceValue is not identical
            if (beaker.isIdentical() && !extraTurn) {
                System.out.println("You rolled a pair and get an extra turn");
                extraTurn = true;
            } else {
                extraTurn = false;
                turn = (turn + 1) % scoreboard.length;
            }

            System.out.println("Press enter to continue the game...");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
