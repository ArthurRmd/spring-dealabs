package com.example.dealabs.database.repository;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="tbl_deal")
public class DealDO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="shop_name")
    private String shopName;

    @Column(name="shop_link")
    private String shopLink;

    @Column(name="price_old")
    private Float priceOld;

    @Column(name="price_new")
    private Float priceNew;

    @Column(name="promo_code")
    private String promoCode;

    @Column(name="date")
    private Calendar date;

    @Column(name="img_url")
    private String imgUrl;

    @Column(name="description")
    private String description;

    @OneToMany(targetEntity = TemperatureDO.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="deal_id",referencedColumnName = "id")
    private List<TemperatureDO> temperatures;

    @OneToOne(cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDO user;

    public DealDO() {}

    public String getCreator(){
        return user.getFullName();
    }


    ////


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLink() {
        return shopLink;
    }

    public void setShopLink(String shopLink) {
        this.shopLink = shopLink;
    }

    public Float getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(Float priceOld) {
        this.priceOld = priceOld;
    }

    public Float getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(Float priceNew) {
        this.priceNew = priceNew;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TemperatureDO> getTemperatures() {
        return temperatures;
    }

    public float getTemperature() {
        float temperature = 0;
        for(TemperatureDO temp :temperatures){
            temperature += temp.getValue();
        }
        return temperature;
    }

    public void setTemperatures(List<TemperatureDO> temperatures) {
        this.temperatures = temperatures;
    }

    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }
}
