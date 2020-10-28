package test;
import game.Die;
import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    int n = 6;
    Die die = new Die(n);
    int tests = 10000;
    int diceSpread = 400;

    @org.junit.jupiter.api.Test
    void roll() {

        for (int i = 0; i < tests; i++) {

            die.roll();
            int result = die.getFaceValue();
            assertTrue(result>=1 && result<=n);
        }

        int[] spread = new int[n];

        for (int i = 0; i < tests; i++) {
            die.roll();
            int result = die.getFaceValue();
            spread[result-1]++;

        }

        for (int i = 0; i < spread.length-1; i++) {
            assertTrue(spread[i]>tests/n-diceSpread && spread[i]<tests/n+diceSpread);
        }
    }
}