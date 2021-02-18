package com.kor.shopapi.repository;

import com.kor.shopapi.domain.CartItem;
import com.kor.shopapi.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
