package com.example.darpan.mechanico;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class denting extends AppCompatActivity {


    String id1;
    Button mOrder;
    Button book;
    TextView mItemSelected;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denting);
        getSupportActionBar().hide();
        id1=REGISTRATION.id;
        mOrder = (Button) findViewById(R.id.btnorder);
        mItemSelected = (TextView) findViewById(R.id.tvItemSelected);

        listItems = getResources().getStringArray(R.array.service);
        checkedItems = new boolean[listItems.length];

        book=(Button)findViewById(R.id.btnapp);
        REGISTRATION.rtos=new Realtime_database_users();

        REGISTRATION.database=FirebaseDatabase.getInstance();
        REGISTRATION.ref=REGISTRATION.database.getReference("Realtime_database_users");
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((mItemSelected.getText().toString().equals("")))
                {
                    Toast.makeText(denting.this, "Please enter the service", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Realtime_database_users rtos=new Realtime_database_users(mItemSelected.getText().toString());
                    REGISTRATION.ref.child(id1).child("Denting service").setValue(mItemSelected.getText().toString());
                    Intent i=new Intent(denting.this,Book_now.class);
                    startActivity(i);
                }


            }
        });
        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(denting.this);
                mBuilder.setTitle("Select the issue(s)");
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            if (!mUserItems.contains(position)) {
                                mUserItems.add(position);
                            } else {
                                mUserItems.remove(position);
                            }
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String item = "";
                        for (i = 0; i < mUserItems.size(); i++) {
                            item = item + listItems[mUserItems.get(i)];
                            if (i != mUserItems.size() - 1) {
                                item = item + ",";
                            }
                        }
                        mItemSelected.setText(item);
                    }
                });
                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            mUserItems.clear();
                            mItemSelected.setText("");
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
    }
    public void getValues()
    {
        REGISTRATION.rtos.setDenting_services(mItemSelected.getText().toString());
    }
}
