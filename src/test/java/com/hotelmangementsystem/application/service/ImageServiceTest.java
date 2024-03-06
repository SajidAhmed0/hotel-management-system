package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Image;
import com.hotelmangementsystem.application.repository.ImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ImageServiceTest {

    @Autowired
    private ImageService imageService;

    @MockBean
    private ImageRepository imageRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllImages() {
        List<Image> images = new ArrayList<>();
        images.add(new Image());
        images.add(new Image());

        when(imageRepository.findAll()).thenReturn(images);

        // Test
        List<Image> result = imageService.getAllImages();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getImage() {
        Image image = new Image();
        long id = 1L;

        when(imageRepository.findById(id)).thenReturn(Optional.of(image));

        // Test
        Image result = imageService.getImage(id);

        // Verify
        assertNotNull(result);
    }

    @Test
    void addImage() {
        Image image = new Image();

        when(imageRepository.save(Mockito.any(Image.class))).thenReturn(image);

        // Test
        Image result = imageService.addImage(image);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateImage() {
        long id = 1L;
        Image existingImage = new Image();
        existingImage.setId(id);
        existingImage.setName("Existing Image");

        Image updatedImage = new Image();
        updatedImage.setId(id);
        updatedImage.setName("Updated Image");

        when(imageRepository.findById(id)).thenReturn(Optional.of(existingImage));
        when(imageRepository.save(Mockito.any(Image.class))).thenReturn(updatedImage);

        // Test
        Image result = imageService.updateImage(id, updatedImage);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated Image", result.getName());
    }

    @Test
    void deleteImage() {
        long id = 1L;

        when(imageRepository.existsById(id)).thenReturn(true);

        // Test
        String result = imageService.deleteImage(id);

        // Verify
        assertEquals("deleted", result);
    }
}