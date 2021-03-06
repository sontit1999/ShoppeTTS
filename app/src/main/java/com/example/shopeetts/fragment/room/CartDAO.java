package com.example.shopeetts.fragment.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.shopeetts.model.Cart;
import com.example.shopeetts.model.ProductView;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CartDAO {
    @Insert(onConflict = REPLACE)
    public void insert(Cart... carts);
    @Update
    public void update(Cart... carts);
    @Delete
    public void delete(Cart cart);
    @Query("select * from Cart")
    public List<Cart> getAllCart();
    @Query("delete from Cart")
    public void deleteAllCart();
}
