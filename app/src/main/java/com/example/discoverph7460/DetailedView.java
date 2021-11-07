package com.example.discoverph7460;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.discoverph7460.model.LocationData;

import java.util.ArrayList;
import java.util.List;

public class DetailedView extends AppCompatActivity {
    ImageView locImage;
    TextView locName, locDesc, locTitle;
    String name, title, description;
    Integer image;
    ImageButton locationClick;
    double finalLatitude, finalLongitude;
    Context context;
    ImageButton favoriteClick;
    List<LocationData> favoriteDataList = new ArrayList<>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);



        locationClick = findViewById(R.id.map_View);

        locationClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Intent intent = getIntent();
                intent.setClass(getApplicationContext(), FinalMap.class);

                startActivity(intent);
            }
        });


        Intent locationView = getIntent();

        name = locationView.getStringExtra("name");
        image = locationView.getIntExtra("image", R.drawable.baguioimage);
        title = locationView.getStringExtra("title");
        description = locationView.getStringExtra("description");







        locName = findViewById(R.id.place_Detail_Name);
        locImage = findViewById(R.id.place_Detail_Image);
        locTitle = findViewById(R.id.place_Detail_Title);
        locDesc = findViewById(R.id.place_Detail_Desc);



        locName.setText(name);
        locImage.setImageResource(image);
        locTitle.setText(title);
        locDesc.setText(description);

        favoriteClick = (ImageButton) findViewById(R.id.favorite_View);

        favoriteClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.setClass(getApplicationContext(),Favorites.class);
                favoriteClick.setImageResource(R.drawable.ic_baseline_favorite_blue);

                startActivity(intent);
            }
        });


    }

}