package com.kor.shopapi.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CartItem implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bike_id", nullable = true)
    private Bike bike;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

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


    public CartItem(Bike bike, Integer price) {
        this.bike = bike;
        this.amount = 1;
        this.price = price;

    }

    public void setCart(Cart cart) {
        this.cart = cart;
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
