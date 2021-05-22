package com.example.islapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class A extends AppCompatActivity {
    ImageView i, j;
    Button b1;
    TextView l;
    Bundle b;
    Uri img;
    AlphaClassifier alphaClassifier;
    int pos;
    boolean next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        next = false;
        setContentView(R.layout.a_activity);
        loadAlphaClassifier();
        i = findViewById(R.id.imageView1);
        j = findViewById(R.id.imageView2);
        l = findViewById(R.id.text);
        b1 = findViewById(R.id.bu);
        b = getIntent().getExtras();
        pos = b.getInt("pos");
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
                if(next)
                {
                    Intent i = new Intent(A.this, A.class);
                    i.putExtra("pos", pos+1);
                    startActivity(i);
                }
                else {
                    CropImage.activity()
                            .setGuidelines(CropImageView.Guidelines.ON)
                            .start(A.this);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                img = result.getUri();
                b1.setText("Check results");
                j.setImageURI(img);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
            //Predict image
            Bitmap image = null;
            try {
                image = MediaStore.Images.Media.getBitmap(this.getContentResolver(),img);
            } catch (IOException e) {
                Log.d("excentered", "onActivityResult: ");
                e.printStackTrace();
            }
            ByteArrayOutputStream str = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.JPEG, 100, str);
            byte[] byteArray = str.toByteArray();
            onImageCaptured(byteArray);

        } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
            // Exception error = result.getError();

            //
        }
    }


    private void loadAlphaClassifier() {
        try {
            alphaClassifier = AlphaClassifier.classifier(this.getAssets(), AlphaISLModelConfig.MODEL_FILENAME);
        } catch (IOException e) {
            //  Toast.makeText(this, "MNIST model couldn't be loaded. Check logs for details.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void onImageCaptured(byte[] picture) {
        Log.d("pichello", "onImageCaptured: hello");
        Bitmap bitmap = BitmapFactory.decodeByteArray(picture, 0, picture.length);
        Bitmap squareBitmap = ThumbnailUtils.extractThumbnail(bitmap, getScreenWidth1(), getScreenWidth1());
        Log.d("h3ello", "onImageCaptured: ");

        Bitmap preprocessedImage = ImageUtils.prepareImageForClassification(squareBitmap);
        Log.d("h1ello", "onImageCaptured: ");
        float[][] recognitions = alphaClassifier.recognizeImage(preprocessedImage);
        Log.d("h2ello", "onImageCaptured: "+recognitions);
        // tv.setText("Plastic");
        // rate.setText("5");
        Log.d("hello", "onImageCaptured: ");
        int i;
        float max=0;
        int index=0;
        for(i = 0;i<35;i++)
        {
            Log.d("looparr", "onImageCaptured: "+recognitions[0][i]);
            if(recognitions[0][i]>max) {
                max=recognitions[0][i];
                index=i;
                //break;
            }
        }
        int score = (int) (recognitions[0][9+pos]*100);
        String prediction = AlphaISLModelConfig.OUTPUT_LABELS.get(index).toString();
        int predicted_score = (int) (recognitions[0][index]*100);
        String current = AlphaISLModelConfig.OUTPUT_LABELS.get(9+pos).toString();
        Log.d("precur", "onImageCaptured: "+prediction+current);
        if(prediction.equals(current)) {
            l.setText("Congratulations! You passed, move on to next!");
            b1.setText("Next alphabet");
            next = true;
        }
        else {
            l.setText("Sorry, try again"+prediction);
        }
    }
    private int getScreenWidth1() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        (this).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
