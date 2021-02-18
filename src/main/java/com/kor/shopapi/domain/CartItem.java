package com.kor.shopapi.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bike_id")
    private Bike bike;

    @OneToOne(optional = true)
    private User client;

//    @ManyToOne
//    private Order order;

    private Integer amount;
    private Integer price;

    public CartItem() {
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CartItem(Bike bike, Integer amount, Integer price, User client) {
        this.bike = bike;
        this.amount = amount;
        this.price = price;
        this.client = client;

    }


    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Long getId() {
        return id;
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
