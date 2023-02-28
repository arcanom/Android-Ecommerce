package com.example.myapplication.service;

import android.hardware.camera2.CameraManager;

import com.example.myapplication.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductApiService {

    @GET("products")
    public Call<List<Product>> getProducts();

    @GET("products/{id}")
    public  Call<Product> getProductById(@Path("id") int id);
}
