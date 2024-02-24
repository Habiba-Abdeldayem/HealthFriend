package com.example.healthfriend.UserScreens.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.healthfriend.DoctorScreens.Change_meal_Fragment;
import com.example.healthfriend.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DinnerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DinnerFragment extends Fragment {

    boolean dinner_fav_isClicked = false;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DinnerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DinnerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DinnerFragment newInstance(String param1, String param2) {
        DinnerFragment fragment = new DinnerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dinner, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Now, you can add your fragment to the FrameLayout programmatically
        getChildFragmentManager().beginTransaction()
                .replace(R.id.child_dinner_frame, new DinnerTodayFragment())
                .commit();

        ImageButton favourite_btn = view.findViewById(R.id.dinner_btn_add_to_favourite);
        ImageButton change_meal_btn = view.findViewById(R.id.dinner_btn_change_meal);
        favourite_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!dinner_fav_isClicked){
                    dinner_fav_isClicked = true;
                    favourite_btn.setImageResource(R.drawable.ic_favourite_red);
                }
                else{
                    dinner_fav_isClicked = false;
                    favourite_btn.setImageResource(R.drawable.ic_favourite_grey);
                }
            }
        });
        change_meal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change_meal_Fragment change_meal_fragment = new Change_meal_Fragment();
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout, change_meal_fragment).addToBackStack(null).commit();
            }
        });
    }

}