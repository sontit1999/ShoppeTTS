package com.example.shopeetts.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.shopeetts.R;
import com.example.shopeetts.adapter.CagetoryAdapter;
import com.example.shopeetts.adapter.FlashSaleAdapter;
import com.example.shopeetts.adapter.ProductAdapter;
import com.example.shopeetts.adapter.SliderAdapterImage;
import com.example.shopeetts.api.RetrofitClient;
import com.example.shopeetts.api.ShoppeService;
import com.example.shopeetts.base.BaseViewmodel;
import com.example.shopeetts.callback.CagetoryCallback;
import com.example.shopeetts.model.Cagetory;
import com.example.shopeetts.model.Product;
import com.example.shopeetts.model.SliderItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomesViewModel extends BaseViewmodel {
    SliderAdapterImage adapterImage = new SliderAdapterImage();
    CagetoryAdapter cagetoryAdapter = new CagetoryAdapter();
    FlashSaleAdapter flashSaleAdapter = new FlashSaleAdapter();
    ProductAdapter productAdapter = new ProductAdapter();
    MutableLiveData<List<SliderItem>> arrImageSlide = new MutableLiveData<>();
    MutableLiveData<List<Cagetory>> arrCagetory = new MutableLiveData<>();


    MutableLiveData<List<Product>> arrFlashSale = new MutableLiveData<>();



    MutableLiveData<List<Product>> arrRecomendProduct = new MutableLiveData<>();
    public MutableLiveData<List<Product>> getArrRecomendProduct(Context context) {
        ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
        Call<List<Product>> call = shoppeService.getRecomendProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                arrRecomendProduct.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(context, "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return arrRecomendProduct;
    }
    public MutableLiveData<List<Product>> getArrFlashSale(Context context) {

        ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
        Call<List<Product>> call = shoppeService.getSaleProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                arrFlashSale.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(context, "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return arrFlashSale;
    }

    public MutableLiveData<List<SliderItem>> getArrImageSlide() {
        List<SliderItem> list = new ArrayList<>();
        list.add(new SliderItem("https://cf.shopee.vn/file/67e108f93ec4f9caa5fe4fb1853fc7e9"));
        list.add(new SliderItem("https://magiamgiashopee.com/wp-content/uploads/2020/02/shopee-sieu-sale-11-11-1024x535-1.jpg"));
        list.add(new SliderItem("https://magiamgiashopee.vn/wp-content/uploads/2019/07/Si%C3%AAu-Sale-Freeship-Shopee.png.webp"));
        list.add(new SliderItem("https://cdn.chanhtuoi.com/uploads/2019/10/11-11-shopee-sieu-sale-01.jpg"));
        list.add(new SliderItem("https://muaodau.pro/wp-content/uploads/2019/11/shopee_02.11_3.jpg"));
        list.add(new SliderItem("https://saigonbiz.com.vn/wp-content/uploads/2018/11/Dai-tiec-mua-sam-lazada.jpg"));
        list.add(new SliderItem("https://bloggiamgia.vn/wp-content/uploads/2018/10/Lazada-khuy%E1%BA%BFn-m%C3%A3i-11-11.png.webp"));
        arrImageSlide.postValue(list);
        return arrImageSlide;
    }
    public MutableLiveData<List<Cagetory>> getArrCagetory(Context context) {
        ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
        Call<List<Cagetory>> call = shoppeService.getCagetory();
        call.enqueue(new Callback<List<Cagetory>>() {
            @Override
            public void onResponse(Call<List<Cagetory>> call, Response<List<Cagetory>> response) {
               arrCagetory.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Cagetory>> call, Throwable t) {
                Toast.makeText(context, "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return arrCagetory;
    }

}
