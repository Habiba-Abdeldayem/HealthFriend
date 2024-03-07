package com.example.healthfriend.UserScreens.Adapters;

public class IngredientModel {
    private String name;
    private int calories;
    private int protein;
    private int carbohydrates;
    private int id;
    private String servingSize;
    private boolean isIngredientSelected; // New boolean field to track the image state

    public IngredientModel() {
    }

    public IngredientModel(String name, int calories, String servingSize) {
        this.name = name;
        this.calories = calories;
        this.servingSize = servingSize;
        this.isIngredientSelected = false;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
