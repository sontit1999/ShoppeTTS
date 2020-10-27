package com.example.shopeetts.fragment.cart;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.shopeetts.adapter.CartAdapter;
import com.example.shopeetts.adapter.ProductAdapter;
import com.example.shopeetts.api.RetrofitClient;
import com.example.shopeetts.api.ShoppeService;
import com.example.shopeetts.base.BaseViewmodel;
import com.example.shopeetts.model.Cart;
import com.example.shopeetts.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartViewmodel extends BaseViewmodel {
    CartAdapter cartAdapter = new CartAdapter();
    ProductAdapter productAdapter = new ProductAdapter();
    MutableLiveData<List<Cart>> arrCart = new MutableLiveData<>();
    MutableLiveData<List<Product>> arrProduct = new MutableLiveData<>();
    public MutableLiveData<List<Cart>> getArrCart() {

        List<Cart> list = new ArrayList<>();
        arrCart.postValue(list);

        return arrCart;
    }


    public MutableLiveData<List<Product>> getArrFlashSale(Context context) {
        ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
        Call<List<Product>> call = shoppeService.getRecomendProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                arrProduct.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(context, "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return arrProduct;
    }
}
