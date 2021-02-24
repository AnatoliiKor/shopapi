package com.kor.shopapi.services;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Transactional
    public Bike save(Bike bike) {
        return bikeRepository.save(bike);
    }

    public List<Bike> findAll() {
        return bikeRepository.findAll();
    }

    public List<Bike> findByName(String name) {
        return bikeRepository.findByName(name);
    }

    @Transactional
    public void deleteById(Long id) {
        bikeRepository.deleteById(id);
    }

    public Bike findById(Long id) {
        Bike bike = bikeRepository.findById(id).get();
        return bike;
    }
}
