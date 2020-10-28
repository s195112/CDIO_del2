package test;
import game.Die;
import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    Die die = new Die(6);
    @org.junit.jupiter.api.Test
    void roll() {

        for (int i = 0; i < 1001; i++) {

            die.roll();
            int result = die.getFaceValue();
            assertTrue(result>=1 && result<=6);
        }
    }
}