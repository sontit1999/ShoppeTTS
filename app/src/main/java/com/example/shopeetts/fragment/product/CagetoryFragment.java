package com.example.shopeetts.fragment.product;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.databinding.FragCagetoryBinding;
import com.example.shopeetts.model.Cagetory;
import com.example.shopeetts.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CagetoryFragment extends BaseFragment<FragCagetoryBinding,CagetoryViewModel> {
    Cagetory cagetory = null;
    @Override
    public Class<CagetoryViewModel> getViewmodel() {
        return CagetoryViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_cagetory;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
        Bundle bundle  = getArguments();
        if(bundle!=null){
            cagetory = (Cagetory) bundle.getSerializable("type");
        }
    }

    @Override
    public void ViewCreated() {
         // set title
          binding.tvCagetory.setText(cagetory.getName());

          setUpPRoduct();
          viewmodel.getArrFlashSale().observe(this, new Observer<List<Product>>() {
              @Override
              public void onChanged(List<Product> products) {
                  viewmodel.productAdapter.setList((ArrayList<Product>) products);
              }
          });
          event();
    }

    private void event() {
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getControler().popBackStack();
            }
        });
    }

    private void setUpPRoduct() {
        binding.rvProduct.setAdapter(viewmodel.productAdapter);
        binding.rvProduct.setHasFixedSize(true);
        binding.rvProduct.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
    }
}
