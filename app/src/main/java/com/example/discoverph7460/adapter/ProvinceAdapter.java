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
import com.example.discoverph7460.model.ProvinceData;

import java.util.List;

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder> {

    // Declare variables context and ProvinceData (Province)

    Context context;
    List<ProvinceData> provinceDataList;

    // Create Constructor for context and provinceDataList
    public ProvinceAdapter(Context context, List<ProvinceData> provinceDataList) {
        this.context = context;
        this.provinceDataList = provinceDataList;
    }

    // Create ViewHolder for province as RecentsViewHolder
    @NonNull
    @Override
    public ProvinceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recents_row_item, parent, false);
        return new ProvinceViewHolder(view);
    }

    // Bind provinceAdapter.provinceViewHolder to int position
    @Override
    public void onBindViewHolder(@NonNull ProvinceAdapter.ProvinceViewHolder holder, int position) {

        holder.placeImage.setImageResource(provinceDataList.get(position).getImageurl());
        holder.placeName.setText(provinceDataList.get(position).getPlaceName());

        // Onclick will display DetailedView of Province
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent provinceView = new Intent(context, DetailedView.class);
               provinceView.putExtra("name", provinceDataList.get(position).getPlaceName());
               provinceView.putExtra("image", provinceDataList.get(position).getImageurl());
               provinceView.putExtra("description", provinceDataList.get(position).getPlaceDescription());
               provinceView.putExtra("title", provinceDataList.get(position).getPlaceTitle());
                provinceView.putExtra("latitude", provinceDataList.get(position).getPlaceLatitude());
                provinceView.putExtra("longitude", provinceDataList.get(position).getPlaceLongitude());
                context.startActivity(provinceView);
            }
        });
    }

    // get the item count from provinceDataList
    @Override
    public int getItemCount() {
        return provinceDataList.size();
    }

    // put the data into provinceViewHolder
    public static final class ProvinceViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName;

        // put all the data into itemview
        public ProvinceViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_Image);
            placeName = itemView.findViewById(R.id.place_Name);
        }
    }
}
