package com.example.shopeetts.base;


import android.net.Uri;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class BingdingUtils {
    @BindingAdapter({ "setAdapter"})
    public static void setAdapter(RecyclerView view, RecyclerView.Adapter adapter) {
        view.setAdapter(adapter);
    }
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide
                .with(view.getContext())
                .load(imageUrl)
                .into(view);

    }
    @BindingAdapter({"bind:discount"})
    public static void loadDiscount(TextView view, String discount) {
        view.setText("Giảm\n" + discount);
        view.setGravity(Gravity.CENTER);
    }
    @BindingAdapter({"bind:numberSale"})
    public static void loadNumberSale(TextView view, String numberSale) {
        view.setText("Đã bán " + numberSale);
        view.setGravity(Gravity.CENTER);
    }
    @BindingAdapter({"bind:imageAssest"})
    public static void loadImageAssestToview(ImageView view, String imageAssest) {
        String assetPath =   "file:///android_asset/" + imageAssest;
        Glide.with(view.getContext())
                .load(Uri.parse(assetPath))
                .centerCrop()
                .into(view);

    }
}
