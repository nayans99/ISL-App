package com.example.islapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;


public class A extends AppCompatActivity {
    ImageView i, j;
    Button b1;
    TextView l;
    Bundle b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity);
        i = findViewById(R.id.imageView1);
        j = findViewById(R.id.imageView2);

        b1 = findViewById(R.id.bu);
        b = getIntent().getExtras();
        if (b.getInt("pos") == 0) {
            i.setImageResource(R.drawable.a);
        }
        if (b.getInt("pos") == 1) {
            i.setImageResource(R.drawable.b);
        }
        if (b.getInt("pos") == 2) {
            i.setImageResource(R.drawable.c);
        }
        if (b.getInt("pos") == 3) {
            i.setImageResource(R.drawable.d);
        }
        if (b.getInt("pos") == 4) {
            i.setImageResource(R.drawable.e);
        }
        if (b.getInt("pos") == 5) {
            i.setImageResource(R.drawable.f);
        }
        if (b.getInt("pos") == 6) {
            i.setImageResource(R.drawable.g);
        }
        if (b.getInt("pos") == 7) {
            i.setImageResource(R.drawable.h);
        }
        if (b.getInt("pos") == 8) {
            i.setImageResource(R.drawable.i);
        }
        if (b.getInt("pos") == 9) {
            i.setImageResource(R.drawable.j);
        }
        if (b.getInt("pos") == 10) {
            i.setImageResource(R.drawable.k);
        }
        if (b.getInt("pos") == 11) {
            i.setImageResource(R.drawable.l);
        }
        if (b.getInt("pos") == 12) {
            i.setImageResource(R.drawable.m);
        }
        if (b.getInt("pos") == 13) {
            i.setImageResource(R.drawable.n);
        }
        if (b.getInt("pos") == 14) {
            i.setImageResource(R.drawable.o);
        }
        if (b.getInt("pos") == 15) {
            i.setImageResource(R.drawable.p);
        }
        if (b.getInt("pos") == 16) {
            i.setImageResource(R.drawable.q);
        }
        if (b.getInt("pos") == 17) {
            i.setImageResource(R.drawable.r);
        }
        if (b.getInt("pos") == 18) {
            i.setImageResource(R.drawable.s);
        }
        if (b.getInt("pos") == 19) {
            i.setImageResource(R.drawable.t);
        }
        if (b.getInt("pos") == 20) {
            i.setImageResource(R.drawable.u);
        }
        if (b.getInt("pos") == 21) {
            i.setImageResource(R.drawable.v);
        }
        if (b.getInt("pos") == 22) {
            i.setImageResource(R.drawable.w);
        }
        if (b.getInt("pos") == 23) {
            i.setImageResource(R.drawable.x);
        }
        if (b.getInt("pos") == 24) {
            i.setImageResource(R.drawable.y);
        }
        if (b.getInt("pos") == 25) {
            i.setImageResource(R.drawable.z);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(A.this);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri img = result.getUri();
                b1.setText("Check results");
                j.setImageURI(img);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
