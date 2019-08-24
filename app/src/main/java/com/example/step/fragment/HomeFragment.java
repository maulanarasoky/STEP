package com.example.step.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.step.R;
import com.example.step.activity.AlamActivity;
import com.example.step.activity.BudayaActivity;
import com.example.step.activity.EventActivity;
import com.example.step.activity.FotografiActivity;
import com.example.step.activity.KotaActivity;
import com.example.step.activity.KulinerActivity;
import com.example.step.activity.RekreasiActivity;
import com.example.step.activity.SearchActivity;
import com.example.step.activity.WisataActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    CarouselView carouselView;
    //    BestPlaceAdapter bestPlaceAdapter;
    TextView search;

    ImageButton alam, kota, wisata, rekreasi, budaya, event, fotografi, kuliner;
    int[] carouselImage = {R.drawable.carousel_1, R.drawable.carousel_2, R.drawable.carousel_3};

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        alam = view.findViewById(R.id.first_menu);
        alam.setOnClickListener(this);
        kota = view.findViewById(R.id.second_menu);
        kota.setOnClickListener(this);
        wisata = view.findViewById(R.id.third_menu);
        wisata.setOnClickListener(this);
        rekreasi = view.findViewById(R.id.fourth_menu);
        rekreasi.setOnClickListener(this);

        budaya = view.findViewById(R.id.fifth_menu);
        budaya.setOnClickListener(this);
        event = view.findViewById(R.id.sixth_menu);
        event.setOnClickListener(this);
        fotografi = view.findViewById(R.id.seventh_menu);
        fotografi.setOnClickListener(this);
        kuliner = view.findViewById(R.id.eight_menu);
        kuliner.setOnClickListener(this);

        carouselView = view.findViewById(R.id.carouselview);
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(carouselImage.length);

        search = view.findViewById(R.id.search_view);
        search.setOnClickListener(this);

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Glide.with(HomeFragment.this)
                    .load(carouselImage[position])
                    .into(imageView);
        }
    };

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.search_view:
                intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.first_menu:
                intent = new Intent(getActivity(), AlamActivity.class);
                startActivity(intent);
                break;
            case R.id.second_menu:
                intent = new Intent(getActivity(), KotaActivity.class);
                startActivity(intent);
                break;
            case R.id.third_menu:
                intent = new Intent(getActivity(), WisataActivity.class);
                startActivity(intent);
                break;
            case R.id.fourth_menu:
                intent = new Intent(getActivity(), RekreasiActivity.class);
                startActivity(intent);
                break;
            case R.id.fifth_menu:
                intent = new Intent(getActivity(), BudayaActivity.class);
                startActivity(intent);
                break;
            case R.id.sixth_menu:
                intent = new Intent(getActivity(), EventActivity.class);
                startActivity(intent);
                break;
            case R.id.seventh_menu:
                intent = new Intent(getActivity(), FotografiActivity.class);
                startActivity(intent);
                break;
            case R.id.eight_menu:
                intent = new Intent(getActivity(), KulinerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
