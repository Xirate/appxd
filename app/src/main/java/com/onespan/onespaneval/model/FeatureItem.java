package com.onespan.onespaneval.model;

import com.google.gson.annotations.SerializedName;
import com.onespan.onespaneval.model.DataModel;

public class FeatureItem {

    @SerializedName("properties")
    private DataModel data;

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }
}
