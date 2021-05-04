package com.kor.shopapi.services;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Transactional
    public Bike save(Bike bike, MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));
            bike.setFilename(resultFilename);
        }
        return bikeRepository.save(bike);
    }

    public List<Bike> findPage(int page, String sort, String order) {
        Sort.Direction direction = Sort.Direction.valueOf(order);
        return bikeRepository.findAll(PageRequest.of(page,5, Sort.by(direction, sort))).getContent();
    }

    public List<Bike> findAll() {
        return bikeRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    public List<Bike> findByName(String name) {
        return bikeRepository.findByNameIsContaining(name);
    }

    public List<Bike> findByPrice(int page, int priceMin, int priceMax) {

        return bikeRepository.findByPriceBetweenOrderByPrice(PageRequest.of(page,3), priceMin, priceMax).getContent();
//        return bikeRepository.findByPrice(priceMin, priceMax);
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
