package test;

import org.junit.jupiter.api.Test;
import game.Board;
import game.Die;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board(new String[]{"John", "Jane"});
    Die d = new Die(12);

    @Test
    void movePlayer() {
        for (int i = 0; i < 1000; i++) {
            d.roll();
            int increment = d.getFaceValue();
            int position = board.getPosition(0);
            board.movePlayer(0, increment);
            assertEquals((position+increment) % 12, board.getPosition(0));

        }
    }

    @Test
    void tileAction() {
        boolean xturn = false;
        for (int i = 0; i < 1000; i++) {

            int money = board.getBalance(0);
            board.movePlayer(0, 1);
            if(board.getPosition(0)==10){
                xturn = true;
            }
            else {
                xturn = false;
            }
            assertEquals(xturn, board.getExtraTurn(0));
            money += getTileAction(board.getPosition(0));
            board.tileAction(0);
            assertEquals(money, board.getBalance(0));
        }
    }
    int getTileAction(int number) {
        switch(number){
            case 1:
                return -60;
                break;

            case 2:
                return 250;
                break;

            case 3:
                return -100;
                break;

            case 4:
                return 100;
                break;

            case 5:
                return -20;
                break;

            case 6:
                return 180;
                break;

            case 7:
                return 0;
                break;

            case 8:
                return -70;
                break;

            case 9:
                return 60;
                break;

            case 10:
                return -80;
                break;

            case 11:
                return -50;
                break;

            case 12:
                return 650;
                break;


        }
    }
}