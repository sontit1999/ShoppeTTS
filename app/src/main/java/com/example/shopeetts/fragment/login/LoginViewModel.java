package com.example.shopeetts.fragment.login;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.shopeetts.api.RetrofitClient;
import com.example.shopeetts.api.ShoppeService;
import com.example.shopeetts.base.BaseViewmodel;
import com.example.shopeetts.model.Cagetory;
import com.example.shopeetts.model.User;
import com.example.shopeetts.model.UserResponse;
import com.example.shopeetts.utils.Constant;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends BaseViewmodel {
    MutableLiveData<Boolean> loginSuccess = new MutableLiveData<>();

    public MutableLiveData<Boolean> getLoginSuccess() {
        return loginSuccess;
    }

    public void Login(Context context, String phone, final String pass){
        ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
        Call<UserResponse> call = shoppeService.CheckLogin(phone,pass);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.body().getStatus().equals("success")){
                    loginSuccess.postValue(true);
                    Constant.user = response.body();
                }else{
                    loginSuccess.postValue(false);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(context, "call api Fail due to " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
