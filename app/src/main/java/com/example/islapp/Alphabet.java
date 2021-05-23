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


public class Alphabet extends AppCompatActivity {
    ImageView i, j;
    Button b1;
    TextView l;
    Bundle b;
    Uri img;
    AlphaClassifier alphaClassifier;
    int pos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity);
        loadAlphaClassifier();
        i = findViewById(R.id.imageView1);
        j = findViewById(R.id.imageView2);
        l = findViewById(R.id.text);
        b1 = findViewById(R.id.bu);
        b = getIntent().getExtras();
        pos = b.getInt("pos");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(Alphabet.this);
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
                image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), img);
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
        Log.d("h2ello", "onImageCaptured: " + recognitions);
        // tv.setText("Plastic");
        // rate.setText("5");
        Log.d("hello", "onImageCaptured: ");
        int i;
        float max = 0;
        int index = 0;
        for (i = 0; i < 35; i++) {
            Log.d("looparr", "onImageCaptured: " + recognitions[0][i]);
            if (recognitions[0][i] > max) {
                max = recognitions[0][i];
                index = i;
                //break;
            }
        }
        int score = (int) (recognitions[0][9 + pos] * 100);
        String prediction = AlphaISLModelConfig.OUTPUT_LABELS.get(index).toString();
        int predicted_score = (int) (recognitions[0][index] * 100);
        String current = AlphaISLModelConfig.OUTPUT_LABELS.get(9 + pos).toString();
        l.setText(prediction + " : " + predicted_score + " " + current + " : " + score);
    }

    private int getScreenWidth1() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        (this).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
