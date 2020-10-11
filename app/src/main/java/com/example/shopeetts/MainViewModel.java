package com.example.shopeetts;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.shopeetts.base.BaseViewmodel;
import com.example.shopeetts.model.User;
import com.example.shopeetts.utils.Constant;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainViewModel extends BaseViewmodel {
    MutableLiveData<Boolean> loginSuccess = new MutableLiveData<>(false);

    public MutableLiveData<Boolean> getLoginSuccess() {
        return loginSuccess;
    }

    public void Login(String phone, final String pass){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(Constant.nodeAccount);
        myRef.child(phone).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userResponse = snapshot.getValue(User.class);
                if(userResponse!=null){
                    if(userResponse.getMk().equals(pass)){
                        loginSuccess.postValue(true);
                    }else{
                        loginSuccess.postValue(false);
                    }
                }else{
                    loginSuccess.postValue(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
