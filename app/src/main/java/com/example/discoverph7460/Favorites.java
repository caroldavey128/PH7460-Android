package com.example.discoverph7460;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.discoverph7460.adapter.LocationAdapter;
import com.example.discoverph7460.model.LocationData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Favorites extends AppCompatActivity {
    BottomNavigationView homeNavigation;
    RecyclerView favoriteRecycler;
    LocationAdapter favoriteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        //Assign variables
        homeNavigation = findViewById(R.id.homeTab);
        //Set Home View
        homeNavigation.setSelectedItemId(R.id.favoritesView);

        homeNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.homeScreen:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.discoverView:
                        startActivity(new Intent(getApplicationContext(), Discover.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.favoritesView:
                        return true;
                }
                return false;
            }
        });


        Intent intent = getIntent();

        String favName = intent.getStringExtra("name");
        Integer favImage = intent.getIntExtra("image", 0);
        String favDesription = intent.getStringExtra("description");
        String favTitle = intent.getStringExtra("title");
        double favLat = intent.getDoubleExtra("latitude", -120);
        double favLon = intent.getDoubleExtra("longitude", -130);

        List<LocationData> favoriteDataList = new ArrayList<>();
        favoriteDataList.add((new LocationData(favName, favDesription, favTitle, favImage, favLat, favLon)));

        //for (int i = 0; i < favoriteDataList.size(); i++)

        setFavoriteRecycler(favoriteDataList);
    }


    private void  setFavoriteRecycler(List<LocationData> favoriteDataList) {

        favoriteRecycler = findViewById(R.id.list_Favorites);
        RecyclerView.LayoutManager locationManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        favoriteRecycler.setLayoutManager(locationManager);
        favoriteAdapter = new LocationAdapter(this, favoriteDataList);
        favoriteRecycler.setAdapter(favoriteAdapter);


    }
}