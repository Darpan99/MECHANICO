package com.example.darpan.mechanico;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class PAGE3  extends AppCompatActivity {
    ImageButton dent,services,cng,cab,tyre,emergency;
    FirebaseAuth firebaseAuth;
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        drawerLayout=findViewById(R.id.DL);
        NavigationView navigationView=findViewById(R.id.design_navigation_view);
       // setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View view, float v) {
                //Respond when the drawer's position changes
            }

            @Override
            public void onDrawerOpened( View view) {
                //Respond when the drawer is opened
            }

            @Override
            public void onDrawerClosed( View view) {
                //Respond when the drawer is closed
            }

            @Override
            public void onDrawerStateChanged(int i) {
                //Respond when the drawer motion state changes
            }
        });



        dent=(ImageButton)findViewById(R.id.imageButton);
        dent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(PAGE3.this,denting.class);
                startActivity(intent);
            }

        });

        services=(ImageButton)findViewById(R.id.servicing);
        services.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(PAGE3.this, services.class);
                                            startActivity(intent);
                                        }
                                    }
        );

        cng=(ImageButton)findViewById(R.id.cng);
        cng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(PAGE3.this,CNG_fitting.class);
                startActivity(intent);
            }

        });

        cab=(ImageButton)findViewById(R.id.book_cab);
        cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(PAGE3.this,book_cab.class);
                startActivity(intent);
            }

        });
        tyre=(ImageButton)findViewById(R.id.tyre_service);
        tyre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(PAGE3.this,Tyre_service.class);
                startActivity(intent);
            }

        });
        emergency=(ImageButton)findViewById(R.id.imageButton7);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(PAGE3.this,Emergency.class);
                startActivity(intent);
            }

        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem menuItem) {
                // handle navigation view item clicks here
                int id =menuItem.getItemId();
                if(id==R.id.item_1)
                {
                    //my profile
                    Intent i=new Intent( PAGE3.this,My_profile.class);
                    startActivity(i);

                }
                else if(id==R.id.item_2) {
                    //my orders
                    Intent i=new Intent(PAGE3.this,My_orders.class);
                    startActivity(i);
                }

                else if(id==R.id.item_3)
                {
                    //account settings
                    Intent i=new Intent(PAGE3.this,Account_Settings.class);
                    startActivity(i);

                }
                else if (id==R.id.item_5)
                {
                    //help
                    Intent i=new Intent(PAGE3.this,Help.class);
                    startActivity(i);

                }
                else
                {
                    //logout
                    FirebaseAuth.getInstance().signOut();
                    Intent i=new Intent(PAGE3.this,REGISTRATION.class);
                    startActivity(i);
                }
               menuItem.setChecked(true);
               drawerLayout.closeDrawers();
                return true;
            }

        });



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId()) {
           case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
       }
           return  super.onOptionsItemSelected(item);

    }
    public void BtnSetEmergency_onClick(View view) {
        String number = "100";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    public void BtnSetEmergencyamb_onClick(View view) {
        String number = "102";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }
}

