package com.example.pe3.Scan;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.pe3.R;


class HistoryViewHolder extends RecyclerView.ViewHolder {
    private final TextView dateTextView;
    private final TextView timeTextView;
    //private final TextView statusTextView;
    private final TextView locationTextView;

    private HistoryViewHolder(View itemView) {
        super(itemView);
        dateTextView = itemView.findViewById(R.id.date_text);
        timeTextView = itemView.findViewById(R.id.time_text);
        locationTextView = itemView.findViewById(R.id.location_text);
    }


    public void bindDate(String text) {
        dateTextView.setText(text);
    }
    public void bindTime(String text) {
        timeTextView.setText(text);
    }

    public void bindLocation(String text) {
        locationTextView.setText(text);
    }



    public void bind(String date, String time, String location) {
        dateTextView.setText(date);
        timeTextView.setText(time);
        //statusTextView.setText(status);
        locationTextView.setText(location);
    }

    static HistoryViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_item, parent, false);
        return new HistoryViewHolder(view);
    }
}
