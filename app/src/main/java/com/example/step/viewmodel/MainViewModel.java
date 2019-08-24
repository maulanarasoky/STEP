package com.example.step.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.step.data.AllPlaceData;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainViewModel extends ViewModel {

    private MutableLiveData<ArrayList<AllPlaceData>> listData = new MutableLiveData<>();

    public void setData(String url) {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<AllPlaceData> data = new ArrayList<>();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONArray list = new JSONArray(result);
                    for (int i = 0; i < list.length(); i++) {
                        JSONObject allData = list.getJSONObject(i);
                        AllPlaceData allPlaceData = new AllPlaceData(allData);
                        data.add(allPlaceData);
                    }
                    listData.postValue(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<AllPlaceData>> getData() {
        return listData;
    }
}
