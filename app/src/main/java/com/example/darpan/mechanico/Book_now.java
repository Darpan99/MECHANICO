package com.example.darpan.mechanico;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class Book_now extends AppCompatActivity {

    Button car,model,type;
    TextView itemselected,itemselected1,itemselected2;
    String[] listItems,listhonda,listhyundai,listtype,listtoyota,listford,listvolkswagen;
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
        itemselected=(EditText)findViewById(R.id.cartext);
        itemselected1=(EditText)findViewById(R.id.modeltext);
        itemselected2=(EditText)findViewById(R.id.typetext);
        listItems = getResources().getStringArray(R.array.cars);
        listhonda = getResources().getStringArray(R.array.Honda);
        listhyundai = getResources().getStringArray(R.array.Hyundai);
        listtoyota = getResources().getStringArray(R.array.Toyota);
        listford= getResources().getStringArray(R.array.Ford);
        listtype=getResources().getStringArray(R.array.fuel);
        listvolkswagen=getResources().getStringArray(R.array.Volkswagen);
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



            type.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Book_now.this);
                    mBuilder.setTitle("Select");
                    mBuilder.setSingleChoiceItems(listtype, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            itemselected2.setText(listtype[i]);
                            dialog.dismiss();


                        }
                    });
                    AlertDialog mDialog = mBuilder.create();
                    mDialog.show();
                }
            });





    }
    public void modelname(View view)
    {
        if((itemselected.getText().toString()).equalsIgnoreCase("Honda"))
        {
            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Book_now.this);
            mBuilder.setTitle("Select model");
            mBuilder.setSingleChoiceItems(listhonda, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    itemselected1.setText(listhonda[i]);
                    dialog.dismiss();


                }
            });
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();
        }
        else if((itemselected.getText().toString()).equalsIgnoreCase("Hyundai"))
        {
            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Book_now.this);
            mBuilder.setTitle("Select model");
            mBuilder.setSingleChoiceItems(listhyundai, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    itemselected1.setText(listhyundai[i]);
                    dialog.dismiss();


                }
            });
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();
        }
        else if((itemselected.getText().toString()).equalsIgnoreCase("Toyota"))
        {
            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Book_now.this);
            mBuilder.setTitle("Select model");
            mBuilder.setSingleChoiceItems(listtoyota, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    itemselected1.setText(listtoyota[i]);
                    dialog.dismiss();


                }
            });
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();
        }
        else if((itemselected.getText().toString()).equalsIgnoreCase("Ford"))
        {
            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Book_now.this);
            mBuilder.setTitle("Select model");
            mBuilder.setSingleChoiceItems(listford, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    itemselected1.setText(listford[i]);
                    dialog.dismiss();


                }
            });
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();
        }
        else if((itemselected.getText().toString()).equalsIgnoreCase("Volkswagen"))
        {
            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Book_now.this);
            mBuilder.setTitle("Select model");
            mBuilder.setSingleChoiceItems(listvolkswagen, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    itemselected1.setText(listvolkswagen[i]);
                    dialog.dismiss();


                }
            });
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();
        }
        else
        {
            Toast.makeText(this,"Nothing selected",Toast.LENGTH_LONG).show();
        }
    }
}
