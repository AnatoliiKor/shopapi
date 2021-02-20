package com.kor.shopapi.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
//    @OneToOne
//    private User user;

    private LocalDate orderDate;

    @OneToMany(mappedBy = "cart")
//    @JoinColumn(name = "cartItem_id")
    private List<CartItem> cartItems;

    private String status;

    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
    }

    public Cart(User user, List<CartItem> cartItems) {
        this.user = user;
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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

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
