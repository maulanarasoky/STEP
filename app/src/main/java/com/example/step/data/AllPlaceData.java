package com.example.step.data;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class AllPlaceData implements Parcelable {

    private String title, location, price, photo, reviews, visitors, category, operasional, description;
    private float rating;

    public AllPlaceData(JSONObject object) {
        try {
            this.title = object.getString("placeName");
            this.location = object.getJSONArray("details").getJSONObject(0).getString("location");
            this.rating = object.getLong("ratingGeneral");
            this.price = object.getJSONArray("details").getJSONObject(0).getString("price");
            this.photo = "http://192.168.19.40:8080/download?file=" + object.getJSONArray("images").getJSONObject(0).getString("fileName");
            this.reviews = object.getString("reviewCount");
            this.visitors = object.getString("visitor");
            this.category = "Rekreasi";
            this.operasional = object.getJSONArray("details").getJSONObject(0).getString("operationalHour");
            this.description = object.getJSONArray("details").getJSONObject(0).getString("placeDesc");
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

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getVisitors() {
        return visitors;
    }

    public void setVisitors(String visitors) {
        this.visitors = visitors;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOperasional() {
        return operasional;
    }

    public void setOperasional(String operasional) {
        this.operasional = operasional;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.location);
        dest.writeString(this.price);
        dest.writeString(this.photo);
        dest.writeString(this.reviews);
        dest.writeString(this.visitors);
        dest.writeString(this.category);
        dest.writeString(this.operasional);
        dest.writeString(this.description);
        dest.writeFloat(this.rating);
    }

    protected AllPlaceData(Parcel in) {
        this.title = in.readString();
        this.location = in.readString();
        this.price = in.readString();
        this.photo = in.readString();
        this.reviews = in.readString();
        this.visitors = in.readString();
        this.category = in.readString();
        this.operasional = in.readString();
        this.description = in.readString();
        this.rating = in.readFloat();
    }

    public static final Parcelable.Creator<AllPlaceData> CREATOR = new Parcelable.Creator<AllPlaceData>() {
        @Override
        public AllPlaceData createFromParcel(Parcel source) {
            return new AllPlaceData(source);
        }

        @Override
        public AllPlaceData[] newArray(int size) {
            return new AllPlaceData[size];
        }
    };
}
