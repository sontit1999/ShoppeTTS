package com.example.shopeetts.activity.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseActivity;
import com.example.shopeetts.databinding.ActivityHomeBinding;

public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeViewModel> {

    @Override
    public Class<HomeViewModel> getViewmodel() {
        return HomeViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    public void setBindingViewmodel() {
         binding.setViewmodel(viewmodel);
    }
}