package com.example.healthfriend.UserScreens;

import com.example.healthfriend.UserScreens.Adapters.Ingredient;
import com.example.healthfriend.UserScreens.Adapters.MealModel;

import java.util.List;
import java.util.Random;

public class TodaysBreakfastSingleton implements FireStoreManager.FirestoreCallback{


    private static TodaysBreakfastSingleton instance;

    private FireStoreManager fireStoreManager;
    private List<MealModel> availableBreakfasts;
    private MealModel todaysBreakfast;

    private TodaysBreakfastSingleton() {
        fireStoreManager = new FireStoreManager();
        fireStoreManager.setFirestoreCallback(this); // Register TodaysBreakfastSingleton as the callback recipient
        availableBreakfasts = fireStoreManager.getBreakfastMeal();
    }

    public static TodaysBreakfastSingleton getInstance() {
        if (instance == null) {
            instance = new TodaysBreakfastSingleton();
        }
        return instance;
    }

    public MealModel getTodaysBreakfast() {
        return todaysBreakfast;
    }
    public void onBreakfastDataReady(List<MealModel> breakfastMeals) {
        // Handle the retrieved breakfast data here
        if (breakfastMeals != null && !breakfastMeals.isEmpty()) {
            // Get a random index within the range of availableBreakfasts size
            Random random = new Random();
            int randomIndex = random.nextInt(breakfastMeals.size());
            // Set todaysBreakfast to a randomly selected breakfast
            todaysBreakfast = breakfastMeals.get(randomIndex);
        }
    }
}
