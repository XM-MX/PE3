package com.example.pe3.Scan;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ScanViewModelFactory implements ViewModelProvider.Factory {

    private final Application mDataSource;

    public ScanViewModelFactory(Application dataSource) {
        mDataSource = dataSource;
    }

    @Override
    @NonNull
    public <T extends ViewModel>
    T create(@NonNull Class<T> modelClass) {
        Log.i("Test", "ScanViewModelProviderFactory: ");
        if (modelClass.isAssignableFrom(ScanViewModel.class)) {
            Log.i("Test", "create: is assignable");
            return (T) new ScanViewModel(mDataSource);
        }
        //noinspection unchecked
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

// https://stackoverflow.com/questions/60016948/impementing-a-viewmodelprovider-factory-and-i-am-getting-a-null-pointer-execepti
// https://proandroiddev.com/architecture-components-modelview-livedata-33d20bdcc4e9