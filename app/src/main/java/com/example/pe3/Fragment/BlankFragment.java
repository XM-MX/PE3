package com.example.pe3.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pe3.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment {

   private ViewPager mViewPager;
   private TabLayout mTabLayout;

   private List<Fragment> mFragmentList;
   private List<String> mTitleList;

    private ViewPagerAdapter vPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
        //return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPager = view.findViewById(R.id.viewpager2);
        mTabLayout = view.findViewById(R.id.tab_layout);

        initData();

        vPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),mFragmentList,mTitleList);

        mViewPager.setAdapter(vPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initData() {
        mFragmentList = new ArrayList<>();

        HomeFragment fragment1 = HomeFragment.newInstance("MY","");
        ChinaFragment fragment2 = ChinaFragment.newInstance("CN","");


        mFragmentList.add(fragment1);
        mFragmentList.add(fragment2);

        mTitleList = new ArrayList<>();

        mTitleList.add("MY");
        mTitleList.add("CN");

    }
}