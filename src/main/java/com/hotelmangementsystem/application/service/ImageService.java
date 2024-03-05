package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Facility;
import com.hotelmangementsystem.application.entity.Image;

import java.util.List;

public interface ImageService {
    public List<Image> getAllImages();

    public Image getImage(Long id);

    public Image addImage(Image image);

    public Image updateImage(Long id, Image image);

    public String deleteImage(Long id);
}
