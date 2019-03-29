package com.example.darpan.mechanico;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class partnerorders extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<bookrealtime> list;
    TextView tv1,tv2,tv3;
    RecyclerViewAdapter adapter;
    Button accept;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partnerorders);
        recyclerView=(RecyclerView)findViewById(R.id.rv);
        accept=findViewById(R.id.accept);
        list=new ArrayList<bookrealtime>();
    reference=FirebaseDatabase.getInstance().getReference().child("bookrealtime");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                   bookrealtime brt=dataSnapshot1.getValue(bookrealtime.class);
                    list.add(brt);
                    //Realtime_database_users r1=dataSnapshot1.getValue(Realtime_database_users.class);
                    //list.add(r1);
                }

                adapter=new RecyclerViewAdapter(partnerorders.this,list);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(partnerorders.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    accept.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });




    }


}
