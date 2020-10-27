package com.example.shopeetts.fragment.detail;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.shopeetts.adapter.CommentAdapter;
import com.example.shopeetts.api.RetrofitClient;
import com.example.shopeetts.api.ShoppeService;
import com.example.shopeetts.base.BaseViewmodel;
import com.example.shopeetts.model.CommentResponse;
import com.example.shopeetts.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailProductViewModel extends BaseViewmodel {
    CommentAdapter commentAdapter = new CommentAdapter();
    MutableLiveData<List<CommentResponse>> arrComment = new MutableLiveData<List<CommentResponse>>();

    public MutableLiveData<List<CommentResponse>> getArrComment(Context context,int id) {
        ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
        Call<List<CommentResponse>> call = shoppeService.getCommentProductByID(id);
        call.enqueue(new Callback<List<CommentResponse>>() {
            @Override
            public void onResponse(Call<List<CommentResponse>> call, Response<List<CommentResponse>> response) {
                arrComment.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CommentResponse>> call, Throwable t) {
                Toast.makeText(context, "Lỗi call APi " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return arrComment;
    }
}
