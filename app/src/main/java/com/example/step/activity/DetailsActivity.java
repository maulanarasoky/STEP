package com.example.step.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.step.R;
import com.example.step.data.AllPlaceData;

public class DetailsActivity extends AppCompatActivity {

    public static final String DATA = "data";

    TextView tvTitle, tvLocation, tvReviews, tvVisitors, tvPrice, tvCategory, tvOperational, tvDescription;

    RatingBar ratingBar;

    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;

    ImageView otherImg1, otherImg2, otherImg3, otherImg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        prepareData();
        setData();
    }

    public void prepareData() {
        tvTitle = findViewById(R.id.tv_title);
        tvLocation = findViewById(R.id.tv_location);
        tvReviews = findViewById(R.id.tv_review);
        tvVisitors = findViewById(R.id.visitors);
        tvPrice = findViewById(R.id.tv_price);
        tvCategory = findViewById(R.id.category);
        tvOperational = findViewById(R.id.tv_time);

        tvDescription = findViewById(R.id.tv_description);

        ratingBar = findViewById(R.id.ratingBar);

        collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);


        otherImg1 = findViewById(R.id.other_img1);
        otherImg2 = findViewById(R.id.other_img2);
        otherImg3 = findViewById(R.id.other_img3);
        otherImg4 = findViewById(R.id.other_img4);


    }

    public void setData() {
        AllPlaceData allPlaceData = getIntent().getParcelableExtra(DATA);
        tvTitle.setText(allPlaceData.getTitle());
        tvLocation.setText(allPlaceData.getLocation());
        tvReviews.setText(allPlaceData.getReviews());
        tvVisitors.setText(allPlaceData.getVisitors());
        tvPrice.setText(allPlaceData.getPrice());
        tvCategory.setText(allPlaceData.getCategory());
        tvOperational.setText(allPlaceData.getOperasional());
        tvDescription.setText(allPlaceData.getDescription());


        ratingBar.setRating(allPlaceData.getRating());
        collapsingToolbarLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.carousel_1));

        Glide.with(this).load(allPlaceData.getPhoto()).into(otherImg1);
        Glide.with(this).load(allPlaceData.getPhoto()).into(otherImg2);
        Glide.with(this).load(allPlaceData.getPhoto()).into(otherImg3);
        Glide.with(this).load(allPlaceData.getPhoto()).into(otherImg4);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
