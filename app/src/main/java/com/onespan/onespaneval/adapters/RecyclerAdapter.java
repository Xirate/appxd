package com.onespan.onespaneval.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.onespan.onespaneval.R;
import com.onespan.onespaneval.model.DataModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VH> {

    private List<DataModel> data = new ArrayList<>();

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        DataModel dataItem = data.get(i);

        vh.placeName.setText(dataItem.getPlaceName());
        vh.date.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date(dataItem.getTimestamp())));
        vh.strength.setText(String.valueOf(dataItem.getMag()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<DataModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    class VH extends RecyclerView.ViewHolder {

        TextView placeName;
        TextView date;
        TextView strength;

        VH(@NonNull View itemView) {
            super(itemView);

            this.placeName = itemView.findViewById(R.id.place_name_text);
            this.date = itemView.findViewById(R.id.date_text);
            this.strength = itemView.findViewById(R.id.strength_text);
        }
    }
}
