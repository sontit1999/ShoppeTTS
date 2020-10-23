package com.example.shopeetts.fragment.search;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.callback.FlashSaleCallback;
import com.example.shopeetts.databinding.FragSearchBinding;
import com.example.shopeetts.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends BaseFragment<FragSearchBinding,SearchViewModel> {
    @Override
    public Class<SearchViewModel> getViewmodel() {
        return SearchViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_search;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
    }

    @Override
    public void ViewCreated() {
          setupRecyclerViewSearch();
          viewmodel.getArrFlashSale().observe(this, new Observer<List<Product>>() {
              @Override
              public void onChanged(List<Product> products) {
                  viewmodel.productAdapter.setList((ArrayList<Product>) products);
              }
          });
          viewmodel.productAdapter.setCallback(new FlashSaleCallback() {
              @Override
              public void onCLickProduct(Product product) {
                  Toast.makeText(getActivity(), "Click " + product.getName(), Toast.LENGTH_SHORT).show();
              }
          });
          event();
    }

    private void event() {
       binding.btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               getControler().popBackStack();
           }
       });
    }

    private void setupRecyclerViewSearch() {
        binding.rvProduct.setAdapter(viewmodel.productAdapter);
        binding.rvProduct.setHasFixedSize(true);
        binding.rvProduct.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
    }
}
