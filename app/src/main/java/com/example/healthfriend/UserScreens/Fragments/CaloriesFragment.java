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

        ProgressBar progressBar = view.findViewById(R.id.calories_progress_bar);
        progressBar.setProgress(20);
        deleteme = view.findViewById(R.id.deleteme_textViewData);
//        breakfast = TodaysBreakfastSingleton.getInstance();
//        loadNote();
    }

    public void loadNote() {
//        documentRef.get()
//                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                        if (documentSnapshot.exists()) {
//                            MealModel meal = documentSnapshot.toObject(MealModel.class);
                          //  deleteme.setText("Title: " + breakfast.getTodaysBreakfast().getCalories());
//                            Toast.makeText(getContext(), "Document does not exist", Toast.LENGTH_SHORT).show();
//
//                        } else {
//                            Toast.makeText(getContext(), "Document does not exist", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//
//                    }
//                });
    }
}