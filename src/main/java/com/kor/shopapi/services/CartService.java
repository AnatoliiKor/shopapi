package com.kor.shopapi.services;

import com.kor.shopapi.domain.Cart;
import com.kor.shopapi.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> findAll(String sort) {
//        Sort sort = Sort.by(sortBy);
        return cartRepository.findAll(Sort.by(sort));
    }

    public List<Cart> findByStatus(String status) {
        return cartRepository.findByStatus(status);
    }
}
