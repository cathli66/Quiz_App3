package com.licathryn.quizappv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;


public class ActivityLab05 extends AppCompatActivity {
    int[] currentRun = new int[7];
    TextView create1;
    TextView start1;
    TextView resume1;
    TextView pause1;
    TextView stop1;
    TextView restart1;
    TextView destroy1;
    TextView create2;
    TextView start2;
    TextView resume2;
    TextView pause2;
    TextView stop2;
    TextView restart2;
    TextView destroy2;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("runtimeStats", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
        setContentView(R.layout.activity_lab05);
        create1 = findViewById(R.id.create);
        create2 = findViewById(R.id.create2);
        start1 = findViewById(R.id.start);
        start2 = findViewById(R.id.start2);
        resume1 = findViewById(R.id.resume);
        resume2 = findViewById(R.id.resume2);
        pause1 = findViewById(R.id.pause);
        pause2 = findViewById(R.id.pause2);
        stop1 = findViewById(R.id.stop);
        stop2 = findViewById(R.id.stop2);
        restart1 = findViewById(R.id.restart);
        restart2 = findViewById(R.id.restart2);
        destroy1 = findViewById(R.id.destroy);
        destroy2 = findViewById(R.id.destroy2);

        currentRun[0]++;
        editor.putInt("create2", sharedPreferences.getInt("create2", 0)+1);
        editor.apply();
        create1.setText("onCreate(): "+currentRun[0]);
        create2.setText("onCreate(): "+sharedPreferences.getInt("create2", 0));
        start2.setText("onStart(): "+sharedPreferences.getInt("start2", 0));
        resume2.setText("onResume(): "+sharedPreferences.getInt("resume2", 0));
        pause2.setText("onPause(): "+sharedPreferences.getInt("pause2", 0));
        stop2.setText("onStop(): "+sharedPreferences.getInt("stop2", 0));
        restart2.setText("onRestart(): "+sharedPreferences.getInt("restart2", 0));
        destroy2.setText("onDestroy(): "+sharedPreferences.getInt("destroy2", 0));
    }
    protected void onStart() {
        super.onStart();
        currentRun[1]++;
        editor.putInt("start2", sharedPreferences.getInt("start2", 0)+1);
        editor.apply();
        start1.setText("onStart(): "+currentRun[1]);
        start2.setText("onStart(): "+sharedPreferences.getInt("start2", 0));
    }
    protected void onResume() {
        super.onResume();
        currentRun[2]++;
        editor.putInt("resume2", sharedPreferences.getInt("resume2", 0)+1);
        editor.apply();
        resume1.setText("onResume(): "+currentRun[2]);
        resume2.setText("onResume(): "+sharedPreferences.getInt("resume2", 0));
    }
    protected void onPause() {
        super.onPause();
        currentRun[3]++;
        editor.putInt("pause2", sharedPreferences.getInt("pause2", 0)+1);
        editor.apply();
        pause1.setText("onPause(): "+currentRun[3]);
        pause2.setText("onPause(): "+sharedPreferences.getInt("pause2", 0));
    }
    protected void onStop() {
        super.onStop();
        currentRun[4]++;
        editor.putInt("stop2", sharedPreferences.getInt("stop2", 0)+1);
        editor.apply();
        stop1.setText("onStop(): "+currentRun[4]);
        stop2.setText("onStop(): "+sharedPreferences.getInt("stop2", 0));
    }
    protected void onRestart() {
        super.onRestart();
        currentRun[5]++;
        editor.putInt("restart2", sharedPreferences.getInt("restart2", 0)+1);
        editor.apply();
        restart1.setText("onRestart(): "+currentRun[5]);
        restart2.setText("onRestart(): "+sharedPreferences.getInt("restart2", 0));
    }
    protected void onDestroy() {
        super.onDestroy();
        currentRun[6]++;
        editor.putInt("destroy2", sharedPreferences.getInt("destroy2", 0)+1);
        editor.apply();
        destroy1.setText("onDestroy(): "+currentRun[6]);
        destroy2.setText("onDestroy(): "+sharedPreferences.getInt("destroy2", 0));
    }
}

