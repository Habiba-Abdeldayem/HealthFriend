package com.example.healthfriend.UserScreens;

public class TodaysNutrientsEaten {
    private static Double eatenCalories;
    private static Double eatenCarbs;
    private static Double eatenFats;
    private static Double eatenProteins;

    public TodaysNutrientsEaten() {
        eatenCalories = 0.0;
        eatenCarbs = 0.0;
        eatenFats = 0.0;
        eatenProteins = 0.0;
    }

    public static Double getEatenCalories() {
        return eatenCalories;
    }

    public static void setEatenCalories(Double eatenCalories) {
        TodaysNutrientsEaten.eatenCalories = eatenCalories;
    }

    public static Double getEatenCarbs() {
        return eatenCarbs;
    }

    public static void setEatenCarbs(Double eatenCarbs) {
        TodaysNutrientsEaten.eatenCarbs = eatenCarbs;
    }

    public static Double getEatenFats() {
        return eatenFats;
    }

    public static void setEatenFats(Double eatenFats) {
        TodaysNutrientsEaten.eatenFats = eatenFats;
    }

    public static Double getEatenProteins() {
        return eatenProteins;
    }

    public static void setEatenProteins(Double eatenProteins) {
        TodaysNutrientsEaten.eatenProteins = eatenProteins;
    }
}
