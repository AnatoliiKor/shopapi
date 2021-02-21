package com.kor.shopapi.services;

import com.kor.shopapi.domain.Cart;
import com.kor.shopapi.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> findAll() {
        return (List<Cart>) cartRepository.findAll();
    }
////    public Product save(Product product) {
////        return productRepository.save(product);
////    }
////
//
//    public List<Bike> findByName(String name) {
//        return bikeRepository.findByName(name);
//    }
////
////    public void deleteById(Integer id) {
////        productRepository.deleteById(id);
////    }
//
//    public Bike findById(Long id) {
//        Bike bike = bikeRepository.findById(id).get();
//        return bike;
//    }
}
