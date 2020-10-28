package test;
import game.Die;
import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    int n = 6;
    Die die = new Die(n);
    int tests = 1000;

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

    }
}