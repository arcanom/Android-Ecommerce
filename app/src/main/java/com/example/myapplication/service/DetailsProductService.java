package com.example.myapplication.service;

import com.example.myapplication.model.Product;

public class DetailsProductService  {
    private static int id;

    public void detailProduct(int  newId){
        id =  newId;
    }

    public  int getDetailProduct(){return id;}
}
