package com.example.darpan.mechanico;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;



public class Book_now extends AppCompatActivity {

    Button car,model,type;
    TextView itemselected,itemselected1,itemselected2;
    String[] listItems,listhonda;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);
        Spinner spinner1;

        spinner1= (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> myadapter=new ArrayAdapter<>(Book_now.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Car));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myadapter);

        car=(Button)findViewById(R.id.carbtn);
        model=(Button)findViewById(R.id.modelbtn);
        type=(Button)findViewById(R.id.typebtn);
        itemselected=(TextView)findViewById(R.id.cartext);
        itemselected1=(TextView)findViewById(R.id.modeltext);
        itemselected=(TextView)findViewById(R.id.typetext);
        listItems = getResources().getStringArray(R.array.cars);
        listhonda = getResources().getStringArray(R.array.Honda);

        checkedItems = new boolean[listItems.length];

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Book_now.this);
                mBuilder.setTitle("Select the car");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        itemselected.setText(listItems[i]);
                        dialog.dismiss();


                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        if(itemselected.equals("Honda"))
        {
            model.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Book_now.this);
                    mBuilder.setTitle("Select the car");
                    mBuilder.setSingleChoiceItems(listhonda, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            itemselected.setText(listhonda[i]);
                            dialog.dismiss();


                        }
                    });
                    AlertDialog mDialog = mBuilder.create();
                    mDialog.show();

                }
            });
        }



    }
}