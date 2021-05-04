package com.kor.shopapi.repository;

import com.kor.shopapi.domain.Bike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
    List<Bike> findByNameIsContaining (String name);

    Page<Bike> findByPriceBetweenOrderByPrice (Pageable pageable, int min, int max);

    Page<Bike> findAll(Pageable pageable);

//    @Query(value = "SELECT * FROM bike WHERE price BETWEEN ?1 AND ?2 ORDER BY price ASC", nativeQuery = true)
//    List<Bike> findByPrice(int min, int max);

}

