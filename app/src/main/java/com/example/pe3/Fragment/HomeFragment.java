package com.example.pe3.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pe3.HealthAssessmentActivity;
import com.example.pe3.Retrofit.MYActivity;
import com.example.pe3.TipsActivity;
import com.example.pe3.R;

public class HomeFragment extends Fragment {

    private String mParam1;
    private String mParam2;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ImageButton btn_ha, btn_tips, btn_world;

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_ha = view.findViewById(R.id.imageView3);
        btn_tips = view.findViewById(R.id.imageView4);
        btn_world = view.findViewById(R.id.btn_world);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // turn to AddNewsActivity

        btn_ha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), HealthAssessmentActivity.class);
                startActivity(intent);
            }
        });

        btn_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), TipsActivity.class);
                startActivity(intent);
            }
        });

        btn_world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MYActivity.class);
                startActivity(intent);
            }
        });

    }

}
