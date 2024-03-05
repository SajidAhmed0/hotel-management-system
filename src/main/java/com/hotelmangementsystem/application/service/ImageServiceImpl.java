package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Discount;
import com.hotelmangementsystem.application.entity.Image;
import com.hotelmangementsystem.application.repository.ImageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image getImage(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image updateImage(Long id, Image image) {
        Image imageDB = imageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Image with id " + id + " does not exists"));

        if(image != null){
            imageDB.setName(image.getName());
            imageDB.setUrl(image.getUrl());
            return imageRepository.save(imageDB);
        }
        return null;
    }

    @Override
    public String deleteImage(Long id) {
        boolean exists = imageRepository.existsById(id);
        if(!exists) {
            throw new EntityNotFoundException("Image with id " + id + " does not exists");
        }
        imageRepository.deleteById(id);
        return "deleted";
    }
}
