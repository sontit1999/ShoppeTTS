package com.example.shopeetts.api;

import com.example.shopeetts.model.Cagetory;
import com.example.shopeetts.model.Product;
import com.example.shopeetts.model.UserResponse;

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
      // get recomend san pham
      @GET("getProductRecomend.php")
      Call<List<Product>> getRecomendProduct();
      // get san pham sale
      @GET("getProductSale.php")
      Call<List<Product>> getSaleProduct();
      // get all san pham theo type
      @GET("getProductByType.php")
      Call<List<Product>> getProductByType(@Query("idtype") int idtype);
      // login
      @GET("login.php")
      Call<UserResponse> CheckLogin(@Query("sdt") String sdt, @Query("pass") String pass);
      // register
      @GET("register.php")
      Call<String> Register(@Query("username") String username,@Query("sdt") String sdt,@Query("password") String password,@Query("linkavatar") String linkavatar,@Query("address") String address);
}
