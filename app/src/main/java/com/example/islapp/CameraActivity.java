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
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CameraActivity extends AppCompatActivity {

    Uri img;
    TextView tv;
    Button upload;
    VideoView videoView;
    AlphaClassifier alphaClassifier;
    ImageView imageView;
    final int CAMERA_CAPTURE = 1;
    private Uri picUri;
    final int PIC_CROP = 2;
    final int CAMERA_PIC_REQUEST = 1337;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        loadAlphaClassifier();
        tv = findViewById(R.id.textView);
        upload = findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("https://youtu.be/jonJuDhlx2g");


        videoView.start();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(CameraActivity.this);
            }
        });
    }
    private void loadAlphaClassifier() {
        try {
            alphaClassifier = AlphaClassifier.classifier(this.getAssets(), AlphaISLModelConfig.MODEL_FILENAME);
        } catch (IOException e) {
            //  Toast.makeText(this, "MNIST model couldn't be loaded. Check logs for details.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                Log.d("resulttok", "onActivityResult: ");
                img = result.getUri();

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
                max = recognitions[0][i]; //Use this for score!!!
                index = i;
                //break;
            }
        }
        videoView.setVisibility(View.GONE);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageURI(null);
        imageView.setImageURI(img);
        tv.setText(AlphaISLModelConfig.OUTPUT_LABELS.get(index).toString());
}


    private int getScreenWidth1() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        (this).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

}
