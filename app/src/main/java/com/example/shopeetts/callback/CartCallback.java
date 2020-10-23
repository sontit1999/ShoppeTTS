package com.example.shopeetts.callback;

import com.example.shopeetts.base.CBAdapter;
import com.example.shopeetts.model.Cart;

public interface CartCallback extends CBAdapter {
    void onCartClick(Cart cart);
}
