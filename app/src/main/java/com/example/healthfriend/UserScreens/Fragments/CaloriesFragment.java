package com.example.healthfriend.UserScreens.Fragments;

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
import com.example.healthfriend.UserScreens.Adapters.MealModel;
import com.example.healthfriend.UserScreens.TodaysBreakfastSingleton;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class CaloriesFragment extends Fragment {



    TextView deleteme;
    TodaysBreakfastSingleton breakfast;
    public CaloriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        breakfast = TodaysBreakfastSingleton.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calories, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView breakfastCv = view.findViewById(R.id.breakfast_cv);
        CardView lunchCv = view.findViewById(R.id.lunch_cv);
        CardView dinnerCv = view.findViewById(R.id.dinner_cv);

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

        ProgressBar progressBar = view.findViewById(R.id.fragment_calories_progress_bar);
        double progress = (TodaysBreakfastSingleton.getInstance().getTotalCalories()/1500)*100;
        progressBar.setProgress((int)progress);
        deleteme = view.findViewById(R.id.deleteme_textViewData);
        Log.d("habba","zz");

        loadNote();
    }

    public void loadNote() {


        if (breakfast.getTodaysBreakfast() != null) {
            deleteme.setText("carbs: " + breakfast.getTodaysBreakfast().getCarbohydrates());
        } else {
            // Handle the case when todaysBreakfast is null
            Toast.makeText(getContext(), "Today's breakfast is not available yet.", Toast.LENGTH_SHORT).show();
        }
    }
}