package com.example.pe3.Scan;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.pe3.api.History;

import java.util.List;

public class ScanViewModel extends AndroidViewModel {

    private HistoryRepository mRepository;
    private final MutableLiveData<List<History>> mAllHistories;

    public ScanViewModel(Application application) {
        super(application);
        mRepository = new HistoryRepository(application);
        mAllHistories = mRepository.getAllHistories();
    }

    MutableLiveData<List<History>> getAllHistories() {
        return mAllHistories;
    }

    void insert(History history) {
        mRepository.insert(history);
    }

}

