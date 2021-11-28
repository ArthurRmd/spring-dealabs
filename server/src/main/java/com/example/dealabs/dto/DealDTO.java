package com.example.dealabs.dto;

import com.example.dealabs.database.repository.DealDO;

import java.util.Calendar;

public class DealDTO {

    public int id;
    public String title;
    public String author;
    public String shopName;
    public String imageUrl;
    public String description;
    public float temperature;
    public Calendar createdAt;


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getShopName() {
        return shopName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public float getTemperature() {
        return temperature;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
