package com.example.shopeetts.model;

import java.io.Serializable;

public class Cagetory implements Serializable {
    String id;
    String name;
    String LinkImage;

    public Cagetory() {
    }

    public Cagetory(String id, String name, String linkImage) {
        this.id = id;
        this.name = name;
        LinkImage = linkImage;
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

    public String getLinkImage() {
        return LinkImage;
    }

    public void setLinkImage(String linkImage) {
        LinkImage = linkImage;
    }
}
