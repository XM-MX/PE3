package com.example.pe3.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.pe3.HealthAssessmentActivity;
import com.example.pe3.R;
import com.example.pe3.Retrofit.MYActivity;
import com.example.pe3.TipsActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ChinaFragment extends Fragment {

    private ImageButton btn_china;
    private ImageButton btn_ha;
    private ImageButton btn_tips;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static ChinaFragment newInstance(String param1, String param2) {
        ChinaFragment fragment = new ChinaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_china, container, false);

        btn_china = view.findViewById(R.id.imageView5);
        btn_ha = view.findViewById(R.id.imageView3);
        btn_tips = view.findViewById(R.id.imageView4);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // turn to AddNewsActivity
        btn_china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MYActivity.class);
                startActivity(intent);
            }
        });

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
    }
}