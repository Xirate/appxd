package com.onespan.onespaneval.utils;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("query?format=geojson&starttime=2018-10-22&endtime=2019-01-02&latitude=37.773972&longitude=-122.431297&maxradiuskm=100&limit=20&minmagnitude=2.5")
    Call<ApiResponse> getData();
}
