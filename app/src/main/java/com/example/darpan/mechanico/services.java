package com.example.darpan.mechanico;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class services extends AppCompatActivity {
    Button mOrder;
    Button book;
    TextView mItemSelected;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    String id3;
    FirebaseAuth firebaseAuth;
    public static FirebaseDatabase database;
    public static DatabaseReference databaseReference;
    FirebaseAuth.AuthStateListener firebaseAuthListener;
    FirebaseUser firebaseUser;
    public static  services_realtime sr4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        getSupportActionBar().hide();
        firebaseAuth=FirebaseAuth.getInstance();
        services_realtime sr4=new services_realtime();
        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("services_realtime");
        mOrder = (Button) findViewById(R.id.btnorder);
        mItemSelected = (TextView) findViewById(R.id.tvItemSelected);

        listItems = getResources().getStringArray(R.array.car_services);
        checkedItems = new boolean[listItems.length];

        book=(Button)findViewById(R.id.btnapp);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((mItemSelected.getText().toString().equals("")))
                {
                    Toast.makeText(services.this, "Please enter the service", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
                    String id3=firebaseUser.getUid();
                  services_realtime sr4=new services_realtime(mItemSelected.getText().toString()," ","","");
                   databaseReference.child(id3).child("Service").setValue(mItemSelected.getText().toString());

                    Intent i=new Intent(services.this,Cart.class);
                    startActivity(i);
                }

            }
        });
        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(services.this);
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
}
