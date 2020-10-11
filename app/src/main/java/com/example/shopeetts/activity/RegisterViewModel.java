package com.example.shopeetts.activity;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.shopeetts.base.BaseViewmodel;
import com.example.shopeetts.model.User;
import com.example.shopeetts.utils.Constant;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterViewModel extends BaseViewmodel {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference(Constant.nodeAccount);
    MutableLiveData<Boolean> statusRegister = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> getStatusRegister() {
        return statusRegister;
    }
    public void RegisterAccount(final User user,final Context context){

        myRef.child(user.getSdt()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userResponse = snapshot.getValue(User.class);
                if(userResponse!=null){
                    Toast.makeText(context, "Đã có người dùng số điện thoại này rùi !!!", Toast.LENGTH_SHORT).show();
                }else{
                    myRef.child(user.getSdt()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(context, "Đăng kí thành công !!!", Toast.LENGTH_SHORT).show();
                            statusRegister.postValue(true);
                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
