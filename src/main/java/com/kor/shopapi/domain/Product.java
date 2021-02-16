package com.kor.shopapi.domain;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

    private Integer price;

    private Integer amount;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    public Product() {
    }

    public Product(String name, Integer price, Integer amount, String description, User user) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.author = user;
    }

    public Integer getId() {
        return id;
    }

    public String getAuthorName(){
        return author !=null ? author.getUsername() : "<none>";
    }
    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
        this.amount = 0;
        this.description = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
