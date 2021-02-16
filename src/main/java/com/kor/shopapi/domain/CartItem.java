package com.kor.shopapi.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "bike_id")
    private Bike bike;

    private Integer amount;
    private Integer price;

    public CartItem() {
    }

    public CartItem(Bike bike, Integer amount, Integer price) {
        this.bike = bike;
        this.amount = amount;
        this.price = price;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
