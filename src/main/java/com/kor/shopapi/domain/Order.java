package com.kor.shopapi.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ordr")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
    private User client;
    private LocalDate orderDate;

    @OneToMany(mappedBy = "cart_item_id", fetch = FetchType.EAGER)
//    @JoinColumn(name = "cartItem_id")
    private List<CartItem> cartItems;

    private String status;

    public Order() {
    }

    public Order(User client, List<CartItem> cartItems) {
        this.client = client;
        this.orderDate = LocalDate.now();
        this.cartItems = cartItems;
        this.status = "registered";
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate() {
        this.orderDate = LocalDate.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
