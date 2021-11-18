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

public class AllnewsAdapter extends RecyclerView.Adapter<AllnewsAdapter.ViewHolder> {

    private ArrayList<Articles> articlesArrayList;
    private Context context;

    public AllnewsAdapter(ArrayList<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AllnewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_all_news_rv_item,parent,false);
        return new AllnewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllnewsAdapter.ViewHolder holder, int position) {
        Articles articles = articlesArrayList.get(position);
        holder.titleTV.setText(articles.getTitle());
        holder.subTitleTV.setText(articles.getDescription());
        Picasso.get().load(articles.getUrlToImage()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passing data to next screen "newsContentForClickedNews"
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV,subTitleTV;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.allNews_headlineTV);
            subTitleTV = itemView.findViewById(R.id.allNews_SubHeadingTV);
            imageView = itemView.findViewById(R.id.allNewsImageView);
        }
    }
}
