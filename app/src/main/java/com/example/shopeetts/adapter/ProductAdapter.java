package com.example.shopeetts.adapter;

import androidx.databinding.library.baseAdapters.BR;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseAdapter;
import com.example.shopeetts.base.CBAdapter;
import com.example.shopeetts.callback.FlashSaleCallback;
import com.example.shopeetts.databinding.ItemProductBinding;
import com.example.shopeetts.model.Product;

public class ProductAdapter extends BaseAdapter<Product, ItemProductBinding> {
   FlashSaleCallback callback;

    public void setCallback(FlashSaleCallback callback) {
        this.callback = callback;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_product;
    }

    @Override
    public int getIdVariable() {
        return BR.product;
    }

    @Override
    public int getIdVariableOnclick() {
        return BR.callback;
    }

    @Override
    public CBAdapter getOnclick() {
        return callback;
    }
}
