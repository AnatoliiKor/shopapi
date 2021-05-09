package com.kor.shopapi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<CartItem> cartItems;

    private String status;
    private int total;


    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
    }

    public Cart(User user, List<CartItem> cartItems, Object total) {
        this.user = user;
        this.orderDate = LocalDateTime.now();
        this.cartItems = cartItems;
        this.total = (Integer) total;
        this.status = "registered";
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public User getUser() {
        return user;
    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }


    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate() {
        this.orderDate = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
