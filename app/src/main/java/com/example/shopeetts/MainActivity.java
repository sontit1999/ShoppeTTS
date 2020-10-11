package com.example.shopeetts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shopeetts.activity.RegisterActivity;
import com.example.shopeetts.activity.admin.AdminActivity;
import com.example.shopeetts.activity.home.HomeActivity;
import com.example.shopeetts.base.BaseActivity;
import com.example.shopeetts.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> {

    @Override
    public Class<MainViewModel> getViewmodel() {
        return MainViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void setBindingViewmodel() {
          binding.setViewmodel(viewmodel);
          event();
    }

    private void event() {
        viewmodel.getLoginSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Login fail !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdt = binding.edtPhone.getText().toString();
                String pass = binding.edtPass.getText().toString();
                if(sdt.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")){
                    Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                    startActivity(intent);
                }else{
                    viewmodel.Login(sdt,pass);
                }
            }
        });
    }


}