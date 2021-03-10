package com.kor.shopapi.services;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
//    public Bike save(Bike bike) throws IOException {
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

//    public List<Bike> sortByBrand() {
//        return bikeRepository.findAllOrderByBrand();
//    }
}
