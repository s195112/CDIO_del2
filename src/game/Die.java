package game;
import java.lang.Math;

public class Die {

    int faceValue;

    //Roll the dice, and return the value
    public int roll(){
        this.faceValue = (int)(Math.random()*6) + 1;
        return this.faceValue;
    }

    //Get the current value of the dice
    public int getFaceValue(){
        return this.faceValue;
    }
}