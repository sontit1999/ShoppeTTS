package com.example.shopeetts.model;

public class Cart {
    String id;
    int soluong;
    Product product;
    boolean check = false;
    public Cart() {
    }

    public Cart(String id, int soluong, Product product) {
        this.id = id;
        this.soluong = soluong;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
