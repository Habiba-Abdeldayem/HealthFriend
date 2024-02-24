package com.example.healthfriend.UserScreens.Adapters;

public class Ingredient {
    private String ingredientName;
    private int calories;
    private String servingSize;
    private boolean isIngredientSelected; // New boolean field to track the image state


    public Ingredient(String ingredientName, int calories, String servingSize) {
        this.ingredientName = ingredientName;
        this.calories = calories;
        this.servingSize = servingSize;
        this.isIngredientSelected = false;
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

    public boolean isIngredientSelected() {
        return isIngredientSelected;
    }

    public void setIngredientSelected(boolean ingredientSelected) {
        isIngredientSelected = ingredientSelected;
    }
}
