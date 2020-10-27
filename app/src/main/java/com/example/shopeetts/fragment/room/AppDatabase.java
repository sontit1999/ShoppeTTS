package com.example.shopeetts.fragment.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.shopeetts.model.Cart;

@Database(entities = {Cart.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CartDAO getCartDao();
}
