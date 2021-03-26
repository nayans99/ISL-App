package com.example.islapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button a, b, c, g;
    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
    ProgressBar pbar;
    FirebaseAuthProvider h;
    EditText username, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        a = findViewById(R.id.a1);
        b = findViewById(R.id.a2);
        c = findViewById(R.id.a3);
        username = findViewById(R.id.editText);
        pwd = findViewById(R.id.pwd);
        pbar = findViewById(R.id.progressBar);
        findViewById(R.id.google_login_btn).setOnClickListener(LoginActivity.this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        // updateUI(account);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = username.getText().toString();
                String pwd1 = pwd.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginActivity.this, "Enter Email Plox!!!", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(pwd1)) {
                    Toast.makeText(LoginActivity.this, "Enter Password Plox!!!", Toast.LENGTH_SHORT).show();
                } else {

                    pbar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email, pwd1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Success!!!", Toast.LENGTH_SHORT).show();
                                pbar.setVisibility(View.GONE);
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Login failed!!",
                                        Toast.LENGTH_LONG)
                                        .show();

                                // hide the progress bar
                                pbar.setVisibility(View.GONE);
                            }
                        }
                    });
                }
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotActivity.class));
            }
        });
        // Set up the login form.

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.google_login_btn:
                signIn();
                break;
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            if (task.isSuccessful())
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            else
                handle(task);
        }
    }

    private void handle(Task<GoogleSignInAccount> c) {

        try {
            GoogleSignInAccount a = c.getResult(ApiException.class);
            //updateUI(a);
        } catch (ApiException e) {
            Log.w("Error", "Sign-In Failed=" + e.getStatusCode());

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
//        FirebaseUser user=mAuth.getCurrentUser();
//        updateUI(user);
    }
}

