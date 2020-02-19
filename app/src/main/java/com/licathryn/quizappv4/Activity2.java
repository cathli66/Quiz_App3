package com.licathryn.quizappv4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView score1;
    TextView score2;
    TextView score3;
    TextView score4;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int s1, s2, s3, s4 = 0;

    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        score3 = findViewById(R.id.score3);
        score4 = findViewById(R.id.score4);
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        s1 = sharedPreferences.getInt("score1", 0);
        s2 = sharedPreferences.getInt("score2", 0);
        s3 = sharedPreferences.getInt("score3", 0);
        s4 = sharedPreferences.getInt("score4", 0);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int size = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                size = progress + 12;
                score1.setTextSize(size);
                score2.setTextSize(size);
                score3.setTextSize(size);
                score4.setTextSize(size);
                text1.setTextSize(size);
                text2.setTextSize(size);
                text3.setTextSize(size);
                text4.setTextSize(size);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Listener x = new Listener();
        score1.setOnClickListener(x);
        score2.setOnClickListener(x);
        score3.setOnClickListener(x);
        score4.setOnClickListener(x);
    }


    class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            editor.putInt("score1", s1+1);
            editor.putInt("score2", s2+1);
            editor.putInt("score3", s3+1);
            editor.putInt("score4", s4+1);
            editor.apply();
            Log.i("textnumber", "" + v.getId());
            int id = v.getId();
            TextView tv = (TextView) v;
            tv.setText((Integer.parseInt(tv.getText().toString()) + 1) + "");
            String textnum = "";
            int pressednum = 0;
            if (id % 10 == 7) {
                textnum = "1";
                pressednum = sharedPreferences.getInt("score1", 0);
            } else if (id % 10 == 8) {
                textnum = "2";
                pressednum = sharedPreferences.getInt("score2", 0);
            } else if (id % 10 == 9) {
                textnum = "3";
                pressednum = sharedPreferences.getInt("score3", 0);
            } else {
                textnum = "4";
                pressednum = sharedPreferences.getInt("score4", 0);
            }
            Toast.makeText(getApplicationContext(), "You've pressed button " + textnum + " this many times: " + pressednum, Toast.LENGTH_SHORT).show();
//        v.getTag();
//        TextView tv = (TextView)v;
//        tv.setText();
        }
    }

}