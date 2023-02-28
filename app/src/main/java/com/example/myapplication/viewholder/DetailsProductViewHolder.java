package com.example.myapplication.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Panier;
import com.example.myapplication.model.Product;

public class DetailsProductViewHolder extends RecyclerView.ViewHolder {

    private Fragment _fragment;
    private TextView productDetailsName;
    private TextView productDetailsPrice;
    private ImageView productDetailsImage;
    private TextView productDetailsDescription ;
    private TextView productDetailsCategory;
    private TextView productDetailsRating;

    private View view;


    public DetailsProductViewHolder(@NonNull View itemView) {
        super(itemView);
        productDetailsName = itemView.findViewById(R.id.productdetails_item_productName);
        productDetailsPrice = itemView.findViewById(R.id.productdetails_item_productPrice);
        productDetailsImage = itemView.findViewById(R.id.productdetails_item_productImage);
        productDetailsDescription = itemView.findViewById(R.id.productdetails_item_productDescription);
        productDetailsCategory = itemView.findViewById(R.id.productdetails_item_productCategory);
        productDetailsRating = itemView.findViewById(R.id.productdetails_item_productRating);
        view = itemView;

    }
    public DetailsProductViewHolder(@NonNull View itemView, Fragment fragment) {
        this(itemView);
        _fragment = fragment;

    }
  public void display(Product product){
        productDetailsName.setText(product.getTitle());
        productDetailsPrice.setText(String.valueOf(product.getPrice()));
        productDetailsDescription.setText(product.getDescription());
        productDetailsCategory.setText(product.getCategory());
        productDetailsRating.setText(String.valueOf(product.getRating()));
  }
  public static ProductViewHolder create(ViewGroup parent, Fragment fragment){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_product_item,parent,false);
        return   new ProductViewHolder(view,fragment);
    }
}
