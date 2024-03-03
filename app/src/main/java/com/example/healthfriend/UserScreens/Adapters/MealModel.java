package com.example.healthfriend.UserScreens.Adapters;

import java.util.ArrayList;

public class MealModel {
    private double calories;
    private double carbohydrates;
    private double fat;
    private double protein;
    private ArrayList<Integer> meal_ingredients;

    public MealModel() {
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public ArrayList<Integer> getMeal_ingredients() {
        return meal_ingredients;
    }

    public void setMeal_ingredients(ArrayList<Integer> meal_ingredients) {
        this.meal_ingredients = meal_ingredients;
    }
}
