package com.example.dealabs.database.repository;

import javax.persistence.*;

@Entity
@Table(name="tbl_temperature")
public class TemperatureDO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="value")
    private int value;

    @OneToOne(cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDO user;

    @OneToOne(cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "deal_id", referencedColumnName = "id")
    private DealDO deal;

    public TemperatureDO() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }

    public DealDO getDeal() {
        return deal;
    }

    public void setDeal(DealDO deal) {
        this.deal = deal;
    }
}
