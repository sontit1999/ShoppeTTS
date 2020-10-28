package com.example.shopeetts.fragment.room;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.shopeetts.model.Cart;
import com.example.shopeetts.model.ProductView;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

public interface ProductViewDao {
    @Insert(onConflict = REPLACE)
    public void insert(ProductView... productViews);
    @Update
    public void update(ProductView... productViews);
    @Delete
    public void delete(ProductView productView);
    @Query("select * from ProductView")
    public List<ProductView> getAllProductView();
}
