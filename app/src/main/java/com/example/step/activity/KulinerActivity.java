package com.example.step.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.step.R;
import com.example.step.adapter.MainAdapter;
import com.example.step.data.AllPlaceData;
import com.example.step.viewmodel.MainViewModel;

import java.util.ArrayList;

public class KulinerActivity extends AppCompatActivity {

    ProgressBar progressBar;

    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);

        progressBar = findViewById(R.id.progressBar);


        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        String url = "http://192.168.19.40:8080/place";
        mainViewModel.setData(url);
        showLoading(true);
        mainViewModel.getData().observe(this, getData);

        adapter = new MainAdapter();
        adapter.notifyDataSetChanged();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private Observer<ArrayList<AllPlaceData>> getData = new Observer<ArrayList<AllPlaceData>>() {
        @Override
        public void onChanged(@Nullable ArrayList<AllPlaceData> listItems) {
            if (listItems != null) {
                adapter.setData(listItems);
                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
