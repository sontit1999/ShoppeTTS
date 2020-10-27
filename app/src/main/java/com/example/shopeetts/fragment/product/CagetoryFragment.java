package com.example.shopeetts.fragment.product;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.shopeetts.R;
import com.example.shopeetts.api.RetrofitClient;
import com.example.shopeetts.api.ShoppeService;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.callback.FlashSaleCallback;
import com.example.shopeetts.databinding.FragCagetoryBinding;
import com.example.shopeetts.model.Cagetory;
import com.example.shopeetts.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
          binding.tvCagetory.setText(cagetory.getNametype());

          setUpPRoduct();
          event();
          // call api
          callAPI();
    }

    private void callAPI() {
        if(cagetory.getIdtype().equalsIgnoreCase("888")){
            ShoppeService shoppeService = RetrofitClient.getInstance(getContext()).create(ShoppeService.class);
            Call<List<Product>> call = shoppeService.getAllSaleProduct();
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    viewmodel.productAdapter.setList((ArrayList<Product>) response.body());
                    viewmodel.productAdapter.setCallback(new FlashSaleCallback() {
                        @Override
                        public void onCLickProduct(Product product) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("product", product);
                            getControler().navigate(R.id.action_cagetoryFragment_to_detailProductFragment,bundle);
                        }
                    });
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {

                }
            });
        }else if(cagetory.getIdtype().equalsIgnoreCase("999")){
            ShoppeService shoppeService = RetrofitClient.getInstance(getContext()).create(ShoppeService.class);
            Call<List<Product>> call = shoppeService.getAllRecomendProduct();
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    viewmodel.productAdapter.setList((ArrayList<Product>) response.body());
                    viewmodel.productAdapter.setCallback(new FlashSaleCallback() {
                        @Override
                        public void onCLickProduct(Product product) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("product", product);
                            getControler().navigate(R.id.action_cagetoryFragment_to_detailProductFragment,bundle);
                        }
                    });
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {

                }
            });
        }else{
            ShoppeService shoppeService = RetrofitClient.getInstance(getContext()).create(ShoppeService.class);
            Call<List<Product>> call = shoppeService.getProductByType(Integer.parseInt(cagetory.getIdtype()));
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    viewmodel.productAdapter.setList((ArrayList<Product>) response.body());
                    viewmodel.productAdapter.setCallback(new FlashSaleCallback() {
                        @Override
                        public void onCLickProduct(Product product) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("product", product);
                            getControler().navigate(R.id.action_cagetoryFragment_to_detailProductFragment,bundle);
                        }
                    });
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    Toast.makeText(getActivity(), "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
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
