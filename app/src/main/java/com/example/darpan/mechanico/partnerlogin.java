package com.example.darpan.mechanico;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class partnerlogin extends AppCompatActivity {
    Button partnerbtn;
    TextView regpage,fpasswd;
    EditText ed,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partnerlogin);
        getSupportActionBar().hide();
        ed= findViewById(R.id.editText8);
        p= findViewById(R.id.editText9);
        regpage =findViewById(R.id.TVSignIn);
        fpasswd =findViewById(R.id.tvFogotPassword);
        regpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(partnerlogin.this,REGISTRATION.class));
            }
        });
        partnerbtn=findViewById(R.id.psignin);
        partnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed.getText().toString().equals("mp1") && p.getText().toString().equals("001")){
                    startActivity(new Intent(partnerlogin.this,partnerorders.class));
                    Toast.makeText(partnerlogin.this,"Login Successful",Toast.LENGTH_SHORT).show();
                }
                if (ed.getText().toString().equals("mp2") && p.getText().toString().equals("002")){
                    startActivity(new Intent(partnerlogin.this,partnerorders.class));
                    Toast.makeText(partnerlogin.this,"Login Successful",Toast.LENGTH_SHORT).show();
                }
                if (ed.getText().toString().equals("mp3") && p.getText().toString().equals("003")){
                    startActivity(new Intent(partnerlogin.this,partnerorders.class));
                    Toast.makeText(partnerlogin.this,"Login Successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(partnerlogin.this,"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}