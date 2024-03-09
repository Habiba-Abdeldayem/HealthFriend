package com.example.healthfriend.UserScreens;

public class TodaysNutrientsEaten {
    private static Double eatenCalories;
    private static TodaysNutrientsEaten instance;
    private static Double eatenCarbs;
    private static Double eatenFats;
    private static Double eatenProteins;

    private TodaysNutrientsEaten() {
            eatenCalories = 0.0;
            eatenCarbs = 0.0;
            eatenFats = 0.0;
            eatenProteins = 0.0;
        }


    public static TodaysNutrientsEaten getInstance() {
        if (instance == null) {
            instance = new TodaysNutrientsEaten();
        }
        return instance;
    }
    public static Double getEatenCalories() {
        return Math.round(eatenCalories*100.0)/100.0;
    }

    public static void setEatenCalories(Double eatenCalories) {
        TodaysNutrientsEaten.eatenCalories = eatenCalories;
    }

    public static Double getEatenCarbs() {
        return Math.round(eatenCarbs*100.0)/100.0;
    }

    public static void setEatenCarbs(Double eatenCarbs) {
        TodaysNutrientsEaten.eatenCarbs = eatenCarbs;
    }

    public static Double getEatenFats() {
        return Math.round(eatenFats*100.0)/100.0;
    }

    public static void setEatenFats(Double eatenFats) {
        TodaysNutrientsEaten.eatenFats = eatenFats;
    }

    public static Double getEatenProteins() {
        return Math.round(eatenProteins*100.0)/100.0;
    }

    public static void setEatenProteins(Double eatenProteins) {
        TodaysNutrientsEaten.eatenProteins = eatenProteins;
    }
}
