package com.example.step.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.step.R;
import com.example.step.data.AllPlaceData;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ListViewHolder> {

    private ArrayList<AllPlaceData> data = new ArrayList<>();

    public void setData(ArrayList<AllPlaceData> items) {
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_place, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int position) {
        listViewHolder.title.setText(data.get(position).getTitle());
        listViewHolder.location.setText(data.get(position).getLocation());
        if (data.get(position).getPrice().equals("0")) {
            listViewHolder.price.setText(R.string.free);
        } else {
            listViewHolder.price.setText(data.get(position).getPrice());
        }
        if (data.get(position).getRating() > 0.0 && data.get(position).getRating() <= 1.0) {
            listViewHolder.ratings.setRating(0.5f);
        } else if (data.get(position).getRating() > 1.0 && data.get(position).getRating() <= 2.0) {
            listViewHolder.ratings.setRating(1.0f);
        } else if (data.get(position).getRating() > 2.0 && data.get(position).getRating() <= 3.0) {
            listViewHolder.ratings.setRating(1.5f);
        } else if (data.get(position).getRating() > 3.0 && data.get(position).getRating() <= 4.0) {
            listViewHolder.ratings.setRating(2.0f);
        } else if (data.get(position).getRating() > 4.0 && data.get(position).getRating() <= 5.0) {
            listViewHolder.ratings.setRating(2.5f);
        } else if (data.get(position).getRating() > 5.0 && data.get(position).getRating() <= 6.0) {
            listViewHolder.ratings.setRating(3.0f);
        } else if (data.get(position).getRating() > 6.0 && data.get(position).getRating() <= 7.0) {
            listViewHolder.ratings.setRating(3.5f);
        } else if (data.get(position).getRating() > 7.0 && data.get(position).getRating() <= 8.0) {
            listViewHolder.ratings.setRating(4.0f);
        } else if (data.get(position).getRating() > 8.0 && data.get(position).getRating() <= 9.0) {
            listViewHolder.ratings.setRating(4.5f);
        } else if (data.get(position).getRating() > 9.0 && data.get(position).getRating() <= 10.0) {
            listViewHolder.ratings.setRating(5.0f);
        } else {
            listViewHolder.ratings.setRating(0.0f);
        }

        Glide.with(listViewHolder.itemView.getContext())
                .load(R.drawable.carousel_1)
                .into(listViewHolder.imgPhoto);

        listViewHolder.imgPhoto.setContentDescription(data.get(position).getTitle());
    }

    public void filterList(ArrayList<AllPlaceData> filteredList) {
        data = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView title, location, price;
        ImageView imgPhoto;
        RatingBar ratings;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            location = itemView.findViewById(R.id.tv_location);
            price = itemView.findViewById(R.id.tv_price);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            ratings = itemView.findViewById(R.id.ratingBar);
            Drawable drawable = ratings.getProgressDrawable();
            drawable.setColorFilter(Color.parseColor("#D09841"), PorterDuff.Mode.SRC_ATOP);
        }
    }
}
