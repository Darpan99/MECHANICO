package com.example.darpan.mechanico;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class password extends AppCompatActivity {
    private EditText passwordEmail;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        passwordEmail =(EditText)findViewById(R.id.etPasswordEmail);
        resetPassword =(Button)findViewById(R.id.btnPasswordReset);
        firebaseAuth = FirebaseAuth.getInstance();
        getSupportActionBar().hide();
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String useremail = passwordEmail.getText().toString().trim();
                    if(useremail.equals("")){
                        Toast.makeText(password.this, "Enter your registered Email ID", Toast.LENGTH_SHORT).show();
                    }else{
                        firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                 if(task.isSuccessful()){
                                     Toast.makeText(password.this,"Password reset Email sent",Toast.LENGTH_SHORT).show();
                                     finish();
                                     startActivity(new Intent(password.this,LOGIN.class));
                                 }else{
                                     Toast.makeText(password.this, "Error in sneding password reset email. Check email id", Toast.LENGTH_SHORT).show();
                                 }
                            }
                        });

                    }
            }
        });


    }
}