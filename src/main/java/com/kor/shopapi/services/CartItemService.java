package com.kor.shopapi.services;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.CartItem;
import com.kor.shopapi.repository.BikeRepository;
import com.kor.shopapi.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    public List<CartItem> findAllByClientId (Iterable<Long> id) {
        List<CartItem> cartItems = cartItemRepository.findAllById(id);
        System.out.println(cartItems.toArray());
        return cartItems;
    }



//    public List<Bike> findByName(String name) {
//        return bikeRepository.findByName(name);
//    }
//
    public void deleteById(Long id) {
        cartItemRepository.deleteById(id);
    }

//    public Bike findById(Long id) {
//        Bike bike = bikeRepository.findById(id).get();
//        return bike;
//    }
}
