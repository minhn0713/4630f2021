
package com.example.new_world;

import java.util.ArrayList;

//-------- Create Model class for the whole articles ---------

public class Model {

    //IMPORTANT porperties that store all articles in newAPI
    private int totalResults;
    private String status;
    private ArrayList<Articles> articles;


    //-------- Getter and Setter ---------------------
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

    //------- Constructor ------------------------

    public Model(int totalResults, String status, ArrayList<Articles> articles) {
        this.totalResults = totalResults;
        this.status = status;
        this.articles = articles;
    }
}