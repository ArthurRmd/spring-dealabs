package com.example.dealabs.dto;

import com.example.dealabs.database.repository.DealDO;

import java.util.Calendar;

public class DetailDealDTO {

    public int id;
    public String title;
    public String author;
    public String shopName;
    public String shopLink;
    public String imageUrl;
    public String description;
    public float temperature;
    public String promoCode;
    public float newPrice;
    public float oldPrice;
    public Calendar createdAt;

    public DetailDealDTO(){}

    public DetailDealDTO(DealDO dealDO){
        this.id = dealDO.getId();
        this.temperature = dealDO.getTemperature();
        this.title = dealDO.getTitle();
        this.author = dealDO.getCreator();
        this.shopName = dealDO.getShopName();
        this.imageUrl = dealDO.getImgUrl();
        this.promoCode = dealDO.getPromoCode();
        this.description = dealDO.getDescription();
        this.newPrice = dealDO.getPriceNew();
        this.oldPrice = dealDO.getPriceOld();
        this.createdAt = dealDO.getDate();
        this.shopLink = dealDO.getShopLink();
    }

}
