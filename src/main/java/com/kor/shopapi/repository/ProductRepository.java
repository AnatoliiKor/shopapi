package com.kor.shopapi.repository;

import com.kor.shopapi.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

       List<Product> findByName (String name);
}