package com.example.healthfriend.UserScreens;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.healthfriend.UserScreens.Adapters.MealModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FireStoreManager {
    private FirebaseFirestore db;
    CollectionReference breakfastCollectionRef;
    private FirestoreCallback callback;

    // Add a method to set the callback
    public void setFirestoreCallback(FirestoreCallback callback) {
        this.callback = callback;
    }
//    CollectionReference lunchCollectionRef = db.collection("/BreakfastMeals");
//    CollectionReference dinnerCollectionRef = db.collection("/BreakfastMeals");

    // Get a reference to the specific document within the subcollection

    public FireStoreManager() {
        db = FirebaseFirestore.getInstance();
        breakfastCollectionRef = db.collection("/BreakfastMeals");
    }

    public List<MealModel> getBreakfastMeal() {
        List<MealModel> suggestedBreakfastMeals = new ArrayList<>();

// Define the range for calories, fat, and protein
        double minCalories = 200; // Minimum calories
        double maxCalories = 500; // Maximum calories
        double minFat = 20.0; // Minimum fat
        double maxFat = 30.0; // Maximum fat
        double minProtein = 25.0; // Minimum protein
        double maxProtein = 40.0; // Maximum protein

// Perform a query to get documents within the specified ranges
        Query query = breakfastCollectionRef
                .whereGreaterThanOrEqualTo("calories", minCalories)
                .whereLessThanOrEqualTo("calories", maxCalories)
                .whereGreaterThanOrEqualTo("fat", minFat)
                .whereLessThanOrEqualTo("fat", maxFat)
                .whereGreaterThanOrEqualTo("protein", minProtein)
                .whereLessThanOrEqualTo("protein", maxProtein);

// Execute the query
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<MealModel> suggestedBreakfastMeals = new ArrayList<>();
                    for (DocumentSnapshot document : task.getResult().getDocuments()) {
                        MealModel meal = document.toObject(MealModel.class);
                        suggestedBreakfastMeals.add(meal);
                    }
                    // Call the callback with the retrieved breakfast data
                    if (callback != null) {
                        callback.onBreakfastDataReady(suggestedBreakfastMeals);
                    }
                } else {
                    Log.d("habiba", "Error getting documents: ", task.getException());
                }
            }
        });

        return suggestedBreakfastMeals;
    }

//    public List<> getIngredients(List<Integer> ingredientsId) {
//
//    }

    public interface FirestoreCallback {
        void onBreakfastDataReady(List<MealModel> breakfastMeals);
    }

}
