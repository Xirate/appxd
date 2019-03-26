package com.onespan.onespaneval.utils;

import com.google.gson.annotations.SerializedName;
import com.onespan.onespaneval.model.FeatureItem;

import java.util.List;

public class ApiResponse {

    @SerializedName("features")
    private List<FeatureItem> featureItemList;

    public List<FeatureItem> getFeatureItemList() {
        return featureItemList;
    }

    public void setFeatureItemList(List<FeatureItem> featureItemList) {
        this.featureItemList = featureItemList;
    }
}
