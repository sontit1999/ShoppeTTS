package com.example.shopeetts.callback;

import com.example.shopeetts.base.CBAdapter;
import com.example.shopeetts.model.Product;

public interface FlashSaleCallback extends CBAdapter {
    void onCLickProduct(Product product);
}
