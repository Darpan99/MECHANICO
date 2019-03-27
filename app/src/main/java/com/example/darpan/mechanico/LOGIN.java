package com.example.darpan.mechanico;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LOGIN extends AppCompatActivity {
    public EditText loginEmailId, logInpasswd;
    Button btnLogIn;
    TextView signup, forgotPassword;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);
        getSupportActionBar().hide();
        firebaseAuth = FirebaseAuth.getInstance();
        loginEmailId = findViewById(R.id.editText8);
        logInpasswd = findViewById(R.id.editText9);
        btnLogIn = findViewById(R.id.button3);
        signup = findViewById(R.id.TVSignIn);
        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("services_realtime");
        forgotPassword= (TextView)findViewById(R.id.tvFogotPassword);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
                if (firebaseUser != null) {


                    Toast.makeText(LOGIN.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(LOGIN.this, PAGE3.class);
                    startActivity(I);
                } else {
                    Toast.makeText(LOGIN.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(LOGIN.this, REGISTRATION.class);
                startActivity(I);
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = loginEmailId.getText().toString();
                String userPaswd = logInpasswd.getText().toString();
                if (userEmail.isEmpty()) {
                    loginEmailId.setError("Provide your Email first!");
                    loginEmailId.requestFocus();
                } else if (userPaswd.isEmpty()) {
                    logInpasswd.setError("Enter Password!");
                    logInpasswd.requestFocus();
                } else if (userEmail.isEmpty() && userPaswd.isEmpty()) {
                    Toast.makeText(LOGIN.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(userEmail.isEmpty() && userPaswd.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(userEmail, userPaswd).addOnCompleteListener(LOGIN.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LOGIN.this, "Email id or Password is incorrect", Toast.LENGTH_SHORT).show();
                            } else {
                                firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
                                services_realtime sr123=new services_realtime();
                                String abc=sr123.setDenting("null");
                                databaseReference.child(firebaseUser.getUid()).child("denting").setValue(abc);
                                databaseReference.child(firebaseUser.getUid()).child("service").setValue(abc);
                                databaseReference.child(firebaseUser.getUid()).child("tyre").setValue(abc);
                                databaseReference.child(firebaseUser.getUid()).child("cng").setValue(abc);
                                startActivity(new Intent(LOGIN.this, PAGE3.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(LOGIN.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LOGIN.this, password.class
                ));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
}