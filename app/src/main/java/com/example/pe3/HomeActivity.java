package com.example.pe3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.pe3.Fragment.HomeFragment;
import com.example.pe3.Fragment.LocationFragment;
import com.example.pe3.Fragment.QAFragment;
import com.example.pe3.Fragment.ScanFragment;
import com.example.pe3.Fragment.UserInformationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    //widget
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initialize widget
        bottomNavigationView = findViewById(R.id.bottomNav);
        frameLayout = findViewById(R.id.fragmentContainer);

        //bind click event for widget
        setBottomNavigationView();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
    }


    private void setBottomNavigationView(){

        //set listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //fragment to be selected
                Fragment selectFragment = null;

                //switch fragment
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        selectFragment = new HomeFragment();
                        break;
                    case R.id.navigation_location:
                        selectFragment = new LocationFragment();
                        break;
                    case R.id.navigation_scan:
                        selectFragment = new ScanFragment();
                        break;
                    case R.id.navigation_qa:
                        selectFragment = new QAFragment();
                        break;
                    case R.id.navigation_user:
                        selectFragment = new UserInformationFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectFragment).commit();
                return true;
            }
        });
    }
}