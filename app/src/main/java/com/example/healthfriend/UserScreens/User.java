package com.example.healthfriend.UserScreens;

import com.google.firebase.firestore.DocumentSnapshot;

public class User {
    private double height,weight, daily_calories_need, daily_carbs_need,daily_proteins_need,daily_fats_need ,daily_water_need;
    private int age, water_target;
    private String email,gender, plan;
    private static User instance;


    public double getDaily_carbs_need() {
        return daily_carbs_need;
    }

    public void setDaily_carbs_need() {
        this.daily_carbs_need = daily_carbs_need;
    }

    public double getDaily_proteins_need() {
        return daily_proteins_need;
    }

    public void setDaily_proteins_need() {
        this.daily_proteins_need = daily_proteins_need;
    }

    public double getDaily_fats_need() {
        return daily_fats_need;
    }

    public void setDaily_fats_need() {
        this.daily_fats_need = daily_fats_need;
    }

    private User(){
        height =0;
        weight=0;
        daily_calories_need = 0;
        age=0;
        water_target=0;
        daily_water_need = 0;
        daily_carbs_need =0;
        daily_fats_need =0 ;
        daily_proteins_need =0 ;
        email = "";
        gender = "";
        plan = "";
    }
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDaily_calories_need() {
        return daily_calories_need;
    }

    public void setDaily_calories_need() {
        this.daily_calories_need = daily_calories_need;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWater_target() {
        return water_target;
    }

    public void setWater_target(int water_target) {
        this.water_target = water_target;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getDaily_water_need() {
        return daily_water_need;
    }

    public void setDaily_water_need() {
        this.daily_water_need = daily_water_need;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void fromDocumentSnapshot(DocumentSnapshot document) {
        if (document.exists()) {
            height = document.getDouble("height");
            weight = document.getDouble("weight");
            daily_calories_need = document.getDouble("daily_calories_need");
            age = document.getLong("age").intValue();
//            water_target = document.getLong("water_target").intValue();
            daily_water_need = document.getDouble("daily_water_need");
//            daily_carbs_need = document.getDouble("daily_carbs_need");
//            daily_fats_need = document.getDouble("daily_fats_need");
//            daily_proteins_need = document.getDouble("daily_proteins_need");
            gender = document.getString("gender");
        }
    }


}
