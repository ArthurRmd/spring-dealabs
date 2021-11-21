package com.example.dealabs.dto;

import com.example.dealabs.database.repository.DealDO;

import java.util.Calendar;

public class DetailDealDTO {

    public int id;
    public String title;
    public float temperature;
    public String author;
    public String shopName;
    public String imageUrl;
    public String promoCode;
    public float newPrice;
    public float oldPrice;
    public Calendar createdAt;

    public DetailDealDTO(DealDO dealDO){
        this.id = dealDO.getId();
        this.temperature = dealDO.getTemperature();
        this.title = dealDO.getCreator();
        this.author = dealDO.getShopName();
        this.shopName = dealDO.getShopName();
        this.imageUrl = dealDO.getImgUrl();
        this.promoCode = dealDO.getPromoCode();
        this.newPrice = dealDO.getPriceNew();
        this.oldPrice = dealDO.getPriceOld();
        this.createdAt = dealDO.getDate();
    }

}
