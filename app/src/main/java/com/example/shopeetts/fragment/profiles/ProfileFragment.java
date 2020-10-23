package com.example.shopeetts.fragment.profiles;

import android.view.View;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.databinding.FragProfileBinding;

public class ProfileFragment extends BaseFragment<FragProfileBinding, ProfilesViewModel> {
    @Override
    public Class<ProfilesViewModel> getViewmodel() {
        return ProfilesViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_profile;
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
    }
}
