package dk.headlezz.bjorn.rolldice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import dk.headlezz.bjorn.rolldice.BE.Dice;
import dk.headlezz.bjorn.rolldice.BE.Round;
import dk.headlezz.bjorn.rolldice.BE.RoundLog;

/**
 * Created by headlezz on 07-03-2016.
 */
public class SecondaryActivity extends AppCompatActivity {

    Button btnBack;
    Button btnClear;
    ListView listView;
    MainActivity main;
    RoundLog rlog = RoundLog.getInstance();
    RoundAdapter ra;

    ArrayList<Round> allRounds = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnClear = (Button)findViewById(R.id.btnClear);
        listView = (ListView)findViewById(R.id.listView);

        allRounds = rlog.getRoundLog();

        ra = new RoundAdapter(this, R.layout.listitem, rlog.getRoundLog());

        listView.setAdapter(ra);

        btnBack.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                SecondaryActivity.this.gotoMain();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondaryActivity.this.clearList();
            }
        });

    }

    private void gotoMain() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

    private void clearList(){
        allRounds.clear();
        ra.notifyDataSetChanged();
    }

}

class RoundAdapter extends ArrayAdapter<Round> {

    private ArrayList<Round> rounds;


    public RoundAdapter(Context context, int textViewResourceId,
                       ArrayList<Round> rounds) {
        super(context, textViewResourceId, rounds);
        this.rounds = rounds;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        if (v == null) {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.listitem, null);
            Log.d("LIST", "Position: " + position + " View created");
        } else
            Log.d("LIST", "Position: " + position + " View Reused");

        Round r = rounds.get(position);

        TextView timestamp = (TextView) v.findViewById(R.id.timestamp);
        TextView eyeamount = (TextView) v.findViewById(R.id.eyeamount);

        timestamp.setText(r.getTimestamp() + "");
        eyeamount.setText(r.getDices().getFaceValue() + " - " + r.getDices2().getFaceValue());

        return v;
    }
}
