package com.example.shopeetts.model;

import java.io.Serializable;

public class Product implements Serializable {
    String id;
    String name;
    String price;
    String linkImage;
    String numberBuy;
    String description;
    String status;
    String discount;
    String numberStar;
    public Product() {
    }

    public Product(String id, String name, String price, String linkImage, String numberBuy, String description, String status, String discount, String numberStar) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.linkImage = linkImage;
        this.numberBuy = numberBuy;
        this.description = description;
        this.status = status;
        this.discount = discount;
        this.numberStar = numberStar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getNumberBuy() {
        return numberBuy;
    }

    public void setNumberBuy(String numberBuy) {
        this.numberBuy = numberBuy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getNumberStar() {
        return numberStar;
    }

    public void setNumberStar(String numberStar) {
        this.numberStar = numberStar;
    }
}
