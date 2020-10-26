package com.example.shopeetts.fragment.profiles;

import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.databinding.FragProfileBinding;
import com.example.shopeetts.utils.Constant;

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
        // setData
        bindUser();
         event();
    }

    private void bindUser() {
       if(Constant.user!=null){
           binding.tvNameUsser.setText(Constant.user.getUsername());
           Glide.with(getContext()).load(Constant.user.getLinkavatar()).apply(new RequestOptions().override(500, 500)).into(binding.circleImageView);
       }
    }

    private void event() {
       binding.ivBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               getControler().popBackStack();
           }
       });
       binding.btnLogout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             getControler().navigate(R.id.action_profileFragment_to_LoginFragment);
           }
       });
       binding.ivChat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getActivity(), "Chat", Toast.LENGTH_SHORT).show();
           }
       });
    }
}
