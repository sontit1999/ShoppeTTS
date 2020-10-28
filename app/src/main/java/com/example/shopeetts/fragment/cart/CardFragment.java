package com.example.shopeetts.fragment.cart;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.shopeetts.R;
import com.example.shopeetts.api.RetrofitClient;
import com.example.shopeetts.api.ShoppeService;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.callback.CartCallback;
import com.example.shopeetts.callback.FlashSaleCallback;
import com.example.shopeetts.databinding.FragCartBinding;
import com.example.shopeetts.fragment.room.AppDatabase;
import com.example.shopeetts.fragment.room.CartDAO;
import com.example.shopeetts.model.Cart;
import com.example.shopeetts.model.Product;
import com.example.shopeetts.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardFragment extends BaseFragment<FragCartBinding,CartViewmodel> {
    CartDAO cartDAO = null;
    List<Cart> cartList;
    @Override
    public Class<CartViewmodel> getViewmodel() {
        return CartViewmodel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_cart;
    }

    @Override
    public void setBindingViewmodel() {
         binding.setViewmodel(viewmodel);
         // init room database
        initRoomDatabase();
    }

    private void initRoomDatabase() {
        AppDatabase database = Room.databaseBuilder(getContext(), AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        cartDAO = database.getCartDao();

    }

    private void setUpRecyclerProduct() {
        binding.rvProduct.setAdapter(viewmodel.productAdapter);
        binding.rvProduct.setHasFixedSize(true);
        binding.rvProduct.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
    }

    private void setUpRecyclerCart() {
        binding.rvCart.setAdapter(viewmodel.cartAdapter);
        binding.rvCart.setHasFixedSize(true);
        binding.rvCart.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
    }

    @Override
    public void ViewCreated() {
        setUpRecyclerCart();
        setUpRecyclerProduct();
        viewmodel.getArrCart().observe(this, new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> carts) {
                binding.totalmoney.setText(getTotalMoney() + " VND");
                viewmodel.cartAdapter.setList((ArrayList<Cart>) carts);
                viewmodel.cartAdapter.setCartCallback(new CartCallback() {
                    @Override
                    public void onCartClick(Cart cart) {

                    }

                    @Override
                    public void onIncresa(Cart cart) {

                        // xử lý database
                        cart.setSoluong(cart.getSoluong()+1);
                        cartDAO.update(cart);
                        // xử lý ở view
                        binding.totalmoney.setText(getTotalMoney() + " VND");
                        RefresheListCart();

                    }

                    @Override
                    public void onDescrease(Cart cart) {
                        if(cart.getSoluong() > 1){
                            cart.setSoluong(cart.getSoluong()-1);
                            cartDAO.update(cart);
                            RefresheListCart();
                            binding.totalmoney.setText(getTotalMoney() + " VND");
                        }else{
                            cartDAO.delete(cart);
                            RefresheListCart();
                            binding.totalmoney.setText(getTotalMoney() + " VND");
                        }

                    }
                });
            }
        });
        viewmodel.getArrFlashSale(getContext()).observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                viewmodel.productAdapter.setList((ArrayList<Product>) products);
                viewmodel.productAdapter.setCallback(new FlashSaleCallback() {
                    @Override
                    public void onCLickProduct(Product product) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        getControler().navigate(R.id.action_cardFragment_to_detailProductFragment,bundle);
                    }
                });
            }
        });
        // get cart
        RefresheListCart();


        event();
    }
   public void RefresheListCart(){
       cartList = cartDAO.getAllCart();
       viewmodel.getArrCart().postValue(cartList);
   }
    private void event() {
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getControler().popBackStack();
            }
        });
        binding.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Cart i : cartList){
                    ShoppeService shoppeService = RetrofitClient.getInstance(getContext()).create(ShoppeService.class);
                    Call<String> call = shoppeService.AddDonHang(Constant.user.getIduser(),i.getIdproduct(),i.getSoluong(),i.getSoluong() * Integer.parseInt(i.getGia()));
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            cartDAO.deleteAllCart();
                            RefresheListCart();
                            Toast.makeText(getActivity(), "Đặt hàng thành công!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(getActivity(), "fail call api : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
    public int getTotalMoney(){
        int total = 0;
        for(Cart i : cartList){
            total += (i.getSoluong() * Integer.parseInt(i.getGia()));
        }
        return total;
    }
}
