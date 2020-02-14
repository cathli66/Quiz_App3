package com.licathryn.quizappv4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Listener x = new Listener();
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text1.setOnClickListener(x);
        text2.setOnClickListener(x);
        text3.setOnClickListener(x);
        text4.setOnClickListener(x);
    }
}

class Listener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        Log.i("text1", ""+v.toString());
        
    }
}
