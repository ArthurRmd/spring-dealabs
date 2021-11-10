package com.example.dealabs.dto;

import com.example.dealabs.DealDO;

import java.util.Calendar;

public class DetailDealDTO {

    public int id;
    public String title;
    public String author;
    public String shopName;
    public String imageUrl;
    public String promoCode;
    public float newPrice;
    public float oldPrice;
    public Calendar createdAt;

    public DetailDealDTO(DealDO dealDO){
        this.id = dealDO.getId();
        this.title = dealDO.getCreator();
        this.author = dealDO.getShopName();
        this.shopName = dealDO.getShopName();
        this.imageUrl = dealDO.getImgUrl();
        this.promoCode = dealDO.getPromoCode();
        this.newPrice = dealDO.getPriceNew();
        this.oldPrice = dealDO.getPriceOld();
        this.createdAt = dealDO.getDate();
    }


    public DetailDealDTO(int id, String title, String author, String shopName, String imageUrl, String promoCode, float newPrice, float oldPrice, Calendar createdAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.shopName = shopName;
        this.imageUrl = imageUrl;
        this.promoCode = promoCode;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.createdAt = createdAt;
    }
}
