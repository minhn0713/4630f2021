package com.example.new_world;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface API {

    // API KEY : 77bab70f038d411583882e4711138d78
    @GET
    Call<Model> getAllNews(@Url String url);

    @GET
    Call<Model> getCategoryNews(@Url String url);

    @GET
    Call<Model> getHotNews(@Url String url);

    @GET
    Call<Model> getRegularNews(@Url String url);


}
