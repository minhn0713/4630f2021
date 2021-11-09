package com.example.new_world;

public class CategoryTypes {
    private String category;
    private String imageUrlCategory;

    public CategoryTypes(String category, String imageUrlCategory) {
        this.category = category;
        this.imageUrlCategory = imageUrlCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrlCategory() {
        return imageUrlCategory;
    }

    public void setImageUrlCategory(String imageUrlCategory) {
        this.imageUrlCategory = imageUrlCategory;
    }
}
