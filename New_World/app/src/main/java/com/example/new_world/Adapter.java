package com.example.new_world;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    final private ArrayList<WallStreetHeadlines> wallStreetHeadlinesArrayList;
    final private Context context;

    public Adapter(ArrayList<WallStreetHeadlines> wallStreetHeadlinesArrayList, Context context) {
        this.wallStreetHeadlinesArrayList = wallStreetHeadlinesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_category_items,parent,false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        WallStreetHeadlines wallStreetHeadlines = wallStreetHeadlinesArrayList.get(position);
        holder.categoryItemsTV.setText(wallStreetHeadlines.getTitle());
        holder.categoryDetailsTV.setText(wallStreetHeadlines.getDescription());
        Picasso.with(context).load(wallStreetHeadlines.getUrlToImage()).into(holder.categoryItemsIV);
    }

    @Override
    public int getItemCount() {
        return wallStreetHeadlinesArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final private TextView categoryItemsTV, categoryDetailsTV;
        final private ImageView categoryItemsIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryItemsTV = itemView.findViewById(R.id.categoryItemsTV);
            categoryDetailsTV = itemView.findViewById(R.id.categoryDetailsTV);
            categoryItemsIV = itemView.findViewById(R.id.categoryItemsIV);
        }
    }
}
