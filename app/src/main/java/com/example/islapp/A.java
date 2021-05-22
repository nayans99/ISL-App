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

import com.squareup.picasso.Picasso;
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
            //   i.setImage;
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fa.jpg?alt=media&token=89588175-e79a-47e8-a82f-182b981223ea").into(i);
        }
        if (b.getInt("pos") == 1) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fb.jpg?alt=media&token=a1e14e9d-20b7-4713-a874-74bfb02691df").into(i);
        }
        if (b.getInt("pos") == 2) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fc.jpg?alt=media&token=304f39dd-0749-4c9f-a12b-e59da38aa463").into(i);
        }
        if (b.getInt("pos") == 3) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fd.jpg?alt=media&token=74e67726-1703-4469-b9c0-3f0d8b225be0").into(i);
        }
        if (b.getInt("pos") == 4) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fe.jpg?alt=media&token=b4e6fce1-afa6-48ef-89e9-eea2a3eaa3f9").into(i);
        }
        if (b.getInt("pos") == 5) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Ff.jpg?alt=media&token=559a2f81-1652-4e26-8ad8-b5dcb7d87648").into(i);
        }
        if (b.getInt("pos") == 6) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fg.jpg?alt=media&token=309fc413-bcc6-4717-8b23-49cc4a42464a").into(i);
        }
        if (b.getInt("pos") == 7) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fh.jpg?alt=media&token=9070fe87-cf61-43a6-bd6e-9a477f9ff6dd").into(i);
        }
        if (b.getInt("pos") == 8) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fi.jpg?alt=media&token=04ef4fe1-daae-49d5-bda1-57dc2ed1685b").into(i);
        }
        if (b.getInt("pos") == 9) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fj.jpg?alt=media&token=19fe3ff4-ed5c-4d95-83b8-4d1bef8bfdc3").into(i);
        }
        if (b.getInt("pos") == 10) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fk.jpg?alt=media&token=456c61ad-3c62-4a69-859c-adcee0116d8a").into(i);
        }
        if (b.getInt("pos") == 11) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fl.jpg?alt=media&token=37cf6a0a-5f43-4e64-a8be-5917d38578ba").into(i);
        }
        if (b.getInt("pos") == 12) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fm.jpg?alt=media&token=9343fd63-3051-48a1-a9c4-01fbf3f80de0").into(i);
        }
        if (b.getInt("pos") == 13) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fn.jpg?alt=media&token=df443508-c1f7-4bd8-812c-b740d4df145c").into(i);
        }
        if (b.getInt("pos") == 14) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fo.jpg?alt=media&token=62df6906-a14e-413a-b30d-f3f914b758f1").into(i);
        }
        if (b.getInt("pos") == 15) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fp.jpg?alt=media&token=bc002675-10a5-4fe6-9b50-bc620ef7088a").into(i);
        }
        if (b.getInt("pos") == 16) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fq.jpg?alt=media&token=053a76f3-ae5b-4336-bda7-6e1231869a4f").into(i);
        }
        if (b.getInt("pos") == 17) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fr.jpg?alt=media&token=4f928a8a-9530-418b-b5ff-42a5ea122a31").into(i);
        }
        if (b.getInt("pos") == 18) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fs.jpg?alt=media&token=42a08240-498b-407e-803c-b6c6c8abac1c").into(i);
        }
        if (b.getInt("pos") == 19) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Ft.jpg?alt=media&token=49e9c625-3c83-48f5-ad61-06cb73c3f378").into(i);
        }
        if (b.getInt("pos") == 20) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fu.jpg?alt=media&token=74e5f71d-96f4-4669-9a08-760df8b1b677").into(i);
        }
        if (b.getInt("pos") == 21) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fv.jpg?alt=media&token=77bc7e66-5c46-4fa8-848a-92aec9e76fcf").into(i);
        }
        if (b.getInt("pos") == 22) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fw.jpg?alt=media&token=39999ee4-0250-43d9-832e-08a563271a73").into(i);
        }
        if (b.getInt("pos") == 23) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fx.jpg?alt=media&token=98d53df4-979b-4d7e-8aaf-6c5d37d92c67").into(i);
        }
        if (b.getInt("pos") == 24) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fy.jpg?alt=media&token=6261c7b9-ad11-465d-8b6c-95914ee014d0").into(i);
        }
        if (b.getInt("pos") == 25) {
            Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/isl-knpy.appspot.com/o/Images%2Fz.jpg?alt=media&token=96021241-84fa-436b-a418-c8c9b021bdd5").into(i);
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
