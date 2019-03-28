package com.example.darpan.mechanico;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class MapsActivity extends AppCompatActivity implements
        ReverseGeo.OnTaskComplete,GoogleApiClient.ConnectionCallbacks,OnMapReadyCallback {


    private GoogleMap mMap;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;
    private Button button;
    private TextView textview;
    private boolean addressRequest;

//Create a member variable of the FusedLocationProviderClient type//

    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getSupportActionBar().hide();

        button = findViewById(R.id.button);
        textview = findViewById(R.id.textview);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.map, mapFragment).commit();
        mapFragment.getMapAsync(this);

//Initialize mFusedLocationClient//

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(
                this);

//Create the onClickListener//

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Call getAddress, in response to onClick events//

                if (!addressRequest) {
                    getAddress();

                }
            }
        });


//Create a LocationCallback object//

        mLocationCallback = new LocationCallback() {

            @Override

//Override the onLocationResult() method,
//which is where this app receives its location updates//

            public void onLocationResult(LocationResult locationResult) {
                if (addressRequest) {

//Execute ReverseGeo in response to addressRequest//

                    new ReverseGeo(MapsActivity.this, MapsActivity.this)

//Obtain the device's last known location from the FusedLocationProviderClient//

                            .execute(locationResult.getLastLocation());
                }
            }
        };
    }

//Implement getAddress//

    private void getAddress() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);
        } else {
            addressRequest = true;

//Request location updates//

            mFusedLocationClient.requestLocationUpdates
                    (getLocationRequest(),
                            mLocationCallback,
                            null);

//If the geocoder retrieves an address, then display this address in the TextView//

            textview.setText(getString(R.string.address_text));

        }
    }

//Specify the requirements for your application's location requests//

    private LocationRequest getLocationRequest() {
        LocationRequest locationRequest = new LocationRequest();

//Specify how often the app should receive location updates, in milliseconds//

        locationRequest.setInterval(10000);
        return locationRequest;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

//If the permission request has been granted, then call getAddress//

                    getAddress();
                } else {
                    Toast.makeText(this,
                            R.string.location_permission_denied,
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onTaskComplete(String result) {
        if (addressRequest) {

//Update the TextView with the reverse geocoded address//

            textview.setText(getString(R.string.address_text,
                    result));
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
    }

    public void onConnected(Bundle bundle) {
//To do//
    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}

