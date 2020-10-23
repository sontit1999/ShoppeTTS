package com.example.shopeetts.fragment.cart;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopeetts.R;
import com.example.shopeetts.base.BaseFragment;
import com.example.shopeetts.callback.CartCallback;
import com.example.shopeetts.callback.FlashSaleCallback;
import com.example.shopeetts.databinding.FragCartBinding;
import com.example.shopeetts.model.Cart;
import com.example.shopeetts.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CardFragment extends BaseFragment<FragCartBinding,CartViewmodel> {
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
                viewmodel.cartAdapter.setList((ArrayList<Cart>) carts);
                viewmodel.cartAdapter.setCartCallback(new CartCallback() {
                    @Override
                    public void onCartClick(Cart cart) {
                        Toast.makeText(getActivity(), "Click " + cart.getProduct().getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        viewmodel.getArrFlashSale().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                viewmodel.productAdapter.setList((ArrayList<Product>) products);
                viewmodel.productAdapter.setCallback(new FlashSaleCallback() {
                    @Override
                    public void onCLickProduct(Product product) {
                        Toast.makeText(getActivity(), "Click " + product.getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
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
