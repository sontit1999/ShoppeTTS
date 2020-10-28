package com.example.shopeetts.adapter;

import com.example.shopeetts.BR;
import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseAdapter;
import com.example.shopeetts.base.CBAdapter;
import com.example.shopeetts.databinding.ItemViewedBinding;
import com.example.shopeetts.model.ProductView;

public class ProductViewAdapter extends BaseAdapter<ProductView, ItemViewedBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.item_viewed;
    }

    @Override
    public int getIdVariable() {
        return BR.productview;
    }

    @Override
    public int getIdVariableOnclick() {
        return 0;
    }

    @Override
    public CBAdapter getOnclick() {
        return null;
    }
}
