package com.example.islapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;

public class LoginActivity extends AppCompatActivity {
    Button a, b, c;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    FirebaseAuth f;
    FirebaseAuthProvider h;
    private EditText mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        f = FirebaseAuth.getInstance();
        b = findViewById(R.id.a2);
        c = findViewById(R.id.a3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotActivity.class));
            }
        });
        // Set up the login form.
        a = findViewById(R.id.a1);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }

}

