package com.example.activitys.intefaces;

import com.example.activitys.models.Categories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriesApi {

    @GET("/v1/Armando/Categorias/showCategories")
    public Call<List<Categories>> showCategories();

}
