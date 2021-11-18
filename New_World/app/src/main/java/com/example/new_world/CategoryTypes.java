package com.example.new_world;

//---------  Create category class for recycleView category

public class CategoryTypes {

    //Two importants properties are needed for render the image and title of category
    private String category;
    private String imageUrlCategory;

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

    public CategoryTypes(String category, String imageUrlCategory) {
        this.category = category;
        this.imageUrlCategory = imageUrlCategory;
    }
}
