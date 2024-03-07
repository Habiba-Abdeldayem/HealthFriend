package com.example.healthfriend.UserScreens.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healthfriend.R;
import com.example.healthfriend.UserScreens.Adapters.IngredientModel;
import com.example.healthfriend.UserScreens.Adapters.IngredientAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LunchTodayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LunchTodayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LunchTodayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LunchTodayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LunchTodayFragment newInstance(String param1, String param2) {
        LunchTodayFragment fragment = new LunchTodayFragment();
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
        return inflater.inflate(R.layout.fragment_lunch_today, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<IngredientModel> ingredientModels = new ArrayList<>();
        ingredientModels.add(new IngredientModel("chicken", 200, "1 serving"));
        ingredientModels.add(new IngredientModel("rice", 300, "100 g"));
        ingredientModels.add(new IngredientModel("salad", 20, "100 g"));
        ingredientModels.add(new IngredientModel("Orange Juice", 120, "1 cup"));

        RecyclerView recyclerView = view.findViewById(R.id.rv_lunch_suggested_meals);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        IngredientAdapter adapter = new IngredientAdapter(ingredientModels, recyclerView);
        recyclerView.setAdapter(adapter);


//        adapter.setOnItemClickListener(new IngredientAdapter.OnItemClickListener() {
//            public void onItemClick(int position) {
//                // Handle CardView click here
//            }
//
//            @Override
//            public void onAddClick(int position) {
//                adapter.updateBackgroundColor(position, Color.GREEN);
//
//            }
//        });
    }

}