package com.example.myapplication.model;

public class Panier {

    private int id;
    private Product product;

    private int count;

    public Panier(int id,Product product, int count) {
        this.id = id;
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
