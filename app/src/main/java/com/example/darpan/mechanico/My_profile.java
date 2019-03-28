package com.example.darpan.mechanico;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class My_profile extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<Realtime_database_users> list;
    myprofile_adapter adapter;

    String id123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        recyclerView=(RecyclerView)findViewById(R.id.rv2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<Realtime_database_users>();

        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        id123=FirebaseAuth.getInstance().getUid();
        //databaseReference=FirebaseDatabase.getInstance().getReference().child("services_realtime").child(String.valueOf(firebaseUser.getUid()));
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Realtime_database_users");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    if((dataSnapshot1.getKey().equals(id123))) {
                        Realtime_database_users r9 = dataSnapshot1.getValue(Realtime_database_users.class);
                        list.add(r9);
                    }
                }
                adapter= new myprofile_adapter(My_profile.this, list);
                recyclerView.setAdapter(adapter);
                RecyclerView.LayoutManager recycle = new LinearLayoutManager(My_profile.this);
                recyclerView.setLayoutManager(recycle);






            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
