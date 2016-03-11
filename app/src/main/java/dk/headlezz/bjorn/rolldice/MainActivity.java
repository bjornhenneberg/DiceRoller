package dk.headlezz.bjorn.rolldice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import dk.headlezz.bjorn.rolldice.BE.Dice;
import dk.headlezz.bjorn.rolldice.BE.Round;
import dk.headlezz.bjorn.rolldice.BE.RoundLog;

public class MainActivity extends AppCompatActivity {

    Button btnRoll;
    Button btnHistory;
    TextView lblDiceRoll;
    TextView lblDiceRoll2;
    TextView lblTimestamp;
    RoundLog rlog = RoundLog.getInstance();
    ImageView diceImage;
    ImageView diceImage2;

    int eyeamountnr1;
    int eyeamountnr2;
    String timestampAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRoll = (Button)findViewById(R.id.btnRoll);
        btnHistory = (Button)findViewById(R.id.btnHistory);
        lblDiceRoll = (TextView)findViewById(R.id.lblDiceRoll);
        lblDiceRoll2 = (TextView)findViewById(R.id.lblDiceRoll2);
        lblTimestamp = (TextView)findViewById(R.id.lblTimestamp);
        diceImage = (ImageView)findViewById(R.id.imageView);
        diceImage2 = (ImageView)findViewById(R.id.imageView2);



        btnRoll.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.rollDice();
            }
        });
        btnHistory.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.historyBtnPress();
            }
        });


        if (savedInstanceState != null){
            timestampAll = savedInstanceState.getString("1");
            eyeamountnr1 = savedInstanceState.getInt("2");
            eyeamountnr2 = savedInstanceState.getInt("3");


            lblDiceRoll.setText(""+eyeamountnr1);
            lblDiceRoll2.setText(""+eyeamountnr2);
            lblTimestamp.setText(timestampAll);

            if(eyeamountnr1 == 1) {
                diceImage.setImageResource(R.drawable.dice1);
            }
            if(eyeamountnr1 == 2) {
                diceImage.setImageResource(R.drawable.dice2);
            }
            if(eyeamountnr1 == 3) {
                diceImage.setImageResource(R.drawable.dice3);
            }
            if(eyeamountnr1 == 4) {
                diceImage.setImageResource(R.drawable.dice4);
            }
            if(eyeamountnr1 == 5) {
                diceImage.setImageResource(R.drawable.dice5);
            }
            if(eyeamountnr1 == 6) {
                diceImage.setImageResource(R.drawable.dice6);
            }

            if(eyeamountnr2 == 1) {
                diceImage2.setImageResource(R.drawable.dice1);
            }
            if(eyeamountnr2 == 2) {
                diceImage2.setImageResource(R.drawable.dice2);
            }
            if(eyeamountnr2 == 3) {
                diceImage2.setImageResource(R.drawable.dice3);
            }
            if(eyeamountnr2 == 4) {
                diceImage2.setImageResource(R.drawable.dice4);
            }
            if(eyeamountnr2 == 5) {
                diceImage2.setImageResource(R.drawable.dice5);
            }
            if(eyeamountnr2 == 6) {
                diceImage2.setImageResource(R.drawable.dice6);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("1",timestampAll);
        outState.putInt("2",eyeamountnr1);
        outState.putInt("3",eyeamountnr2);
    }

    private void historyBtnPress() {
        Intent intent = new Intent();
        intent.setClass(this, SecondaryActivity.class);
        startActivity(intent);
    }

    public ArrayList<Round> getRoundlog(){
        return rlog.getRoundLog();
    }

    public void rollDice() {
        int eyeamount = 0;
        int eyeamount2 = 0;
        String timestamp = "";

        Round round = new Round();
        round.setTimestamp(new SimpleDateFormat("hh:mm:ss").format(new Date()));

        Dice dice = new Dice();
        dice.ThrowDice();

        Dice dice2 = new Dice();
        dice2.ThrowDice();

        eyeamount = dice.getFaceValue();
        eyeamount2 = dice2.getFaceValue();
        timestamp = round.getTimestamp();

        lblDiceRoll.setText(eyeamount + "");
        lblDiceRoll2.setText(eyeamount2 + "");
        lblTimestamp.setText(timestamp + "");

        round.setTimestamp(timestamp);
        round.setDices(dice);
        round.setDices2(dice2);

        rlog.addRound(round);

        if(eyeamount == 1) {
            diceImage.setImageResource(R.drawable.dice1);
        }
        if(eyeamount == 2) {
            diceImage.setImageResource(R.drawable.dice2);
        }
        if(eyeamount == 3) {
            diceImage.setImageResource(R.drawable.dice3);
        }
        if(eyeamount == 4) {
            diceImage.setImageResource(R.drawable.dice4);
        }
        if(eyeamount == 5) {
            diceImage.setImageResource(R.drawable.dice5);
        }
        if(eyeamount == 6) {
            diceImage.setImageResource(R.drawable.dice6);
        }

        if(eyeamount2 == 1) {
            diceImage2.setImageResource(R.drawable.dice1);
        }
        if(eyeamount2 == 2) {
            diceImage2.setImageResource(R.drawable.dice2);
        }
        if(eyeamount2 == 3) {
            diceImage2.setImageResource(R.drawable.dice3);
        }
        if(eyeamount2 == 4) {
            diceImage2.setImageResource(R.drawable.dice4);
        }
        if(eyeamount2 == 5) {
            diceImage2.setImageResource(R.drawable.dice5);
        }
        if(eyeamount2 == 6) {
            diceImage2.setImageResource(R.drawable.dice6);
        }

        eyeamountnr1 = eyeamount;
        eyeamountnr2 = eyeamount2;
        timestampAll = timestamp;
    }
}
