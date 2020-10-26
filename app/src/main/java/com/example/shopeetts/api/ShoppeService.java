package com.example.shopeetts.api;

import com.example.shopeetts.model.Cagetory;
import com.example.shopeetts.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ShoppeService {
      // get danh mục
      @GET("getCagetory.php")
      Call<List<Cagetory>> getCagetory();
      // get all san pham
      @GET("getProduct.php")
      Call<List<Product>> getAllProduct();
      // get all san pham theo type
      @GET("getProductByType.php")
      Call<List<Product>> getProductByType(@Query("idtype") int idtype);
}
