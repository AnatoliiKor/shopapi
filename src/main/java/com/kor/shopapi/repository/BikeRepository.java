package com.kor.shopapi.repository;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.CartItem;
import com.kor.shopapi.domain.Product;
import com.kor.shopapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository <Bike, Long> {

    List<Bike> findByName (String name);

}

