package com.example.discoverph7460;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FinalMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    //private ActivityMapViewBinding binding;
    TextView standard, satellite;

    MarkerOptions locationMarker;
    FragmentContainerView locMap;
    LatLng locationMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_map);

        standard = findViewById(R.id.txt_Standard);
        satellite = findViewById(R.id.txt_Satellite);

        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(mMap.MAP_TYPE_NORMAL);
                standard.setBackgroundResource(R.drawable.standard);
                satellite.setVisibility(View.VISIBLE);
                standard.setVisibility(View.GONE);
            }
        });

        satellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(mMap.MAP_TYPE_HYBRID);
                satellite.setBackgroundResource(R.drawable.satellite);
                standard.setVisibility(View.VISIBLE);
                satellite.setVisibility(View.GONE);
            }
        });
       // binding = ActivityMapViewBinding.inflate(getLayoutInflater());
       // setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.final_map);
        mapFragment.getMapAsync(this);



    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Intent intent = getIntent();
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //LatLng latLng = new LatLng(finalLatitude, finalLongitude);
        double newLatitude = intent.getDoubleExtra("latitude", -120);
        double newLongitude = intent.getDoubleExtra("longitude", -130);
        String locationName = intent.getStringExtra("name");
        locMap = findViewById(R.id.final_map);



        locationMap = new LatLng(newLatitude, newLongitude);

        locationMarker = new MarkerOptions().title(locationName).position(locationMap).snippet("I'm here");
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(locationMap).title(locationName));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationMap));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(locationMap, 8), 1000, null);


    }
}