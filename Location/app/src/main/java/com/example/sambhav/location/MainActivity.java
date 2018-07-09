package com.example.sambhav.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locationManager=(LocationManager)getSystemService(LOCATION_SERVICE);
        //use this to get last known location
        Location lastKnownLocation = locationManager
                .getLastKnownLocation(LocationManager.GPS_PROVIDER);

        locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER,this,null);


        //use this to access location continuously
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                5000,
                0,
                this
        );
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
