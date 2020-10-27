package com.example.shopeetts.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Cart")
public class Cart {
    @PrimaryKey
    @NonNull  private String idCart;
    private int soluong;
    private String idproduct;

    private String name;

    private String mota;

    private String gia;

    private String linkanh;

    private String numberbuy;

    private String idtype;

    public Cart() {
    }

    public Cart(String idcart, int soluong, String idproduct, String name, String mota, String gia, String linkanh, String numberbuy, String idtype) {
        this.idCart = idcart;
        this.soluong = soluong;
        this.idproduct = idproduct;
        this.name = name;
        this.mota = mota;
        this.gia = gia;
        this.linkanh = linkanh;
        this.numberbuy = numberbuy;
        this.idtype = idtype;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getLinkanh() {
        return linkanh;
    }

    public void setLinkanh(String linkanh) {
        this.linkanh = linkanh;
    }

    public String getNumberbuy() {
        return numberbuy;
    }

    public void setNumberbuy(String numberbuy) {
        this.numberbuy = numberbuy;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
