package com.example.dealabs.dto;

import com.example.dealabs.dao.DealDAO;
import com.example.dealabs.DealDO;

import java.util.Calendar;
import java.util.List;

public class DealDTO {

    public int id;
    public String title;
    public String author;
    public String shopName;
    public String imageUrl;
    public Calendar createdAt;

    public DealDTO(DealDO dealDO){
        this.id = dealDO.getId();
        this.title = dealDO.getTitle();
        this.author = dealDO.getCreator();
        this.shopName = dealDO.getShopName();
        this.imageUrl = dealDO.getImgUrl();
        this.createdAt = dealDO.getDate();
    }

    public DealDTO(int id, String title, String author, String shopName, String imageUrl, Calendar createdAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.shopName = shopName;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }
}
