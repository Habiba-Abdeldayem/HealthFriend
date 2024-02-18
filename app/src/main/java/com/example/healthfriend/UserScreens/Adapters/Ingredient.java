package com.example.healthfriend.UserScreens.Adapters;

public class Ingredient {
    private String ingredientName;
    private int calories;
    private String servingSize;

    public Ingredient(String ingredientName, int calories, String servingSize) {
        this.ingredientName = ingredientName;
        this.calories = calories;
        this.servingSize = servingSize;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getCalories() {
        return calories;
    }

    public String getServingSize() {
        return servingSize;
    }
}
