package com.example.islapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    CardView mycard, c, c1, c2, c3, c4;
    Intent i;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ll = findViewById(R.id.ll);
        mycard = findViewById(R.id.bankcardId);
        i = new Intent(this, MainActivity1.class);
        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Ae.class));
            }
        });
        c = findViewById(R.id.c1);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });
        c1 = findViewById(R.id.c2);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WordsActivity.class));
            }
        });
        c2 = findViewById(R.id.c4);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });
    }
}