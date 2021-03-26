package com.example.islapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    EditText a, b;
    Button c, g;
    FirebaseAuth mAuth;
    GoogleSignInOptions gso;
    ProgressDialog p;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createuser_activity);
        a = findViewById(R.id.editText);
        b = findViewById(R.id.pwd);
        g = findViewById(R.id.google_login_btn);
        mAuth = FirebaseAuth.getInstance();
        c = findViewById(R.id.a1);
        p = new ProgressDialog(this);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });

    }

    void createAccount() {
        String email = a.getText().toString();
        String pwd = b.getText().toString();
        if (TextUtils.isEmpty(email))
            Toast.makeText(RegisterActivity.this, "Enter Email PloX!!!", Toast.LENGTH_SHORT).show();
        if (TextUtils.isEmpty(pwd))
            Toast.makeText(RegisterActivity.this, "Enter Password PloX!!!", Toast.LENGTH_SHORT).show();
        else {
            p.setTitle("Creating new account");
            p.setMessage("Please wait, while we are creating new account for you....");
            p.setCanceledOnTouchOutside(true);
            p.show();
            mAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        Toast.makeText(RegisterActivity.this, "Account Created!!", Toast.LENGTH_SHORT).show();
                        p.dismiss();
                    } else
                        Toast.makeText(RegisterActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            gotoDashboard();
        } else {
            Toast.makeText(getApplicationContext(), result.getStatus().toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void gotoDashboard() {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }
}