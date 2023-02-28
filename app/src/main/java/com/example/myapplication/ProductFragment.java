package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.databinding.FragmentProductBinding;
import com.example.myapplication.model.Product;
import com.example.myapplication.util.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductFragment extends Fragment {

    private ProductAdapter productAdapter;

    private FragmentProductBinding binding;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance){
        productAdapter =  new ProductAdapter(new ProductAdapter.ProductDiff(),ProductFragment.this);
        binding.productsRecyclerview.setAdapter(productAdapter);
        binding.productsRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.productsRecyclerview.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        RetrofitClient.getInstance().getApiService().getProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> products = response.body();
                productAdapter.submitList(products);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }
}