package com.example.step.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.step.R;
import com.example.step.adapter.MainAdapter;
import com.example.step.data.AllPlaceData;
import com.example.step.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.Objects;

public class SearchActivity extends AppCompatActivity {

    SearchView search;

    MainAdapter adapter;

    ArrayList<AllPlaceData> list;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        progressBar = findViewById(R.id.progressBar);

        search = findViewById(R.id.searchView);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

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

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                filter(s);

                return false;
            }
        });
    }

    private void filter(String text) {
        ArrayList<AllPlaceData> filteredList = new ArrayList<>();

        for (AllPlaceData item : list) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
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
