package com.example.news_app;

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

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.ViewHolder> {

    //Step20: create the variables
    private ArrayList<CategoryRVModal> categoryRVModals;
    private Context context;
    private CategoryClickInterface categoryClickInterface; //create variable for interface

    //Step21: create the constructor
    public CategoryRVAdapter(ArrayList<CategoryRVModal> categoryRVModals, Context context, CategoryClickInterface categoryClickInterface) {
        this.categoryRVModals = categoryRVModals;
        this.context = context;
        this.categoryClickInterface = categoryClickInterface;
    }

    @NonNull
    @Override
    public CategoryRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Step22: create the viewHolder and link with the categories_rv_item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item,parent,false);
        return new CategoryRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRVAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //Step26: setting the data on BindViewHolder method
        CategoryRVModal categoryRVModal = categoryRVModals.get(position);
        holder.categoryTV.setText(categoryRVModal.getCategory());
        Picasso.get().load(categoryRVModal.getCategoryImageUrl()).into(holder.categoryIV);
        //Step27: setOnclicklistener , when the user click the item, we will pass the position
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryClickInterface.onCategoryClick(position);
            }
            //Step28: go to mainActivity.java
        });
    }

    @Override
    public int getItemCount() {
        return categoryRVModals.size(); // return the size of arrayList
    }

    //Step23:Create interface update the data when clicking on the category item,
    //for example: clicking on the technology item, the news below will be refreshed to technology
    //so we need onClickListener for RecycleView as well, since we operating this activity in mainActivity.java file.
    //Therefore, we will need to create an interface for onClickListener
    public interface CategoryClickInterface{
        //the purpose of following method is for using in mainActivity for change the data of category clicked
        //will passing the position, which will be used to get the data from arrayList
        void onCategoryClick(int position);
    }

    //Step18 : inner class extends RecyclerView.ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        //Step24:create variable to load categories_rv_item
        private TextView categoryTV;
        private ImageView categoryIV;

        //Step19: create the constructor class
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Step25: initialize the variable with the id
            categoryTV = itemView.findViewById(R.id.idTVCategories);
            categoryIV = itemView.findViewById(R.id.idIVCategory);

        }
    }
}
