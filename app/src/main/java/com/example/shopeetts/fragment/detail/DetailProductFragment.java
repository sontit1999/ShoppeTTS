package com.example.shopeetts.fragment.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.databinding.FragDetailProductBinding;
import com.example.shopeetts.fragment.room.AppDatabase;
import com.example.shopeetts.fragment.room.CartDAO;
import com.example.shopeetts.model.Cart;
import com.example.shopeetts.model.CommentResponse;
import com.example.shopeetts.model.Product;
import com.example.shopeetts.model.ProductView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DetailProductFragment extends BaseFragment<FragDetailProductBinding,DetailProductViewModel> {
    Product product = null;
    CartDAO cartDAO = null;
    @Override
    public Class<DetailProductViewModel> getViewmodel() {
        return DetailProductViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_detail_product;
    }

    @Override
    public void setBindingViewmodel() {
       binding.setViewmodel(viewmodel);
       initRoomDatabase();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!=null){
            product = (Product) bundle.getSerializable("product");
        }
    }

    @Override
    public void ViewCreated() {
        setUpreCyclerviewComment();
        // gán data lên view
         binDATA();
         event();

         viewmodel.getArrComment(getContext(),Integer.parseInt(product.getId())).observe(this, new Observer<List<CommentResponse>>() {
             @Override
             public void onChanged(List<CommentResponse> commentResponses) {
                 viewmodel.commentAdapter.setList((ArrayList<CommentResponse>) commentResponses);
             }
         });
    }
    private void initRoomDatabase() {
        AppDatabase database = Room.databaseBuilder(getContext(), AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        cartDAO = database.getCartDao();

    }
    private void setUpreCyclerviewComment() {
         binding.rvComment.setAdapter(viewmodel.commentAdapter);
         binding.rvComment.setHasFixedSize(true);
         binding.rvComment.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
    }

    private void binDATA() {
        if(product!=null){
            Glide.with(getContext()).load(product.getLinkanh()).into(binding.ivProduct);
            binding.tvNameProduct.setText(product.getName());
            binding.tvDesciption.setText(product.getMota());
            binding.tvNumberBuy.setText("Đã bán " + product.getNumberbuy() );
            binding.tvPriceProduct.setText(product.getGia() + "vnđ");
        }
    }

    private void event() {
       binding.ivBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               getControler().popBackStack();
           }
       });
       binding.ivCart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               getControler().navigate(R.id.action_detailProductFragment_to_cardFragment);
           }
       });
       binding.ivLikeProduct.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getActivity(), "Clik likes", Toast.LENGTH_SHORT).show();
           }
       });
       binding.btnAddtoCart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Cart cart = new Cart(System.currentTimeMillis() +"",1,product.getId(),product.getName(),product.getMota(),product.getGia(),product.getLinkanh(),product.getNumberbuy(),product.getIdtype());
               cartDAO.insert(cart);
               Toast.makeText(getActivity(), "Đã thêm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
           }
       });
    }
}
