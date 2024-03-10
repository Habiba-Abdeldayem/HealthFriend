package com.example.healthfriend.UserScreens.Fragments.profile.data;

public final class ProfileUser {

    private final String weight;
    private final String height;
    private final String gender;
    private final String age;

    public ProfileUser(String weight, String height, String gender, String age) {
        // Add data validation logic here (optional)
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

}

