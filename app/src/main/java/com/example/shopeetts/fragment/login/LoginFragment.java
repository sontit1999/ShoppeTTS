package com.example.shopeetts.fragment.login;

import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.shopeetts.R;
import com.example.shopeetts.api.RetrofitClient;
import com.example.shopeetts.api.ShoppeService;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.databinding.ActivityMainBinding;
import com.example.shopeetts.model.UserResponse;
import com.example.shopeetts.utils.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                if(sdt.equals("") || pass.equals("")){
                    Toast.makeText(getActivity(), "Phải nhập đủ thông tin để login!!", Toast.LENGTH_SHORT).show();
                }else{
                    if(sdt.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")){
                        getControler().navigate(R.id.action_LoginFragment_to_adminFragment);
                    }else{
                        ShoppeService shoppeService = RetrofitClient.getInstance(getContext()).create(ShoppeService.class);
                        Call<UserResponse> call = shoppeService.CheckLogin(sdt,pass);
                        call.enqueue(new Callback<UserResponse>() {
                            @Override
                            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                                if(response.body().getStatus().equals("success")){
                                    Constant.user = response.body();
                                    getControler().navigate(R.id.action_LoginFragment_to_HomeFragment);
                                }else{
                                    Toast.makeText(getActivity(), "Tài khoản hoặc mật khẩu không chính xác!!!", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<UserResponse> call, Throwable t) {
                                Toast.makeText(getActivity(), "call api Fail due to " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }

            }
        });

    }


}