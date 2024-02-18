package com.example.healthfriend.UserScreens.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthfriend.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {

    private List<Ingredient> ingredientList;
    RecyclerView recyclerView;
    private OnItemClickListener mListener;
//    private boolean isAddState = true;
//    public void setAddState(boolean isAddState) {
//        this.isAddState = isAddState;
//        notifyDataSetChanged(); // Notify adapter about the change
//    }

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onAddClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public void updateBackgroundColor(int position, int color) {
        // Update the background color of the CardView at the specified position
        IngredientViewHolder viewHolder = (IngredientViewHolder) recyclerView.findViewHolderForAdapterPosition(position);
        if (viewHolder != null) {
            viewHolder.cardView.setCardBackgroundColor(color);
        }
        notifyItemChanged(position);
    }

    public IngredientAdapter(List<Ingredient> ingredientList,  RecyclerView recyclerView) {
        this.ingredientList = ingredientList;
        this.recyclerView = recyclerView;
    }

    @Override
    public IngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingredient, parent, false);
        IngredientViewHolder vh = new IngredientViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(IngredientViewHolder holder, int position) {
        Ingredient currentItem = ingredientList.get(position);

        holder.textViewIngredientName.setText(currentItem.getIngredientName());
        holder.textViewCalories.setText(currentItem.getCalories() + "Kcal, ");
        holder.textViewServingSize.setText(currentItem.getServingSize());
//
//        if (isAddState) {
//            holder.cardView.setCardBackgroundColor(Color.WHITE);
//        } else {
//            holder.cardView.setCardBackgroundColor(Color.GREEN);
//        }
    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }
    public static class IngredientViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewIngredientName;
        public TextView textViewCalories;
        public TextView textViewServingSize;
        public FloatingActionButton buttonAdd;
        public CardView cardView;


        public IngredientViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            textViewIngredientName = itemView.findViewById(R.id.textViewIngredientName);
            textViewCalories = itemView.findViewById(R.id.textViewCalories);
            textViewServingSize = itemView.findViewById(R.id.textViewServingSize);
            buttonAdd = itemView.findViewById(R.id.buttonAdd);
            cardView = itemView.findViewById(R.id.cardView); // Initialize CardView reference


            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onAddClick(position);
                        }
                    }
                }
            });

            // Set click listener for the CardView
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
