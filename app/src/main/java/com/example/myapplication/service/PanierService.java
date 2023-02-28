package com.example.myapplication.service;

import com.example.myapplication.model.Panier;
import com.example.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class PanierService {
    private static List<Panier> panier = new ArrayList<>();

    private static int count = 0;

    private int newCount;

    private boolean isNewProduct=true ;

    public void addProductInPanier(Product product){
        for( Panier p : panier){
            if(p.getProduct().getId() == product.getId()){
                newCount = p.getCount() + 1;
                p.setCount(newCount);
                isNewProduct = false;
                break;
            }
        }
        if(isNewProduct){
            Panier panier1 = new Panier(++count,product,1);
            panier.add(panier1);
        }
    }

    public List<Panier> getPanier(){return panier;}

}
