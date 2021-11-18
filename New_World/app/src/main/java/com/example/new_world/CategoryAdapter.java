package com.example.new_world;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<CategoryTypes> categoryTypes;
    private Context context;
    private CategoryClickedInterface categoryClickedInterface;

    public CategoryAdapter(ArrayList<CategoryTypes> categoryTypes, Context context, CategoryClickedInterface categoryClickedInterface) {
        this.categoryTypes = categoryTypes;
        this.context = context;
        this.categoryClickedInterface = categoryClickedInterface;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_category_types,parent,false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CategoryTypes categoryType = categoryTypes.get(position);
        holder.categoryTV.setText(categoryType.getCategory());
        Picasso.get().load(categoryType.getImageUrlCategory()).into(holder.categoryIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryClickedInterface.onCategoryClickLister(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryTypes.size();
    }

    //--Create Interface since we need to refresh the main screen when user clicked on the category
    //The reason why we need to pass position is that we need to get the data from arrayList,
    //Hence, the position will indicate the index of the arrayList
    public interface CategoryClickedInterface{
        void onCategoryClickLister(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView categoryTV;
        private ImageView categoryIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTV = itemView.findViewById(R.id.categoryTypes_TV);
            categoryIV = itemView.findViewById(R.id.categoryTypes_IV);
        }
    }
}
