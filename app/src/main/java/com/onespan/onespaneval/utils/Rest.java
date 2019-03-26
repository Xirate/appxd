package com.onespan.onespaneval.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rest {

    private static final String BASE_URL="https://earthquake.usgs.gov/fdsnws/event/1/";

    private static Rest instance;

    public static Rest getInstance() {
        if (instance == null) {
            instance = new Rest();
        }
        return instance;
    }

    private Rest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    private Api api;

    public Api getApi() {
        return api;
    }
}
