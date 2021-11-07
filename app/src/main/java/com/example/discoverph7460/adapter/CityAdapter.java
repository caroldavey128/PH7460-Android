package com.example.discoverph7460.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.discoverph7460.DetailedView;
import com.example.discoverph7460.R;
import com.example.discoverph7460.model.CityData;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    Context context;
    List<CityData> cityDataList;

    // create constructor for context and cityDataList
    public CityAdapter(Context context, List<CityData> cityDatalist) {
        this.context = context;
        this.cityDataList = cityDatalist;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recents_row_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.CityViewHolder holder, int position) {

        holder.placeImage.setImageResource(cityDataList.get(position).getImageurl());
        holder.placeName.setText(cityDataList.get(position).getPlaceName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cityView = new Intent(context, DetailedView.class);
                cityView.putExtra("name",cityDataList.get(position).getPlaceName());
                cityView.putExtra("image",cityDataList.get(position).getImageurl());
                cityView.putExtra("description",cityDataList.get(position).getPlaceDescription());
                cityView.putExtra("title",cityDataList.get(position).getPlaceTitle());
                cityView.putExtra("latitude", cityDataList.get(position).getPlaceLatitude());
                cityView.putExtra("longitude", cityDataList.get(position).getPlaceLongitude());
                context.startActivity(cityView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityDataList.size();
    }

    public static final class CityViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_Image);
            placeName = itemView.findViewById(R.id.place_Name);
        }
    }
}
