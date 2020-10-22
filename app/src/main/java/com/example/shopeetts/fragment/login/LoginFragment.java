package com.example.shopeetts.fragment.login;

import androidx.lifecycle.Observer;

import android.view.View;
import android.widget.Toast;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.databinding.ActivityMainBinding;

public class LoginFragment extends BaseFragment<ActivityMainBinding, LoginViewModel> {

    @Override
    public Class<LoginViewModel> getViewmodel() {
        return LoginViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void setBindingViewmodel() {
          binding.setViewmodel(viewmodel);

    }

    @Override
    public void ViewCreated() {
        event();
    }

    private void event() {
        viewmodel.getLoginSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    getControler().navigate(R.id.action_LoginFragment_to_HomeFragment);
                }else{
                    Toast.makeText(getContext(), "Login fail !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getControler().navigate(R.id.action_LoginFragment_to_RegisterFragment);
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdt = binding.edtPhone.getText().toString();
                String pass = binding.edtPass.getText().toString();
                if(sdt.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")){
                    getControler().navigate(R.id.action_LoginFragment_to_adminFragment);
                }else{
                    viewmodel.Login(sdt,pass);
                }
            }
        });
    }


}