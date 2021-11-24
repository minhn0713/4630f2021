package com.example.news_app;

//This class is used to send the data to the recycle view (The news part)
//we needs to extend the RecycleView.Adapter

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

//Step1: extends the recycleview.Adapter
//Step2: click (alt + enter )on the ViewHodler and create inner class
public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {

    //Step5: create ArrayList for the article
    private ArrayList<Articles> articlesArrayList;
    private Context context;

    //Step6: create constructor for this variable
    public NewsRVAdapter(ArrayList<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Step7: put the news_rv_item: which is cardView into used
        //all syntax
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item,parent,false);
        return new NewsRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRVAdapter.ViewHolder holder, int position) {
    //Step10: we distribute the data to the viewholder below
        Articles articles = articlesArrayList.get(position); //get article from data that released
        holder.subTitleTV.setText(articles.getDescription());
        holder.titleTV.setText(articles.getTitle());
        Picasso.get().load(articles.getUrlToImage()).into(holder.newsIV); //"into(holder.newsIV) = To load it into imageView"

        //Step11: create new empty activity named as NewsDetailActivity for the clickListener
        //Step12: create setOnClickListener(), when the user click on the readmore, it will show new activity
        //          in other word, we passing the data from current screen to the next screen
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,NewsDetailActivity.class);
                i.putExtra("title",articles.getTitle());
                i.putExtra("content",articles.getContent());
                i.putExtra("des",articles.getDescription());
                i.putExtra("image",articles.getUrlToImage());
                i.putExtra("url",articles.getUrl());
                context.startActivity(i); //start the activity
                //step13: go to NewsDetailsActivity
            }
        });

    }

    @Override
    public int getItemCount() {
        //Step8: we count the size of the articles
        return articlesArrayList.size();
    }

    //Step3: inner class for ViewHolder extend Recycleview.ViewHolder

    public class ViewHolder extends RecyclerView.ViewHolder{

        //Step8: Those variables are to hold the textView and ImageView to display for news_rv_item.xml
        private TextView titleTV,subTitleTV;
        private ImageView newsIV;

        //Step4: create the constructor for this inner class
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Step9: initialize it with the id for each view
            titleTV = itemView.findViewById(R.id.idTVNewsHeadings);
            subTitleTV = itemView.findViewById(R.id.idTVSubTitle);
            newsIV = itemView.findViewById(R.id.idIVNews);
        }
    }
}


