package com.licathryn.quizappv4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    SeekBar seekBar;
    Button layout2;
    Button layout3;
    Button layout4;
    Button layout5;
    Button layout6;
    Button layout7;
    Button lab05;

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
        editor.apply();

        score1.setText(""+sharedPreferences.getInt("score1", 0));
        score2.setText(""+sharedPreferences.getInt("score2", 0));
        score3.setText(""+sharedPreferences.getInt("score3", 0));
        score4.setText(""+sharedPreferences.getInt("score4", 0));

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

        layout2=findViewById(R.id.activity3);
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        layout3=findViewById(R.id.activity4);
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        layout4=findViewById(R.id.activity5);
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
        layout5=findViewById(R.id.activity6);
        layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });
        layout6=findViewById(R.id.activity7);
        layout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });
        layout7=findViewById(R.id.activity8);
        layout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity8();
            }
        });
        lab05=findViewById(R.id.lab05);
        lab05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLab05();
            }
        });
    }


    class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            Log.i("textnumber", "" + v.getId());
            int id = v.getId();

            String textnum = "";
            int pressednum = 0;
            if (id % 10 == 7) {
                editor.putInt("score1", sharedPreferences.getInt("score1", 0)+1);
                textnum = "1";
                pressednum = sharedPreferences.getInt("score1", 0);
            } else if (id % 10 == 8) {
                editor.putInt("score2", sharedPreferences.getInt("score2", 0)+1);
                textnum = "2";
                pressednum = sharedPreferences.getInt("score2", 0);
            } else if (id % 10 == 9) {
                editor.putInt("score3", sharedPreferences.getInt("score3", 0)+1);
                textnum = "3";
                pressednum = sharedPreferences.getInt("score3", 0);
            } else {
                editor.putInt("score4", sharedPreferences.getInt("score4", 0)+1);
                textnum = "4";
                pressednum = sharedPreferences.getInt("score4", 0);
            }
            editor.apply();

            TextView tv = (TextView) v;
            tv.setText(pressednum + "");

            Toast.makeText(getApplicationContext(), "You've pressed button " + textnum + " this many times: " + pressednum, Toast.LENGTH_SHORT).show();
//        v.getTag();
//        TextView tv = (TextView)v;
//        tv.setText();
        }
    }
    public void openActivity3() {
        Intent intent=new Intent(this, Activity3.class);
        startActivity(intent);
        // https://www.youtube.com/watch?v=bgIUdb-7Rqo&vl=en
        // https://developer.android.com/guide/topics/manifest/manifest-intro.html
    }
    public void openActivity4() {
        Intent intent=new Intent(this, Activity4.class);
        startActivity(intent);
    }
    public void openActivity5() {
        Intent intent=new Intent(this, Activity5.class);
        startActivity(intent);
    }
    public void openActivity6() {
        Intent intent=new Intent(this, Activity6.class);
        startActivity(intent);
    }
    public void openActivity7() {
        Intent intent=new Intent(this, Activity7.class);
        startActivity(intent);
    }
    public void openActivity8() {
        Intent intent=new Intent(this, Activity8.class);
        startActivity(intent);
    }
    public void openLab05() {
        Intent intent=new Intent(this, ActivityLab05.class);
        startActivity(intent);
    }
}