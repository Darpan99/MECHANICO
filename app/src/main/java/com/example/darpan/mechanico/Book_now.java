package com.example.darpan.mechanico;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;


public class Book_now extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Button car, model, type, book,address;
    public TextView itemselected, itemselected1, itemselected2;
    public String[] listItems, listhonda, listhyundai, listtype, listtoyota, listford, listvolkswagen;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    Button datepicker, timepicker;
    public TextView selecteddate, timeselect;
    public TextView add;
    FirebaseAuth firebaseAuth;
    public static FirebaseDatabase database;
  private DatabaseReference reference;
  public  Realtime_database_users rtds;
  String user_name,user_number,user_email;
 FirebaseUser firebaseUser;
public bookrealtime b;
    Random r;
    public Book_now()
    {

    }
    public Book_now(Realtime_database_users r)

    {
        this.user_number=r.getUser_number();
        this.user_email=r.getUser_email();
        this.user_name=r.getUser_name();

        ;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);

        Spinner spinner1;
        getSupportActionBar().hide();


        spinner1 = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myadapter = new ArrayAdapter<>(Book_now.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Car));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myadapter);

        firebaseAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("bookrealtime");
        rtds=new Realtime_database_users();
        car = (Button) findViewById(R.id.carbtn);
        bookrealtime brt1=new bookrealtime();
        model = (Button) findViewById(R.id.modelbtn);
        type = (Button) findViewById(R.id.typebtn);
        itemselected = (EditText) findViewById(R.id.cartext);
        itemselected1 = (EditText) findViewById(R.id.modeltext);
        itemselected2 = (EditText) findViewById(R.id.typetext);
        listItems = getResources().getStringArray(R.array.cars);
        listhonda = getResources().getStringArray(R.array.Honda);
        listhyundai = getResources().getStringArray(R.array.Hyundai);
        listtoyota = getResources().getStringArray(R.array.Toyota);
        listford = getResources().getStringArray(R.array.Ford);
        listtype = getResources().getStringArray(R.array.fuel);
        listvolkswagen = getResources().getStringArray(R.array.Volkswagen);
        checkedItems = new boolean[listItems.length];
        datepicker = (Button) findViewById(R.id.date);
        timepicker = (Button) findViewById(R.id.time);
        selecteddate = (EditText) findViewById(R.id.dateset);
        timeselect = (EditText) findViewById(R.id.timeselected);
        book = (Button) findViewById(R.id.bookit);
        add = (TextView) findViewById(R.id.addtext);
        address= (Button)findViewById(R.id.getadd);
        final Random myRandom= new Random();
        final TextView textGenerateNumber= (TextView)findViewById(R.id.text_View);



        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((itemselected.getText().toString().equals("")) || (itemselected1.getText().toString().equals("")) || (itemselected2.getText().toString().equals("")) || (selecteddate.getText().toString().equals("")) || (timeselect.getText().toString().equals("")) || (add.getText().toString().equals(""))) {
                    Toast.makeText(Book_now.this,"Fields are Empty",Toast.LENGTH_LONG).show();
                }
                else {
                    firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
                    textGenerateNumber.setText(String.valueOf(myRandom.nextInt(100)));
                    bookrealtime brt =new bookrealtime(itemselected.getText().toString(),itemselected1.getText().toString(),itemselected2.getText().toString(),selecteddate.getText().toString(),timeselect.getText().toString(),add.getText().toString(),textGenerateNumber.getText().toString());

bookrealtime b=new bookrealtime();

b.setUser_name(user_name);
b.setUser_number(user_number);
b.setUser_email(user_email);
                    reference.child(firebaseUser.getUid()).child("car").setValue(itemselected.getText().toString());
                    reference.child(firebaseUser.getUid()).child("car_model").setValue(itemselected1.getText().toString());
                    reference.child(firebaseUser.getUid()).child("fuel_type").setValue(itemselected2.getText().toString());
                   reference.child(firebaseUser.getUid()).child("date").setValue(selecteddate.getText().toString());
                   reference.child(firebaseUser.getUid()).child("time").setValue(timeselect.getText().toString());
                    reference.child(firebaseUser.getUid()).child("address").setValue(add.getText().toString());
                    reference.child(firebaseUser.getUid()).child("otp").setValue(textGenerateNumber.getText().toString());
                   reference.child(firebaseUser.getUid()).child("user_name").setValue(b.getUser_name());
                    reference.child(firebaseUser.getUid()).child("user_number").setValue(b.getUser_number());
                    reference.child(firebaseUser.getUid()).child("user_email").setValue(b.getUser_email());
                   /*reference.child(firebaseUser.getUid()).child("user_number").setValue(user_number);
                    reference.child(firebaseUser.getUid()).child("user_email").setValue(user_email);*/







                    Toast.makeText(Book_now.this,b.getUser_name(),Toast.LENGTH_LONG).show();


                }

            }
        });


        timepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker = new Timepickerfragment();
                timepicker.show(getSupportFragmentManager(), "Pick time");
            }
        });

        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datepick = new Datepickerfragment();
                datepick.show(getSupportFragmentManager(), "date");
            }
        });


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

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Book_now.this, MapsActivity.class));
            }
        });





    }




    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentdate = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        selecteddate.setText(currentdate);


    }

    public void modelname(View view) {
        if ((itemselected.getText().toString()).equalsIgnoreCase("Honda")) {
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
        } else if ((itemselected.getText().toString()).equalsIgnoreCase("Hyundai")) {
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
        } else if ((itemselected.getText().toString()).equalsIgnoreCase("Toyota")) {
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
        } else if ((itemselected.getText().toString()).equalsIgnoreCase("Ford")) {
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
        } else if ((itemselected.getText().toString()).equalsIgnoreCase("Volkswagen")) {
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
        } else {
            Toast.makeText(this, "Nothing selected", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timeselect.setText(hourOfDay + ":" + minute);
    }


}