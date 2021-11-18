package com.example.new_world;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ArrayList<WallStreetHeadlines> wallStreetHeadlinesArrayList;
    private Context context;

    public NewsAdapter(ArrayList<WallStreetHeadlines> wallStreetHeadlinesArrayList, Context context) {
        this.wallStreetHeadlinesArrayList = wallStreetHeadlinesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_category_items,parent,false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        WallStreetHeadlines wallStreetHeadlines = wallStreetHeadlinesArrayList.get(position);
        holder.categoryItemsTitleTV.setText(wallStreetHeadlines.getTitle());
        holder.categoryItemsDetailsTV.setText(wallStreetHeadlines.getDescription());
        Picasso.get().load(wallStreetHeadlines.getUrlToImage()).into(holder.categoryItemsIV);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,NewsDetailActivity.class);
                i.putExtra("title",wallStreetHeadlines.getTitle());
                i.putExtra("content",wallStreetHeadlines.getContent());
                i.putExtra("des",wallStreetHeadlines.getDescription());
                i.putExtra("image",wallStreetHeadlines.getUrlToImage());
                i.putExtra("url",wallStreetHeadlines.getUrl());
                context.startActivity(i); //start the activity
                //step13: go to NewsDetailsActivity
            }
        });
    }

    @Override
    public int getItemCount() {
        return wallStreetHeadlinesArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final private TextView categoryItemsTitleTV, categoryItemsDetailsTV;
        final private ImageView categoryItemsIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryItemsTitleTV = itemView.findViewById(R.id.categoryItemsTitleTV);
            categoryItemsDetailsTV = itemView.findViewById(R.id.categoryItemsDetailsTV);
            categoryItemsIV = itemView.findViewById(R.id.categoryItemsIV);
        }
    }
}
