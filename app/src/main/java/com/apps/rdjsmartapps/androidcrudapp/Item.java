package com.apps.rdjsmartapps.androidcrudapp;

/**
 * Created by Harshal on 4/1/2018.
 */

public class Item {

    private int Id, imageId;
    private String movieName;
    private int rating;

    //Constructor

    public Item(int Id, int imageId, String movieName, int rating) {
        this.Id = Id;
        this.imageId = imageId;
        this.movieName = movieName;
        this.rating = rating;
    }

    // setters and getters


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = Id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
