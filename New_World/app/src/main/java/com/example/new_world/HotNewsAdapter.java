package com.example.new_world;

//--- Create Adapter class for pass data to display in the recycleView

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

//--- Step1: extends the RecyclerView.Adapter and implements its methods and create inner class

public class HotNewsAdapter extends RecyclerView.Adapter<HotNewsAdapter.ViewHolder> {

    //-- Step2: Create variable for article render purpose
    private ArrayList<Articles> articlesArrayList;
    private Context context;

    //-- Step3: Create Constructor
    public HotNewsAdapter(ArrayList<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    //--Implement the layout which we created, in this method we implement layout for activity_hot_news.xml
    @NonNull
    @Override
    public HotNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_hot_news_rv_item,parent,false);
        return new HotNewsAdapter.ViewHolder(view);
    }

    //--This method allows us to set data to textView and imageView
    @Override
    public void onBindViewHolder(@NonNull HotNewsAdapter.ViewHolder holder, int position) {
        Articles articles = articlesArrayList.get(position);
        holder.subTitleTextView.setText(articles.getDescription());
        holder.titleTextView.setText(articles.getTitle());
        Picasso.get().load(articles.getUrlToImage()).into(holder.newsImageView);

        //set onClickListener to display new screen as the user click on the hotNews items
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


    //Create inner class for viewholder extends ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        //--Create three variables to store the titleTextView, subTitleTextView and newsImageView
        private TextView titleTextView, subTitleTextView;
        private ImageView newsImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.hotNew_headlineTV);
            subTitleTextView = itemView.findViewById(R.id.hotNews_SubHeadingTV);
            newsImageView = itemView.findViewById(R.id.hotNewsImageView);
        }
    }
}
