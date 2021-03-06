package com.kor.shopapi.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Bike {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String category;
    private String brand;
    private String name;
    private String colour;
    private String description;
    private Integer price;
    private Integer amount;
    private LocalDate date;

    public Bike() {
        this.setDate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now();
    }


    public static class Builder {
        private Bike newBike;

        public Builder() {
            newBike = new Bike();
        }

        public Builder withCategory(String category){
            newBike.category = category;
            return this;
        }

        public Builder withBrand(String brand){
            newBike.brand = brand;
            return this;
        }

        public Builder withName(String name){
            newBike.name = name;
            return this;
        }
        public Builder withColour(String colour){
            newBike.colour = colour;
            return this;
        }

        public Builder withDescription(String description){
            newBike.description = description;
            return this;
        }

        public Builder withPrice(Integer price){
            newBike.price = price;
            return this;
        }
        public Builder withAmount(Integer amount){
            newBike.amount = amount;
            return this;
        }

        public Bike build(){
            return newBike;
        }

    }


}


