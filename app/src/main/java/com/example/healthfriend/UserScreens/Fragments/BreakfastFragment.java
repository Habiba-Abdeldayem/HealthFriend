package com.example.healthfriend.UserScreens.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.healthfriend.DoctorScreens.Change_meal_Fragment;
import com.example.healthfriend.R;
import com.example.healthfriend.UserScreens.Adapters.IngredientAdapter;
import com.example.healthfriend.UserScreens.Adapters.IngredientModel;
import com.example.healthfriend.UserScreens.BreakfastAdapterInterface;
import com.example.healthfriend.UserScreens.PythonBreakfast;
import com.example.healthfriend.UserScreens.PythonIngredient;
import com.example.healthfriend.UserScreens.TodaysBreakfastSingleton;
import com.example.healthfriend.UserScreens.TodaysNutrientsEaten;

import java.util.ArrayList;
import java.util.List;


public class BreakfastFragment extends Fragment implements BreakfastAdapterInterface {
    boolean breakfast_fav_isClicked = false;
    private PythonBreakfast pythonBreakfast;
    private ProgressBar caloriesProgressBar, carbsProgressBar , proteinsProgressBar, fatsProgressBar;
    private TextView textview_calories_progress, textview_carbs_progress, textview_proteins_progress, textview_fats_progress;

    public BreakfastFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breakfast, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton favourite_btn = view.findViewById(R.id.breakfast_btn_add_to_favourite);
        ImageButton change_meal_btn = view.findViewById(R.id.breakfast_btn_change_meal);
        caloriesProgressBar = view.findViewById(R.id.breakfast_calories_progressbar);
        carbsProgressBar = view.findViewById(R.id.breakfast_carbs_progressbar);
        proteinsProgressBar = view.findViewById(R.id.breakfast_proteins_progressbar);
        fatsProgressBar = view.findViewById(R.id.breakfast_fats_progressbar);
        textview_calories_progress = view.findViewById(R.id.breakfast_textview_calories_progress);
        textview_carbs_progress = view.findViewById(R.id.breakfast_textview_carbs_progress);
        textview_proteins_progress = view.findViewById(R.id.breakfast_textview_proteins_progress);
        textview_fats_progress = view.findViewById(R.id.breakfast_textview_fats_progress);
        updateCaloriesProgress(); updateCarbsProgress(); updateProteinsProgress(); updateFatsProgress();

        pythonBreakfast = PythonBreakfast.getInstance();
        List<PythonIngredient> pythonIngredients = new ArrayList<>();

        // Adding elements to the list
        pythonIngredients.add(new PythonIngredient("Ingredient 1", 10.5, 100.0, 5.0, 20.0));
        pythonIngredients.add(new PythonIngredient("Ingredient 2", 15.0, 150.0, 7.0, 25.0));
        pythonIngredients.add(new PythonIngredient("Ingredient 3", 20.0, 200.0, 10.0, 30.0));
        pythonBreakfast.setBreakfastPythonIngredients(pythonIngredients);
        List<PythonIngredient> breakfastIngredients = pythonBreakfast.getBreakfastPythonIngredients();

//        breakfastSingleton = TodaysBreakfastSingleton.getInstance();
//        List<IngredientModel> todaysIngredient = breakfastSingleton.getBreakfastIngredients();

        if (breakfastIngredients != null) {

            RecyclerView recyclerView = view.findViewById(R.id.rv_breakfast_suggested_meals);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            IngredientAdapter adapter = new IngredientAdapter(breakfastIngredients, recyclerView, this);
            recyclerView.setAdapter(adapter);


        }

        favourite_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!breakfast_fav_isClicked) {
                    breakfast_fav_isClicked = true;
                    favourite_btn.setImageResource(R.drawable.ic_favourite_red);
                } else {
                    breakfast_fav_isClicked = false;
                    favourite_btn.setImageResource(R.drawable.ic_favourite_grey);
                }
            }
        });
        change_meal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change_meal_Fragment change_meal_fragment = new Change_meal_Fragment();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout, change_meal_fragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public void addItem(int position) {
//        if (pythonBreakfast.getTodaysBreakfast() != null) {
            updateCaloriesProgress();
            updateCarbsProgress();
            updateProteinsProgress();
            updateFatsProgress();
//        }
    }

    @Override
    public void removeItem(int position) {
//        if (breakfastSingleton.getTodaysBreakfast() != null) {
            updateCaloriesProgress();
            updateCarbsProgress();
            updateProteinsProgress();
            updateFatsProgress();
//        }

    }

    private void updateCaloriesProgress(){
        double caloriesProgress = (TodaysNutrientsEaten.getEatenCalories() / 1500.0) * 100;
        caloriesProgressBar.setProgress((int) caloriesProgress);
        String caloriesProgressText = Double.toString(Math.round(TodaysNutrientsEaten.getEatenCalories()*100.0)/100.0);
        textview_calories_progress.setText(caloriesProgressText + "/" + "1500");
    }
    private void updateCarbsProgress(){
        double carbsProgress = (TodaysNutrientsEaten.getEatenCarbs() / 100) * 100;
        carbsProgressBar.setProgress((int) carbsProgress);
        String carbsProgressText = Double.toString(Math.round(TodaysNutrientsEaten.getEatenCarbs()*100.0)/100.0);
        textview_carbs_progress.setText(carbsProgressText + "/" + "100");
    }
    private void updateProteinsProgress(){
        double proteinsProgress = (TodaysNutrientsEaten.getEatenProteins() /100) * 100;
        proteinsProgressBar.setProgress((int) proteinsProgress);

        String proteinsProgressText = Double.toString(Math.round(TodaysNutrientsEaten.getEatenProteins()*100.0)/100.0);
        textview_proteins_progress.setText(proteinsProgressText + "/" + "100");
    }
    private void updateFatsProgress(){
        double fatsProgress = (TodaysNutrientsEaten.getEatenFats() / 100) * 100;
        fatsProgressBar.setProgress((int) fatsProgress);

        String fatsProgressText = Double.toString(Math.round(TodaysNutrientsEaten.getEatenFats()*100.0)/100.0);
        textview_fats_progress.setText(fatsProgressText + "/" + "100");
    }

}