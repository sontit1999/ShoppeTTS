package com.example.shopeetts.fragment.register;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;

import com.example.shopeetts.R;
import com.example.shopeetts.api.RetrofitClient;
import com.example.shopeetts.api.ShoppeService;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.databinding.ActivityRegisterBinding;
import com.example.shopeetts.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends BaseFragment<ActivityRegisterBinding,RegisterViewModel> {

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

    }

    @Override
    public void ViewCreated() {
        event();
    }

    private void event() {

       binding.ivBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               getControler().popBackStack();
           }
       });
       binding.btnRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               RegisterAccount();
           }
       });
    }
    public void RegisterAccount(){
        String username = binding.edtUsername.getText().toString();
        String sdt = binding.edtPhone.getText().toString();
        String mk = binding.edtPass.getText().toString();
        String dc = binding.edtAddress.getText().toString();
        if(username.equals("")  || sdt.equals("") || mk.equals("") || dc.equals("")){
            Toast.makeText(getActivity(), "Không được bỏ trống!", Toast.LENGTH_SHORT).show();
        }else{
            ShoppeService shoppeService = RetrofitClient.getInstance(getContext()).create(ShoppeService.class);
            Call<String> call = shoppeService.Register(username,sdt,mk,"https://cdn.shopify.com/s/files/1/0267/2630/1768/products/design-your-own-sd-chibianime-characters-online-digital-drawing-class-digital-drawing-yuno-251928_800x.jpg?v=1591253641",dc);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.body().equalsIgnoreCase("succes")){
                        Toast.makeText(getActivity(), "Đăng kí thành công !", Toast.LENGTH_SHORT).show();
                        getControler().popBackStack();
                    }else{
                        Toast.makeText(getActivity(), "Số điện thoại đã dc sử dụng rùi  !", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(getActivity(), "Call api fail due to  " + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}
