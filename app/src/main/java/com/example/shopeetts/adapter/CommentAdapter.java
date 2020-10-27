package com.example.shopeetts.adapter;

import com.example.shopeetts.BR;
import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseAdapter;
import com.example.shopeetts.base.CBAdapter;
import com.example.shopeetts.databinding.ItemCommnetBinding;
import com.example.shopeetts.model.CommentResponse;

public class CommentAdapter extends BaseAdapter<CommentResponse, ItemCommnetBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.item_commnet;
    }

    @Override
    public int getIdVariable() {
        return BR.comment;
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
