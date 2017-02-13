package com.example.jmajyo.cardtrick.managers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardEntity {
    @SerializedName("image") private String image;
    @SerializedName("id") private int id;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
