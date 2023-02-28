package com.example.myapplication.util;

import com.example.myapplication.service.ProductApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static  RetrofitClient instance =  null;
    private Retrofit retrofit;
    private ProductApiService apiService;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder().baseUrl("https://fakestoreapi.com/").addConverterFactory(GsonConverterFactory.create()).build();
        apiService = retrofit.create(ProductApiService.class);
    }
    public  static synchronized RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }
        return  instance;
    }

    public ProductApiService getApiService(){ return apiService; }

}
