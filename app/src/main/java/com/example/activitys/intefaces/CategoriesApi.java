package com.example.activitys.intefaces;

import com.example.activitys.models.Categories;
import com.example.activitys.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoriesApi {

    @GET("/v1/Armando/Categorias/showCategories")
    public Call<List<Categories>> showCategories();

    @GET("/v1/Armando/Categorias/getCategories/{categoria}")
    public Call<List<User>> getCategorias(@Path("categoria") String categoria);

}
