package com.example.darpan.mechanico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Book_now extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);
        Spinner spinner1;

        spinner1= (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> myadapter=new ArrayAdapter<>(Book_now.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Car));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myadapter);

    }
}