package com.example.shopeetts.activity.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseActivity;
import com.example.shopeetts.databinding.ActivityAdminBinding;

public class AdminActivity extends BaseActivity<ActivityAdminBinding,AdminViewModel> {

    @Override
    public Class<AdminViewModel> getViewmodel() {
        return AdminViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_admin;
    }

    @Override
    public void setBindingViewmodel() {
         binding.setViewmodel(viewmodel);
         event();
    }

    private void event() {
        binding.cardCusstomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminActivity.this, "Click customer", Toast.LENGTH_SHORT).show();
                viewmodel.userDAL.getListAccount();
            }
        });
    }
}