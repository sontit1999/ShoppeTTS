package com.example.shopeetts.adapter;

import com.example.shopeetts.BR;
import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseAdapter;
import com.example.shopeetts.base.CBAdapter;
import com.example.shopeetts.callback.CartCallback;
import com.example.shopeetts.databinding.ItemCartBinding;
import com.example.shopeetts.model.Cart;

public class CartAdapter extends BaseAdapter<Cart, ItemCartBinding> {
    CartCallback cartCallback;

    public void setCartCallback(CartCallback cartCallback) {
        this.cartCallback = cartCallback;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_cart;
    }

    @Override
    public int getIdVariable() {
        return BR.cart;
    }

    @Override
    public int getIdVariableOnclick() {
        return BR.callback;
    }

    @Override
    public CBAdapter getOnclick() {
        return cartCallback;
    }
}
