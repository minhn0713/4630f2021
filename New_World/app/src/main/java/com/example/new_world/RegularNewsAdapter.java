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

public class RegularNewsAdapter extends RecyclerView.Adapter<RegularNewsAdapter.ViewHolder> {

    private ArrayList<Articles> articlesArrayList;
    private Context context;

    public RegularNewsAdapter(ArrayList<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RegularNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_regular_news_rv_item,parent,false);
        return new RegularNewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RegularNewsAdapter.ViewHolder holder, int position) {
        Articles articles = articlesArrayList.get(position);
        holder.subTitleTextView.setText(articles.getDescription());
        holder.titleTextView.setText(articles.getTitle());
        Picasso.get().load(articles.getUrlToImage()).into(holder.newsImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, newsContentForClickedNews.class);
                i.putExtra("newsTitle",articles.getTitle());
                i.putExtra("newsContent",articles.getContent());
                i.putExtra("newsDescription",articles.getDescription());
                i.putExtra("newsImage",articles.getUrlToImage());
                i.putExtra("newsURL",articles.getUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titleTextView, subTitleTextView;
        private ImageView newsImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.regular_headlineTV);
            subTitleTextView = itemView.findViewById(R.id.regular_SubHeadingTV);
            newsImageView = itemView.findViewById(R.id.regularImageView);
        }
    }
}
