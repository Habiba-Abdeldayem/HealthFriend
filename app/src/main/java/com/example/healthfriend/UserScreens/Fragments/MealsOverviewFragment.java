package com.example.healthfriend.UserScreens.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthfriend.R;
import com.example.healthfriend.UserScreens.TodaysBreakfastSingleton;
import com.example.healthfriend.UserScreens.TodaysNutrientsEaten;

public class MealsOverviewFragment extends Fragment {

    private TextView deleteme, caloriesLeft, carbsLeft,proteinsLeft,fatsLeft;
    TodaysBreakfastSingleton breakfast;
    TodaysNutrientsEaten todaysNutrientsEaten;
    private double progress;
    public MealsOverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        breakfast = TodaysBreakfastSingleton.getInstance();
        todaysNutrientsEaten = TodaysNutrientsEaten.getInstance();
        progress = (TodaysNutrientsEaten.getEatenCalories()/1500.0)*100;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meals_overview, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView breakfastCv = view.findViewById(R.id.breakfast_cv);
        CardView lunchCv = view.findViewById(R.id.lunch_cv);
        CardView dinnerCv = view.findViewById(R.id.dinner_cv);
        caloriesLeft =view.findViewById(R.id.mealsOverview_calories_tv);
        carbsLeft =view.findViewById(R.id.mealsOverview_carbs_tv);
        proteinsLeft =view.findViewById(R.id.mealsOverview_proteins_tv);
        fatsLeft =view.findViewById(R.id.mealsOverview_fats_tv);
        breakfastCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                BreakfastFragment breakfastFragment = new BreakfastFragment();
                ft.replace(R.id.home_frame_layout, breakfastFragment);
                ft.addToBackStack(null); // Add this line to enable back navigation
                ft.commit();
            }
        });

        lunchCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LunchFragment lunchFragment = new LunchFragment();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout, lunchFragment).addToBackStack(null).commit();
            }
        });
        dinnerCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DinnerFragment dinnerFragment = new DinnerFragment();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout, dinnerFragment).addToBackStack(null).commit();
            }
        });

        ProgressBar progressBar = view.findViewById(R.id.fragment_mealsOverview_progress_bar);
        progressBar.setProgress((int)progress);
        deleteme = view.findViewById(R.id.deleteme_textViewData);

        loadNote();
    }

    public void loadNote() {


        if (breakfast.getTodaysBreakfast() != null) {
            deleteme.setText("fats: " + breakfast.getTodaysBreakfast().getFat());
        } else {
            // Handle the case when todaysBreakfast is null
            Toast.makeText(getContext(), "Check network connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void onResume() {
        super.onResume();
        updateCaloriesProgress();

    }

    private void updateCaloriesProgress(){
        ProgressBar caloriesProgressBar = requireView().findViewById(R.id.fragment_mealsOverview_progress_bar);
        double caloriesProgress = (TodaysNutrientsEaten.getEatenCalories() / 1500.0) * 100;
        caloriesProgressBar.setProgress((int) caloriesProgress);

        caloriesLeft.setText(Double.toString(1500 - TodaysNutrientsEaten.getEatenCalories()) + "\n Left");
        carbsLeft.setText(TodaysNutrientsEaten.getEatenCarbs()+"/100");
        proteinsLeft.setText(TodaysNutrientsEaten.getEatenProteins()+"/100");
        fatsLeft.setText(TodaysNutrientsEaten.getEatenFats()+"/100");

    }
}