package com.example.darpan.mechanico;

import android.content.Intent;
import android.support.annotation.NonNull;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<services_realtime> list;
    CartViewAdapter cartViewAdapter;
    Button book;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView=(RecyclerView)findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<services_realtime>();
        book=findViewById(R.id.btbook);
        back=findViewById(R.id.btback);
        //firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        //databaseReference=FirebaseDatabase.getInstance().getReference().child("services_realtime").child(String.valueOf(firebaseUser.getUid()));
        databaseReference=FirebaseDatabase.getInstance().getReference().child("services_realtime");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                           services_realtime sr9 = dataSnapshot1.getValue(services_realtime.class);
                           list.add(sr9);
                       }
                           cartViewAdapter = new CartViewAdapter(Cart.this, list);
                           recyclerView.setAdapter(cartViewAdapter);
                           RecyclerView.LayoutManager recycle = new LinearLayoutManager(Cart.this);
                           recyclerView.setLayoutManager(recycle);




                           /*services_realtime temp = new services_realtime();

                           String tempDent = sr9.getDenting();
                           String tempCng = sr9.getCng();
                           temp.setDenting(tempDent);
                           temp.setCng(tempCng);

                           Toast.makeText(Cart.this, tempCng, Toast.LENGTH_SHORT).show();*/



                /*services_realtime sr = new services_realtime();
                String a,b,c,d;
                sr.CNG= dataSnapshot.child("CNG").getValue().toString();
                sr.Denting=dataSnapshot.child("Denting").getValue().toString();
                sr.Service= dataSnapshot.child("Service").getValue().toString();
                sr.Tyre= dataSnapshot.child("Tyre").getValue().toString();
                list.add(sr);

*/


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Cart.this,Book_now.class);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cart.this,PAGE3.class);
                startActivity(intent);
            }
        });
    }
}
