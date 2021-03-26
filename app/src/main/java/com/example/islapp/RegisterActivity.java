package com.example.islapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText e, e2;
    Button a;
    FirebaseAuth mAuth;
    FirebaseUser user;
    String a1, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createuser_activity);
        e = findViewById(R.id.editText);
        e2 = findViewById(R.id.pwd);
        a = findViewById(R.id.a1);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        a1 = e.getText().toString();
        b = e2.getText().toString();
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(a1, b).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        }
    }

    private void reload() {
        mAuth.getCurrentUser().reload().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this,
                            "Reload successful!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this,
                            "Failed to reload user.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

