package com.example.healthfriend.UserScreens.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.healthfriend.UserScreens.Fragments.BreakfastTodayFragment;
import com.example.healthfriend.UserScreens.Fragments.FavouriteMealsFragment;

public class BreakfastViewPagerAdapter extends FragmentStateAdapter {
    public BreakfastViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new BreakfastTodayFragment();
            case 1:
                return new FavouriteMealsFragment();
            default:
                return new BreakfastTodayFragment();


        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
