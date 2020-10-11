package com.example.shopeetts.activity;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseActivity;
import com.example.shopeetts.databinding.ActivityRegisterBinding;
import com.example.shopeetts.model.User;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding,RegisterViewModel> {

    @Override
    public Class<RegisterViewModel> getViewmodel() {
        return RegisterViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_register;
    }

    @Override
    public void setBindingViewmodel() {
       binding.setViewmodel(viewmodel);
       event();
    }

    private void event() {
        viewmodel.getStatusRegister().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    finish();
                }
            }
        });

       binding.ivBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });
       binding.btnRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String sdt = binding.edtPhone.getText().toString();
               String mk = binding.edtPass.getText().toString();
               String mkAgain = binding.edtPass.getText().toString();
               String dc = binding.edtAddress.getText().toString();
               if(sdt.equals("") || mk.equals("") || mkAgain.equals("") || dc.equals("")){
                   Toast.makeText(RegisterActivity.this, "Không được bỏ trống!", Toast.LENGTH_SHORT).show();
               }else{
                   if(mk.equals(mkAgain)){
                       // đăng kí
                       User user = new User(sdt,mk,dc);
                       viewmodel.RegisterAccount(user,RegisterActivity.this);
                   }else{
                       Toast.makeText(RegisterActivity.this, "Mật khẩu không khớp !", Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });
    }
}