package com.example.shopeetts.fragment.viewlike;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.databinding.FragViewLikeBinding;
import com.example.shopeetts.fragment.room.AppDatabase;
import com.example.shopeetts.fragment.room.CartDAO;
import com.example.shopeetts.model.ProductView;
import com.example.shopeetts.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class ViewLikeFragment extends BaseFragment<FragViewLikeBinding,ViewLikeViewmodel> {
    int typeFrag = -5;
    CartDAO cartDAO = null;
    @Override
    public Class<ViewLikeViewmodel> getViewmodel() {
        return ViewLikeViewmodel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_view_like;
    }

    @Override
    public void setBindingViewmodel() {
        initRoomDatabase();
       binding.setViewmodel(viewmodel);
       Bundle bundle = getArguments();
       if(bundle!=null){
          typeFrag =  bundle.getInt("type");
       }
       switch (typeFrag){
           case Constant.Typelike:
               binding.tvTitle.setText("Đã Thích");
               break;
           case Constant.TypeViewed:
               binding.tvTitle.setText("Đã xem");
               break;
       }
    }

    @Override
    public void ViewCreated() {
          setUpREcyclerView();

          // quan sát data
          viewmodel.getArrViewd().observe(this, new Observer<List<ProductView>>() {
              @Override
              public void onChanged(List<ProductView> productViews) {
                  viewmodel.productViewAdapter.setList((ArrayList<ProductView>) productViews);
              }
          });


    }

    private void setUpREcyclerView() {
        binding.rvProduct.setHasFixedSize(true);
        binding.rvProduct.setAdapter(viewmodel.productViewAdapter);
        binding.rvProduct.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
    }
    private void initRoomDatabase() {
        AppDatabase database = Room.databaseBuilder(getContext(), AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        cartDAO = database.getCartDao();

    }
}
