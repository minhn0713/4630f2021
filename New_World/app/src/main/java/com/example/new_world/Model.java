
package com.example.new_world;

import java.util.ArrayList;

public class Model {
    private int totalResults;
    private String status;
    private ArrayList<WallStreetHeadlines> wallstreetheadlines;

    public Model(int totalResults, String status, ArrayList<WallStreetHeadlines> wallstreetheadlines) {
        this.totalResults = totalResults;
        this.status = status;
        this.wallstreetheadlines = wallstreetheadlines;
    }

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

    public ArrayList<WallStreetHeadlines> getWallstreetheadlines() {
        return wallstreetheadlines;
    }

    public void setWallstreetheadlines(ArrayList<WallStreetHeadlines> wallstreetheadlines) {
        this.wallstreetheadlines = wallstreetheadlines;
    }


}