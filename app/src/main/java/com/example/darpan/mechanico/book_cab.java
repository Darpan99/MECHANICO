package com.example.darpan.mechanico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class book_cab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_cab);
    }

    public void bookuber(View view) {
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.ubercab");
        startActivity(intent);
    }

    public void bookola(View view) {
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.olacabs");
        startActivity(intent);
    }
}
