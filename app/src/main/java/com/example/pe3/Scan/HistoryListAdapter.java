package com.example.pe3.Scan;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.pe3.api.History;

import java.util.List;


public class HistoryListAdapter
        extends ListAdapter<History, HistoryViewHolder> {

    private List<History> historyList;

    public HistoryListAdapter(@NonNull DiffUtil.ItemCallback<History> diffCallback) {
        super(diffCallback);
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return HistoryViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        History current = getItem(position);
        holder.bind(current.getDate(),current.getTime(),current.getLocation());

        /*
        holder.bindDate(current.getDate());
        holder.bindTime(current.getTime());
        holder.bindStatus(current.getStatus());
        holder.bindLocation(current.getLocation());

         */
    }

    static class HistoryDiff extends DiffUtil.ItemCallback<History> {

        @Override
        public boolean areItemsTheSame(@NonNull History oldItem, @NonNull History newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull History oldItem, @NonNull History newItem) {
            return oldItem.getDate().equals(newItem.getDate()) &&
                    oldItem.getTime().equals(newItem.getTime()) &&
                    oldItem.getLocation().equals(newItem.getLocation());
        }
    }
}
