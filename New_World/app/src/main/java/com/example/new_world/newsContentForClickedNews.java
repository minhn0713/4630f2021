package com.example.new_world;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//-- This class for rendering the data passing from the HotNewsAdapter Class,
public class newsContentForClickedNews extends AppCompatActivity {

    //variables to store data which has been passed to display in newsContentForClickedNews screen
    String title, description, content, url,imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content_for_clicked_news);

        //getting the data
        title = getIntent().getStringExtra("newsTitle");
        description = getIntent().getStringExtra("newsDescription");
        content = getIntent().getStringExtra("newsContent");
        url = getIntent().getStringExtra("newsURL");
        imageUrl = getIntent().getStringExtra("newsImage");
    }
}