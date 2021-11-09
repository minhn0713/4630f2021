package com.example.new_world;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface API {

    // API KEY : ac10308a527948bfb3bf7b881ba67887
    @GET
    Call<Model> getAllNews(@Url String url);

    @GET
    Call<Model> getCategoryNews(@Url String url);
}
