package com.example.healthfriend.UserScreens.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthfriend.R;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {

    private List<Ingredient> ingredientList;
    RecyclerView recyclerView;

    public IngredientAdapter(List<Ingredient> ingredientList,  RecyclerView recyclerView) {
        this.ingredientList = ingredientList;
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
        Ingredient currentItem = ingredientList.get(position);

        holder.textViewIngredientName.setText(currentItem.getIngredientName());
        holder.textViewCalories.setText(currentItem.getCalories() + "Kcal, ");
        holder.textViewServingSize.setText(currentItem.getServingSize());

        if (currentItem.isIngredientSelected()) {
            holder.imageViewAddItem.setImageResource(R.drawable.ic_ingredient_check_green);

        } else {
            holder.imageViewAddItem.setImageResource(R.drawable.ic_ingredient_unchecked);

        }

        // Adding click listener to btn_add_item
        holder.imageViewAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the image state
                currentItem.setIngredientSelected(!currentItem.isIngredientSelected());
                // Notify the adapter that the data has changed to reflect the new image state
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
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
            imageViewFav = itemView.findViewById(R.id.btn_add_to_favourite);
            cardView = itemView.findViewById(R.id.cardView); // Initialize CardView reference
        }
    }

}
