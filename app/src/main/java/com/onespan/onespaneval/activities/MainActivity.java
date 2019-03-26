package com.onespan.onespaneval.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.annimon.stream.Stream;
import com.onespan.onespaneval.R;
import com.onespan.onespaneval.adapters.RecyclerAdapter;
import com.onespan.onespaneval.model.FeatureItem;
import com.onespan.onespaneval.utils.ApiResponse;
import com.onespan.onespaneval.utils.Rest;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    private static String DATA_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2018-10-22&endtime=2019-01-02&latitude=37.773972&longitude=-122.431297&maxradiuskm=100&limit=20&minmagnitude=2.5";

    private Button updateButton;
    private RecyclerView recycler;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();
        setupRecycler();
    }

    private void findViews() {
        updateButton = findViewById(R.id.button_id);
        recycler = findViewById(R.id.data_recycler);
    }

    private void setListeners() {
        updateButton.setOnClickListener((v) -> fetchData());
    }

    private void setupRecycler() {
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter();
        recycler.setAdapter(adapter);
    }

    private void fetchData() {
        Rest.getInstance().getApi().getData().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse> call, @NonNull Response<ApiResponse> response) {
                if(response.body() != null && response.body().getFeatureItemList() != null) {
                    adapter.setData(Stream.of(response.body().getFeatureItemList()).map(FeatureItem::getData).toList());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse> call, @NonNull Throwable t) {
                Toast.makeText(getBaseContext(), "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
