package com.example.shopeetts.fragment.viewlike;

import androidx.lifecycle.MutableLiveData;

import com.example.shopeetts.adapter.ProductViewAdapter;
import com.example.shopeetts.base.BaseViewmodel;
import com.example.shopeetts.model.ProductView;

import java.util.List;

public class ViewLikeViewmodel extends BaseViewmodel {
   ProductViewAdapter productViewAdapter = new ProductViewAdapter();
   MutableLiveData<List<ProductView>> arrViewd = new MutableLiveData<>();

    public MutableLiveData<List<ProductView>> getArrViewd() {
        return arrViewd;
    }
    public void setListView(List<ProductView> list){
        arrViewd.postValue(list);
    }
}
