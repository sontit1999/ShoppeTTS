package com.example.shopeetts.adapter;

import com.example.shopeetts.BR;
import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseAdapter;
import com.example.shopeetts.base.CBAdapter;
import com.example.shopeetts.callback.CagetoryCallback;
import com.example.shopeetts.databinding.ItemCagetoryBinding;
import com.example.shopeetts.model.Cagetory;

public class CagetoryAdapter extends BaseAdapter<Cagetory, ItemCagetoryBinding> {
    CagetoryCallback callback;
    public void setCallback(CagetoryCallback callback) {
        this.callback = callback;
    }
    @Override
    public int getLayoutId() {
        return R.layout.item_cagetory;
    }

    @Override
    public int getIdVariable() {
        return BR.cagetory;
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
