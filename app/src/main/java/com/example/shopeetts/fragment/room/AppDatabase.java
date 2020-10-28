package com.example.shopeetts.fragment.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.shopeetts.model.Cart;
import com.example.shopeetts.model.ProductView;

@Database(entities = {Cart.class, ProductView.class}, version = 6)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CartDAO getCartDao();
}
