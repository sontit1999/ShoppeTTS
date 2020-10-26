package com.example.shopeetts.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.shopeetts.R;
import com.example.shopeetts.api.RetrofitClient;
import com.example.shopeetts.api.ShoppeService;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.callback.CagetoryCallback;
import com.example.shopeetts.callback.FlashSaleCallback;
import com.example.shopeetts.databinding.FragHomeBinding;
import com.example.shopeetts.model.Cagetory;
import com.example.shopeetts.model.Product;
import com.example.shopeetts.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment<FragHomeBinding, HomesViewModel> {
    @Override
    public Class<HomesViewModel> getViewmodel() {
        return HomesViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_home;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
    }

    @Override
    public void ViewCreated() {
          setUpSlider();
          setUpCagetory();
          setUpFlashSale();
          setUpProduct();

//          // call API
           callApiGetData();

          viewmodel.getArrImageSlide().observe(this, new Observer<List<SliderItem>>() {
              @Override
              public void onChanged(List<SliderItem> sliderItems) {
                  viewmodel.adapterImage.setList(sliderItems);

              }
          });
          viewmodel.getArrCagetory().observe(this, new Observer<List<Cagetory>>() {
              @Override
              public void onChanged(final List<Cagetory> cagetories) {
                  viewmodel.cagetoryAdapter.setList((ArrayList<Cagetory>) cagetories);
                  viewmodel.cagetoryAdapter.setCallback(new CagetoryCallback() {
                      @Override
                      public void onCagetoryCLick(Cagetory cagetory) {
                          Bundle bundle = new Bundle();
                          bundle.putSerializable("type", cagetory);
                          getControler().navigate(R.id.action_HomeFragment_to_cagetoryFragment,bundle);
                      }
                  });
              }
          });
          viewmodel.getArrFlashSale().observe(this, new Observer<List<Product>>() {
              @Override
              public void onChanged(List<Product> products) {
                  viewmodel.flashSaleAdapter.setList((ArrayList<Product>) products);
                  viewmodel.flashSaleAdapter.setCallback(new FlashSaleCallback() {
                      @Override
                      public void onCLickProduct(Product product) {
                          Bundle bundle = new Bundle();
                          bundle.putSerializable("product", product);
                          getControler().navigate(R.id.action_HomeFragment_to_detailProductFragment,bundle);
                      }
                  });
                  Collections.shuffle(products);
                  viewmodel.productAdapter.setList((ArrayList<Product>) products);
                  viewmodel.productAdapter.setCallback(new FlashSaleCallback() {
                      @Override
                      public void onCLickProduct(Product product) {
                          Bundle bundle = new Bundle();
                          bundle.putSerializable("product", product);
                          getControler().navigate(R.id.action_HomeFragment_to_detailProductFragment,bundle);
                      }
                  });
              }
          });
          event();
    }

    private void callApiGetData() {
        ShoppeService shoppeService = RetrofitClient.getInstance(getContext()).create(ShoppeService.class);
        Call<List<Cagetory>> call = shoppeService.getCagetory();
        call.enqueue(new Callback<List<Cagetory>>() {
            @Override
            public void onResponse(Call<List<Cagetory>> call, Response<List<Cagetory>> response) {
                viewmodel.cagetoryAdapter.setList((ArrayList<Cagetory>) response.body());
                viewmodel.cagetoryAdapter.setCallback(new CagetoryCallback() {
                    @Override
                    public void onCagetoryCLick(Cagetory cagetory) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("type", cagetory);
                        getControler().navigate(R.id.action_HomeFragment_to_cagetoryFragment,bundle);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Cagetory>> call, Throwable t) {
                Toast.makeText(getActivity(), "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Call<List<Product>> call1 = shoppeService.getAllProduct();
        call1.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> arrProduct = response.body();
                viewmodel.flashSaleAdapter.setList((ArrayList<Product>) arrProduct);
                viewmodel.flashSaleAdapter.setCallback(new FlashSaleCallback() {
                    @Override
                    public void onCLickProduct(Product product) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        getControler().navigate(R.id.action_HomeFragment_to_detailProductFragment,bundle);
                    }
                });
                Collections.shuffle(arrProduct);
                viewmodel.productAdapter.setList((ArrayList<Product>) arrProduct);
                viewmodel.productAdapter.setCallback(new FlashSaleCallback() {
                    @Override
                    public void onCLickProduct(Product product) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        getControler().navigate(R.id.action_HomeFragment_to_detailProductFragment,bundle);
                    }
                });

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getActivity(), "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void event() {
           binding.tvMoreNewProduct.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Cagetory cagetory = new Cagetory("1","Flash sale","xx","xx");
                   Bundle bundle = new Bundle();
                   bundle.putSerializable("type", cagetory);
                   getControler().navigate(R.id.action_HomeFragment_to_cagetoryFragment,bundle);
               }
           });
           binding.tvMoreRecomend.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Cagetory cagetory = new Cagetory("1","Gợi ý","xx","xx");
                   Bundle bundle = new Bundle();
                   bundle.putSerializable("type", cagetory);
                   getControler().navigate(R.id.action_HomeFragment_to_cagetoryFragment,bundle);
               }
           });
           binding.ivSearch.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   getControler().navigate(R.id.action_HomeFragment_to_searchFragment);
               }
           });
           binding.ivCart.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   getControler().navigate(R.id.action_HomeFragment_to_cardFragment);
               }
           });
           binding.ivProfile.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   getControler().navigate(R.id.action_HomeFragment_to_profileFragment);
               }
           });
    }

    private void setUpProduct() {
        binding.rvRecomend.setAdapter(viewmodel.productAdapter);
        binding.rvRecomend.setHasFixedSize(true);
        binding.rvRecomend.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
    }

    private void setUpFlashSale() {
        binding.rvFlashSale.setAdapter(viewmodel.flashSaleAdapter);
        binding.rvFlashSale.setHasFixedSize(true);
        binding.rvFlashSale.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false));
    }

    private void setUpCagetory() {
        binding.rvCagetory.setAdapter(viewmodel.cagetoryAdapter);
        binding.rvCagetory.setHasFixedSize(true);
        binding.rvCagetory.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false));
    }

    private void setUpSlider() {
        binding.imageSlider.setSliderAdapter(viewmodel.adapterImage);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSlider.setScrollTimeInSec(4); //set scroll delay in seconds :
        binding.imageSlider.startAutoCycle();
    }
}
