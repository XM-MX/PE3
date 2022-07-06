package com.example.pe3.Scan;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pe3.R;
import com.example.pe3.api.History;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.LinkedList;

public class ScanFragment extends Fragment {


    ImageButton btnScan;
    TextView tv_qr_readTxt;

    private RecyclerView recyclerView;
    HistoryListAdapter adapter;
    private final LinkedList<History> historyList = new LinkedList<>();

    ScanViewModel mainViewModel;
    //MainViewModelFactory mainViewModelFactory;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scan, container, false);

        btnScan = view.findViewById(R.id.btnScan);
        //tv_qr_readTxt = findViewById(R.id.tv_qr_readTxt);

        // Set up recycler view.
        recyclerView = view.findViewById(R.id.recyclerview);
        adapter = new HistoryListAdapter(new HistoryListAdapter.HistoryDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Get a new or existing ViewModel from the ViewModelProvider.
        //mainViewModelFactory = new MainViewModelFactory((Application) this.getApplicationContext());
        mainViewModel = new ViewModelProvider(com.example.pe3.Scan.ScanFragment.this).get(ScanViewModel.class);

        mainViewModel.getAllHistories().observe(getActivity(), histories -> {

            // Store the scanner text to array list
            int historyListSize = historyList.size();
            // Update the cached copy of the histories in the adapter.
            adapter.submitList(histories);
            recyclerView.getAdapter().notifyDataSetChanged();
            // Scroll to the bottom.
            recyclerView.smoothScrollToPosition(historyListSize);
        });

        //Scanning button listener
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IntentIntegrator integrator = new IntentIntegrator(getActivity());
                //set the properties of the scan
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.setOrientationLocked(true);

                integrator.initiateScan();
            }
        });


        return view;
    }






    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.e("Scan*******", "Cancelled scan");
            } else {
                Log.e("Scan", "Scanned");

                //tv_qr_readTxt.setText(result.getContents());
                Toast.makeText(getActivity(), "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                // Split the result here
                String scanResult = result.getContents();
                //String[] item = scanResult.split(";");

                String current_date = java.time.LocalDate.now().toString();
                String current_time = java.time.LocalTime.now().toString();

                History history = new History(current_date,current_time,scanResult);
                //historyViewModel.insert(history);
                //save_postData(current_date,current_time,item[0],item[1]);
                mainViewModel.insert(history);

                // Store the scanner text to array list
                int historyListSize = historyList.size();
                // Add a new word to the historyList.
                historyList.addLast(history);
                adapter.submitList(historyList);
                recyclerView.getAdapter().notifyDataSetChanged();
                // Scroll to the bottom.
                recyclerView.smoothScrollToPosition(historyListSize);

            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}