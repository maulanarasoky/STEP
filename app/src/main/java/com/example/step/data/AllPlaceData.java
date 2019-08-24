package com.example.step.data;

import org.json.JSONObject;

public class AllPlaceData {

    private String title, location, price, photo;
    private float rating;

    public AllPlaceData(JSONObject object) {
        try {
            this.title = object.getString("placeName");
            this.location = object.getString("location");
            this.rating = object.getLong("ratingGeneral");
            this.price = object.getString("price");
            this.photo = ("http://192.168.19.40:8080/" + object.getString("photo"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
