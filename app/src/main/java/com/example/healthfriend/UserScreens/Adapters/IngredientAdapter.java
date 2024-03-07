package com.example.healthfriend.UserScreens.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthfriend.R;
import com.example.healthfriend.UserScreens.TodaysBreakfastSingleton;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {

    private List<IngredientModel> ingredientModelList;
    RecyclerView recyclerView;

    public IngredientAdapter(List<IngredientModel> ingredientModelList, RecyclerView recyclerView) {
        this.ingredientModelList = ingredientModelList;
        this.recyclerView = recyclerView;
    }

    @Override
    public IngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingredient, parent, false);
        IngredientViewHolder vh = new IngredientViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(IngredientViewHolder holder, int position) {
        IngredientModel currentIngredient = ingredientModelList.get(position);

        holder.textViewIngredientName.setText(currentIngredient.getName());
        holder.textViewCalories.setText(currentIngredient.getCalories() + "Kcal, ");
        holder.textViewServingSize.setText(currentIngredient.getServingSize());

        if (currentIngredient.isIngredientSelected()) {
            holder.imageViewAddItem.setImageResource(R.drawable.ic_ingredient_check_green);
            currentIngredient.setIngredientSelected(true);
            TodaysBreakfastSingleton todaysBreakfastSingleton = TodaysBreakfastSingleton.getInstance();
            Log.d("currentcal", Double.toString(todaysBreakfastSingleton.getTotalCalories()));
            todaysBreakfastSingleton.setTotalCalories(todaysBreakfastSingleton.getTotalCalories() + currentIngredient.getCalories());
            Log.d("aftercal", Double.toString(todaysBreakfastSingleton.getTotalCalories()));

        } else {
            holder.imageViewAddItem.setImageResource(R.drawable.ic_ingredient_unchecked);

        }

        // Adding click listener to btn_add_item
        holder.imageViewAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the image state
                currentIngredient.setIngredientSelected(!currentIngredient.isIngredientSelected());
                // Notify the adapter that the data has changed to reflect the new image state
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredientModelList.size();
    }
    public static class IngredientViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewIngredientName;
        public TextView textViewCalories;
        public TextView textViewServingSize;
//        public FloatingActionButton buttonAdd;
        public ImageButton imageViewAddItem;
        public ImageButton imageViewFav;
        public CardView cardView;


        public IngredientViewHolder(View itemView) {
            super(itemView);
            textViewIngredientName = itemView.findViewById(R.id.textViewIngredientName);
            textViewCalories = itemView.findViewById(R.id.textViewCalories);
            textViewServingSize = itemView.findViewById(R.id.textViewServingSize);
            imageViewAddItem = itemView.findViewById(R.id.btn_add_item);
            imageViewFav = itemView.findViewById(R.id.breakfast_btn_add_to_favourite);
            cardView = itemView.findViewById(R.id.cardView); // Initialize CardView reference
        }
    }

}
