package com.onespan.onespaneval.model;

import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("place")
    private String placeName;

    @SerializedName("time")
    private long timestamp;

    @SerializedName("mag")
    private float mag;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public float getMag() {
        return mag;
    }

    public void setMag(float mag) {
        this.mag = mag;
    }
}
