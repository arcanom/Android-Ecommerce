package com.example.myapplication.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Product;
import com.example.myapplication.service.DetailsProductService;
import com.example.myapplication.service.PanierService;


public class ProductViewHolder extends RecyclerView.ViewHolder {

    private Fragment _fragment;
    private TextView productName;
    private TextView productPrice;
    private ImageView productImage;
    private Button addPanier;

    private Button detailsProduct;

    private View view;

    private PanierService panierService;

    private DetailsProductService detailsProductService;


    public ProductViewHolder(@NonNull View itemView,Fragment fragment) {
        this(itemView);
        _fragment = fragment;
        panierService =  new PanierService();
    }
    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.product_item_productName);
        productPrice = itemView.findViewById(R.id.product_item_productPrice);
        productImage =  itemView.findViewById(R.id.product_item_productImage);
        addPanier = itemView.findViewById(R.id.addPanier);
        detailsProduct =  itemView.findViewById(R.id.product_details);
        view = itemView;
    }

    public void display(Product product){
        productName.setText(product.getTitle());
        productPrice.setText((String.valueOf(product.getPrice())));
        addPanier.setOnClickListener((e)->{
         panierService.addProductInPanier(product);

        });
        detailsProduct.setOnClickListener((e) ->{
            detailsProductService.detailProduct(product.getId());
        });
    }

    public static ProductViewHolder create(ViewGroup parent, Fragment fragment){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        return  new ProductViewHolder(view,fragment);
    }

}
