package dk.headlezz.bjorn.rolldice.BE;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by headlezz on 29-02-2016.
 */
public class Round {

    private String timestamp;
    public Dice dice;
    public Dice dice2;

    public Round(){
        dice = new Dice();
        dice2 = new Dice();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Dice getDices() {
        return dice;
    }
    public Dice getDices2() {
        return dice2;
    }


    public void setDices(Dice dice) {
        this.dice = dice;
    }
    public void setDices2(Dice dice2) {
        this.dice2 = dice2;
    }

}
