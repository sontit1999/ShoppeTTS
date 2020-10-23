package com.example.shopeetts.adapter;

import com.example.shopeetts.BR;
import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseAdapter;
import com.example.shopeetts.base.CBAdapter;
import com.example.shopeetts.callback.FlashSaleCallback;
import com.example.shopeetts.databinding.ItemFlashsaleBinding;
import com.example.shopeetts.model.Product;

public class FlashSaleAdapter extends BaseAdapter<Product, ItemFlashsaleBinding> {

    FlashSaleCallback callback;
    public void setCallback(FlashSaleCallback callback) {
        this.callback = callback;
    }
    @Override
    public int getLayoutId() {
        return R.layout.item_flashsale;
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
