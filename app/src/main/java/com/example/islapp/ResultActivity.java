package com.example.islapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ResultActivity extends AppCompatActivity {
    CardView a, w, n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);
        a = findViewById(R.id.alphabets1);
        n = findViewById(R.id.numbers1);
        w = findViewById(R.id.words1);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Alphabet
            }
        });
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Words
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //numbers
            }
        });
    }
}