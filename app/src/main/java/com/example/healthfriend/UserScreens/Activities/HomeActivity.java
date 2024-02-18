package com.example.healthfriend.UserScreens.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.healthfriend.UserScreens.Fragments.HomeFragment;
import com.example.healthfriend.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        HomeFragment homeFragment= new HomeFragment();
        ft.replace(R.id.home_frame_layout,homeFragment);
        ft.commit();
        bottomNavigationView = findViewById(R.id.home_nav_bar);
        frameLayout = findViewById(R.id.home_frame_layout);





    }
}