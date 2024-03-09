package com.example.healthfriend.UserScreens.Fragments;
import com.example.healthfriend.UserScreens.Fragments.water.presentation.WaterFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthfriend.R;
import com.example.healthfriend.UserScreens.TodaysBreakfastSingleton;
import com.example.healthfriend.UserScreens.TodaysDinnerSingleton;
import com.example.healthfriend.UserScreens.TodaysLunchSingleton;
import com.example.healthfriend.UserScreens.TodaysNutrientsEaten;
import com.example.healthfriend.UserScreens.User;


public class HomeFragment extends Fragment {
    private TextView caloriesLeft;
    TodaysNutrientsEaten todaysNutrientsEaten;
    private double progress;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TodaysBreakfastSingleton breakfast = TodaysBreakfastSingleton.getInstance();
        TodaysLunchSingleton lunchFragment = TodaysLunchSingleton.getInstance();
        TodaysDinnerSingleton dinnerFragment = TodaysDinnerSingleton.getInstance();
        todaysNutrientsEaten = TodaysNutrientsEaten.getInstance();
        progress = (TodaysNutrientsEaten.getEatenCalories()/1500.0)*100;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        CardView caloriesCV = view.findViewById(R.id.calories_cv);
        CardView waterCV = view.findViewById(R.id.water_cv);
        CardView sleepCV = view.findViewById(R.id.sleep_cv);

        caloriesCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                MealsOverviewFragment mealsOverviewFragment = new MealsOverviewFragment();
                ft.replace(R.id.home_frame_layout, mealsOverviewFragment);
                ft.addToBackStack(null); // Add this line to enable back navigation
                ft.commit();
            }
        });

        waterCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                WaterFragment waterFragment = new WaterFragment();
                ft.replace(R.id.home_frame_layout, waterFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        sleepCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                SleepFragment sleepFragment = new SleepFragment();
                ft.replace(R.id.home_frame_layout, sleepFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProgressBar progressBar = view.findViewById(R.id.home_progress_bar);
        caloriesLeft = view.findViewById(R.id.homeFragment_calories_left);
        progressBar.setProgress((int)progress);
        String d = Integer.toString(User.getInstance().getAge());
        Toast myToast = Toast.makeText(getContext(), d, Toast.LENGTH_LONG);
        myToast.show();
        caloriesLeft.setText(d);
    }
    public void onResume() {
        super.onResume();

        ProgressBar progressBar = requireView().findViewById(R.id.home_progress_bar);
        double progress = (TodaysNutrientsEaten.getEatenCalories() / 1500.0) * 100;
        progressBar.setProgress((int) progress);
        caloriesLeft.setText(1500 - TodaysNutrientsEaten.getEatenCalories() + "\nleft");

    }
}