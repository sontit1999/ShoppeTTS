package com.example.shopeetts.fragment;

import android.graphics.Color;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.databinding.FragHomeBinding;
import com.example.shopeetts.model.Cagetory;
import com.example.shopeetts.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

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
          viewmodel.getArrImageSlide().observe(this, new Observer<List<SliderItem>>() {
              @Override
              public void onChanged(List<SliderItem> sliderItems) {
                  viewmodel.adapterImage.setList(sliderItems);
              }
          });
          viewmodel.getArrCagetory().observe(this, new Observer<List<Cagetory>>() {
              @Override
              public void onChanged(List<Cagetory> cagetories) {
                  viewmodel.cagetoryAdapter.setList((ArrayList<Cagetory>) cagetories);
              }
          });
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
