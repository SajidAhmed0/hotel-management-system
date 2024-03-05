package com.hotelmangementsystem.application.controller;

import com.hotelmangementsystem.application.entity.Discount;
import com.hotelmangementsystem.application.entity.Image;
import com.hotelmangementsystem.application.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Image> getAllImages(){
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public Image getImage(@PathVariable("id") Long id) {
        return imageService.getImage(id);
    }

    @PostMapping
    public Image addImage(@RequestBody Image image){
        return imageService.addImage(image);
    }

    @PutMapping("/{id}")
    public Image updateImage(@PathVariable("id") Long id, @RequestBody Image image){
        return imageService.updateImage(id, image);
    }

    @DeleteMapping("/{id}")
    public String deleteImage(@PathVariable("id") Long id){
        return imageService.deleteImage(id);
    }
}
