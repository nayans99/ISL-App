package com.example.islapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class B extends AppCompatActivity {
    VideoView a, a1;
    Uri videoUri;
    Button b, b1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_activity);
        a = findViewById(R.id.v);
        b = findViewById(R.id.test);
        b1 = findViewById(R.id.test1);
        a1 = findViewById(R.id.v1);
        if (getIntent().getExtras().getInt("pos") == 0) {
            a.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/accident.mp4?alt=media&token=fdd3c64d-4f3b-431b-bcf7-e6d7932cdec6"));
            a.requestFocus();
            a.start();
            a.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    a.start();
                }
            });
        }
        if (getIntent().getExtras().getInt("pos") == 1) {
            a.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/help.mp4?alt=media&token=3f62d18e-4a63-48b0-8c0d-ec775244156e"));
            a.requestFocus();
            a.start();
            a.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    a.start();
                }
            });
        }
        if (getIntent().getExtras().getInt("pos") == 2) {
            a.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/call.mp4?alt=media&token=71300547-db7d-492a-bb52-e357cf35afb7"));
            a.requestFocus();
            a.start();
            a.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    a.start();
                }
            });
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if (videoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(videoIntent, 101);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(B.this, "Under Development :)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            videoUri = data.getData();
            a1.setVideoURI(videoUri);
            a1.start();
            b.setText("Retake Video");
            b1.setText("Check!!");
        }
    }
}
