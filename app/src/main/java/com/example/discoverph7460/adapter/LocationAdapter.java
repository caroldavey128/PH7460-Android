package com.example.discoverph7460.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.discoverph7460.DetailedView;
import com.example.discoverph7460.R;
import com.example.discoverph7460.model.LocationData;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> implements Filterable {

    Context context;
    List<LocationData> locationDataList;
    List<LocationData> locationDataListFull;
    // create constructor for context and cityDataList



    public LocationAdapter(Context context, List<LocationData> locationDataList) {
        this.context = context;
        this.locationDataList = locationDataList;
        this.locationDataListFull = new ArrayList<>(locationDataList);
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_view_layout, parent, false);
        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.LocationViewHolder holder, int position) {

        holder.locationImage.setImageResource(locationDataList.get(position).getLocationimageurl());
        holder.locationName.setText(locationDataList.get(position).getLocationName());
        holder.locationTitle.setText(locationDataList .get(position).getLocationTitle());




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationView = new Intent(context, DetailedView.class);
                locationView.putExtra("name",locationDataList.get(position).getLocationName());
                locationView.putExtra("image",locationDataList.get(position).getLocationimageurl());
                locationView.putExtra("description",locationDataList.get(position).getLocationDescription());
                locationView.putExtra("title",locationDataList.get(position).getLocationTitle());
                locationView.putExtra("latitude", locationDataList.get(position).getLocationLatitude());
                locationView.putExtra("longitude", locationDataList.get(position).getLocationLongitude());
               // locationView.putExtra("latitude", locationDataListFull.get(position).getLocationLatitude());
                //locationView.putExtra("longitude", locationDataListFull.get(position).getLocationLongitude());
                context.startActivity(locationView);

            }
        }
        );
    }



    @Override
    public int getItemCount() {
        return locationDataList.size();
    }

    @Override
    public Filter getFilter() {
        return filteredList;
    }

    private final Filter filteredList = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<LocationData> locationDataList = new ArrayList<>();
            if (charSequence.toString().isEmpty()) {
                locationDataList.addAll(locationDataListFull);
            }
            else {
                List<LocationData> lastFilter = new ArrayList<>();
                for (LocationData location : locationDataListFull) {
                    if (location.getLocationName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        lastFilter.add(location);
                    }
                }
                locationDataList = lastFilter;
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = locationDataList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            locationDataList = (List<LocationData>)filterResults.values;
            notifyDataSetChanged();
        }
    };


    public static final class LocationViewHolder extends RecyclerView.ViewHolder{

        ImageView locationImage;
        TextView locationName, locationTitle;



        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);

            locationImage = itemView.findViewById(R.id.location_Image);
            locationName = itemView.findViewById(R.id.location_Name);
            locationTitle = itemView.findViewById(R.id.location_Title);

        }
    }

}
