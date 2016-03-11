package dk.headlezz.bjorn.rolldice.BE;

import java.util.ArrayList;

/**
 * Created by headlezz on 07-03-2016.
 */
public class RoundLog {
    private ArrayList<Round> roundLog = new ArrayList<>();

    private static RoundLog instance = null;
    protected RoundLog() {
        // Exists only to defeat instantiation.
    }
    public static RoundLog getInstance() {
        if(instance == null) {
            instance = new RoundLog();
        }
        return instance;
    }

    public ArrayList<Round> getRoundLog() {
        return roundLog;
    }

    public void addRound(Round r){
        roundLog.add(r);
    }
}
