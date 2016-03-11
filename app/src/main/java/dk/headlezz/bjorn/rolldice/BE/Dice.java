package dk.headlezz.bjorn.rolldice.BE;

import java.util.Random;

/**
 * Created by headlezz on 29-02-2016.
 */
public class Dice {

    private Random r;
    private int FaceValue;

    public Dice(){
        r = new Random();
    }

    public void ThrowDice(){
        setFaceValue(r.nextInt(6)+1);
    }

    public int getFaceValue() {
        return FaceValue;
    }

    public void setFaceValue(int faceValue) {
        FaceValue = faceValue;
    }
}
