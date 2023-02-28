package com.example.myapplication.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.myapplication.model.Product;
import com.example.myapplication.viewholder.ProductViewHolder;

public class ProductAdapter extends ListAdapter<Product, ProductViewHolder> {

    private Fragment _fragment;

    public ProductAdapter(@NonNull DiffUtil.ItemCallback<Product> diffCallback, Fragment fragment) {
        this(diffCallback);
        _fragment = fragment;
    }

    protected ProductAdapter(@NonNull DiffUtil.ItemCallback<Product> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ProductViewHolder.create(parent,_fragment);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = getItem(position);
        holder.display(product);
    }

    public static  class ProductDiff extends  DiffUtil.ItemCallback<Product>{

        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return false;
        }
    }

}
