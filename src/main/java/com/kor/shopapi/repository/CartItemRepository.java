package com.kor.shopapi.repository;

import com.kor.shopapi.domain.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
}

