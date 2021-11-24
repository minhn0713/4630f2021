package com.example.news_app;

import java.util.ArrayList;

//This class will be created for holding the status, totalResult, articles(will have it own class since it contains several items)
public class NewsModal {

    private int totalResults;
    private String status;
    private ArrayList<Articles> articles; //store articles in arraylist

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    public NewsModal(int totalResults, String status, ArrayList<Articles> articles) {
        this.totalResults = totalResults;
        this.status = status;
        this.articles = articles;
    }



}
