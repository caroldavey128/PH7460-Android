package com.example.discoverph7460;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.discoverph7460.adapter.LocationAdapter;
import com.example.discoverph7460.model.LocationData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Discover extends AppCompatActivity {
    BottomNavigationView homeNavigation;
    SearchView searchView;

    //Declare all recyclerview and adapters
    RecyclerView locationRecycler;
    LocationAdapter locationAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        //Assign variables

        searchView = findViewById(R.id.location_Search);

        homeNavigation = findViewById(R.id.homeTab);
        //Set Home View
        homeNavigation.setSelectedItemId(R.id.discoverView);

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
                        return true;
                    case R.id.favoritesView:
                        startActivity(new Intent(getApplicationContext(), Favorites.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }


        });


        List<LocationData> locationDataList = new ArrayList<>();
        //Provinces
        locationDataList.add(new LocationData("Cebu", "Cebu Island is long and narrow, stretching 196 kilometres from north to south, and only 32 kilometres across its widest point. It has countless coves and beaches, but it is the tiny islands just offshore that will capture your heart. Boasting sugar-white beaches, clear azure waters and astounding coral reefs just offshore, they are holiday-brochure perfect, but without the crowds. Bantayan Island is probably the most famous, with its dazzling white beaches, cool breezes and friendly locals. Camotes Island boasts beautiful beaches too, particularly around Mangodlong and Santiago Bay, but offers other activities for visitors as well. Danao Lake is worth a visit, as is Bukilat Cave, or trek to the Altavista view point for a breathtaking panorama of the whole island. Finally, Nalusuan Island is perfect for divers, surrounded by a protected marine garden, with colourful fish and neon coral. Make sure you try the fresh seafood served in beach shack restaurants here too. But be warned: you may never want to leave.","Province", R.drawable.cebuimage, 10.3157, 123.8854));
        locationDataList.add(new LocationData("Pampanga", "Explore Pampanga,  the Culinary Capital of the Philippines, on your next getaway. Here’s a guide on what to eat, places to see, and things to do there. Pampanga is one of the most famous provinces in the Central Luzon region because it holds the title of being the Culinary Capital of the Philippines. Pampanga is definitely a foodie’s heaven with dishes ranging from the iconic sizzling pork dish called sisig to the family favorites like pangat na ulang (sour soup with fresh water prawns). Pampanga’s modern city of Clark is famous for its well-preserved ancestral homes, a lineup of themed and amusement parks, and bright and colorful year-round festivals.","Province", R.drawable.pampangaimage, 15.0794, 120.6200));
        locationDataList.add(new LocationData("Pangasinan", "Pangasinan is a destination for tourists who wish to explore islands and beaches, waterfalls, and feast on tasty local cuisine—all just 3-4 hours of drive from Manila. Pangasinan translates to “place of salt” as it is a major producer of salt. In fact, two of their main products are bagoong (shrimp paste) and alamang (krill) that give additional flavor to dishes. Add Pangasinan to your bucket list if you're looking for a quick escape from the city.","Province", R.drawable.pangasinanimage, 15.8949, 120.2863));
        locationDataList.add(new LocationData("Zambales", "Want a quick beach and island escape from the bustling cities of Metro Manila? Hop on a bus or drive your way to Zambales! Zambales is blessed with pristine attractions for sun worshipers because of its location on the western shores of Luzon, along the West Philippine Sea. It’s home to many coves and islands like Anawangin Cove, Nagsasa Cove, Potipot Island, and Capones Island to name a few. Zambales is also where you can find another top destination in the North, Subic. The active stratovolcano Mount Pinatubo’s summit and crater lake also lies in the Botolan area of Zambales. Pack your camping essentials and spend a night or two at the Anawangin Cove or Nagsasa Cove. Coves like these in Zambales are unique because they have agoho trees (see pine trees) that grew after the Mt. PInatubo erupted in 1991. During your camping trips to these coves, you can also go island-hopping to nearby islands like Potipot Island and Capones Island. Another must-do when in Zambales is to explore Mt. Pinatubo by hiking or riding 4x4 wheel drive vehicles. Zambales is also a surfing destination, you can ride the waves at Crystal Beach Resort. You can also explore Subic, a former US Naval Base. Try fun outdoor activities at Tree Top Adventure, play with the animals at Zoobic Safari or Ocean Adventure, or play at an inflatable floating playground that features a giant unicorn. Zambales is known to being a weekend getaway destination for city-dwellers so there are numerous accommodation types situated around the area from hotels, resorts, to private houses for rent for every budget.","Province", R.drawable.zambalesimage, 15.5082, 119.9698));
        //Cities
        locationDataList.add(new LocationData("Baguio", "Baguio is a mountain resort city located in Benguet of Northern Luzon, Philippines. Considered to be the country's Summer Capital, Baguio is undoubtedly one of the top tourist destinations in the Philippines. Also nicknamed The City of Pines, it is a popular weekend getaway for local travelers based in the metro.","City", R.drawable.baguioimage, 16.4023, 120.5960));
        locationDataList.add(new LocationData("Olongapo", "A major city in the province of Zambales in the Philippines, Olongapo has a growing population of 230,000 as per the 2015 census. Metro Olongapo, along with the municipality of Subic, is one of the twelve metropolitan areas in the Philippines. Though it has a notorious red light district reputation brought by the presence of night clubs catering to American servicemen, the city has gradually shifted into a more wholesome image. Olongapo is known for its culturally relevant sites – Marikit Park, Olongapo Lighthouse, Kalapati (The Dove Monument) along with Olongapo’s City Hall, Convention Center, Museum, Public Library, and Public Market.","City", R.drawable.olongapoimage, 14.8386, 120.2842));
        locationDataList.add(new LocationData("Puerto Princesa", "Puerto Princesa in Palawan is most famous for the Puerto Princesa Subterranean River National Park or the Underground River, a UNESCO World Heritage site and holds a place in the New7Wonders of Nature. It is also the gateway to famous paradise-like destinations in Palawan like El Nido and San Vicente because it has its own international airport. But there's more to Puerto Princesa than being just a jump-off site and location to the famous natural wonder. Puerto Princesa, also known as The City in a Forest, is rich in various unknown but must-see tourist spots that make it worth a visit for more than just a day.","City", R.drawable.puertoprincesaimage, 9.7638, 118.7473));
        locationDataList.add(new LocationData("Taguig", "Taguig contains the Bonifacio Global City (popularly known simply as BGC), Metro Manila's second most important business district and a major tourism, shopping, dining and entertainment destination. Other attractions include the Manila American Cemetery and the affluent neighbourhood of McKinley Hill.","City", R.drawable.taguigimage, 14.5176, 121.0509));

        setLocationRecycler(locationDataList);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                locationAdapter.getFilter().filter(s.toLowerCase().toString());
                return false;
            }

        });
    }



    private void  setLocationRecycler(List<LocationData> locationDataList) {

        locationRecycler = findViewById(R.id.list_Location);
        RecyclerView.LayoutManager locationManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        locationRecycler.setLayoutManager(locationManager);
        locationAdapter = new LocationAdapter(this, locationDataList);
        locationRecycler.setAdapter(locationAdapter);

    }


}