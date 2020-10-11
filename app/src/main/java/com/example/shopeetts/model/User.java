package com.example.shopeetts.model;

public class User {
    String sdt;
    String mk;
    String address;

    public User() {
    }

    public User(String sdt, String mk, String address) {
        this.sdt = sdt;
        this.mk = mk;
        this.address = address;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
