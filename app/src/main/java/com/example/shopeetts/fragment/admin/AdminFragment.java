package com.example.shopeetts.fragment.admin;

import android.view.View;
import android.widget.Toast;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.databinding.ActivityAdminBinding;

public class AdminFragment extends BaseFragment<ActivityAdminBinding,AdminViewModel> {

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

    @Override
    public void ViewCreated() {

    }

    private void event() {
        binding.cardCusstomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Click customer", Toast.LENGTH_SHORT).show();
                viewmodel.userDAL.getListAccount();
            }
        });
    }
}