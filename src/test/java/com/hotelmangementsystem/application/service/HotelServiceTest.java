package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.entity.Facility;
import com.hotelmangementsystem.application.entity.Hotel;
import com.hotelmangementsystem.application.entity.Image;
import com.hotelmangementsystem.application.repository.ContractRepository;
import com.hotelmangementsystem.application.repository.FacilityRepository;
import com.hotelmangementsystem.application.repository.HotelRepository;
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
class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @MockBean
    private HotelRepository hotelRepository;

    @MockBean
    private ContractRepository contractRepository;

    @MockBean
    private FacilityRepository facilityRepository;

    @MockBean
    private ImageRepository imageRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getAllHotels() {
        Hotel hotel = new Hotel(1l, "Hilton", "Sri lanka", "Colombo", "123 gallface road", "description", "0123456789");

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);

        when(hotelRepository.findAll()).thenReturn(hotels);

        List<Hotel> retrieveHotels = hotelService.getAllHotels();

        assertEquals(hotels.size(), retrieveHotels.size());

    }

    @Test
    void getHotel() {
        Long id = 1l;
        Hotel hotel = new Hotel(id, "Hilton", "Sri lanka", "Colombo", "123 gallface road", "description", "0123456789");

        when(hotelRepository.findById(1l)).thenReturn(Optional.of(hotel));

        Hotel retrievHotel = hotelService.getHotel(id);

        assertEquals(id, retrievHotel.getId());
    }

    @Test
    void addHotel() {
        Hotel hotel = new Hotel(1l, "Hilton", "Sri lanka", "Colombo", "123 gallface road", "description", "0123456789");

//        Mockito.when(hotelRepository.findHotelByName("Hilton")).thenReturn(new Optional(null));
        when(hotelRepository.save(hotel)).thenReturn(hotel);

        Hotel retrieveHotel = hotelService.addHotel(hotel);

        assertEquals(hotel, retrieveHotel);
    }

    @Test
    void updateHotel() {
        Hotel oldHotel = new Hotel(1l, "Hilton", "Sri lanka", "Colombo", "123 gallface road", "description", "0123456789");

        Hotel newHotel = new Hotel(1l, "Hilton", "Sri lanka", "Kandy", "123 gallface road", "description", "0123456789");

        when(hotelRepository.findById(1l)).thenReturn(Optional.of(oldHotel));

        when(hotelRepository.save(Mockito.any(Hotel.class))).thenReturn(newHotel);

        Hotel updatedHotel = hotelService.updateHotel(1l, newHotel);

        assertEquals(newHotel.getId(), updatedHotel.getId());
        assertEquals(newHotel.getDistrict(), updatedHotel.getDistrict());

    }

    @Test
    void deleteHotel() {
        Hotel hotel = new Hotel();
        when(hotelRepository.existsById(1l)).thenReturn(true);

        String dlt = hotelService.deleteHotel(1l);

        assertEquals("deleted", dlt);
    }

    @Test
    void addContractToHotel() {
        Long hotelId = 1L;
        Long contractId = 1L;

        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        // Create a sample contract
        Contract contract = new Contract();
        contract.setId(contractId);

        // Mock repository to return hotel and contract when findById is called
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));

        // Call the service method
        Hotel result = hotelService.addContractToHotel(hotelId, contractId);

        // Verify that the hotel has been associated with the contract
        assertEquals(hotel, result);
        assertEquals(contract.getHotel(), hotel);


    }

    @Test
    void removeContractFromHotel() {
        Long hotelId = 1L;
        Long contractId = 1L;

        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        // Create a sample contract
        Contract contract = new Contract();
        contract.setId(contractId);
        contract.setHotel(hotel);

        // Mock repository to return hotel and contract when findById is called
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));

        // Call the service method
        Hotel result = hotelService.removeContractFromHotel(hotelId, contractId);

        // Verify that the hotel has been disassociated with the contract
        assertEquals(hotel, result);
        assertEquals(null, contract.getHotel());


    }

    @Test
    void getAllContractsOfHotel() {
        Long hotelId = 1L;

        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        // Create a list of sample contracts
        List<Contract> contracts = new ArrayList<>();
        contracts.add(new Contract());
        contracts.add(new Contract());

        hotel.setContracts(contracts);

        // Mock repository to return hotel when findById is called
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
        // Mock repository to return contracts when getContracts is called
//        when(hotelRepository.getContracts()).thenReturn(contracts);

        // Call the service method
        List<Contract> result = hotelService.getAllContractsOfHotel(hotelId);

        // Verify that the list of contracts returned by the method matches the expected list
        assertEquals(contracts.size(), result.size());

    }

    @Test
    void addFacilityToHotel() {
        Long hotelId = 1L;
        Long facilityId = 1L;

        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        // Create a sample facility
        Facility facility = new Facility();
        facility.setId(facilityId);

        // Mock repository to return hotel and facility when findById is called
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
        when(facilityRepository.findById(facilityId)).thenReturn(Optional.of(facility));

        // Call the service method
        Hotel result = hotelService.addFacilityToHotel(hotelId, facilityId);

        // Verify that the hotel has been associated with the facility
        assertEquals(hotel, result);
        assertEquals(hotel, facility.getHotel());
    }

    @Test
    void removeFacilityFromHotel() {
        Long hotelId = 1L;
        Long facilityId = 1L;

        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        // Create a sample facility associated with the hotel
        Facility facility = new Facility();
        facility.setId(facilityId);
        facility.setHotel(hotel);

        // Mock repository to return hotel and facility when findById is called
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
        when(facilityRepository.findById(facilityId)).thenReturn(Optional.of(facility));

        // Call the service method
        Hotel result = hotelService.removeFacilityFromHotel(hotelId, facilityId);

        // Verify that the hotel has been disassociated with the facility
        assertEquals(hotel, result);
        assertEquals(null, facility.getHotel());
    }

    @Test
    void getAllFacilitiesOfHotel() {
        Long hotelId = 1L;

        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        // Create a list of sample facilities associated with the hotel
        List<Facility> facilities = new ArrayList<>();
        facilities.add(new Facility());
        facilities.add(new Facility());

        hotel.setFacilities(facilities);

        // Mock repository to return hotel when findById is called
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
        // Mock repository to return facilities when findByHotel is called
//        when(facilityRepository.findByHotel(hotel)).thenReturn(facilities);

        // Call the service method
        List<Facility> result = hotelService.getAllFacilitiesOfHotel(hotelId);

        // Verify that the list of facilities returned by the method matches the expected list
        assertEquals(facilities.size(), result.size());
    }

    @Test
    void addImageToHotel() {
        Long hotelId = 1L;
        Long imageId = 1L;

        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        // Create a sample image
        Image image = new Image();
        image.setId(imageId);

        // Mock repository to return hotel and image when findById is called
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
        when(imageRepository.findById(imageId)).thenReturn(Optional.of(image));

        // Call the service method
        Hotel result = hotelService.addImageToHotel(hotelId, imageId);

        // Verify that the hotel has been associated with the image
        assertEquals(hotel, result);
        assertEquals(hotel, image.getHotel());
    }

    @Test
    void removeImageFromHotel() {
        Long hotelId = 1L;
        Long imageId = 1L;

        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        // Create a sample image associated with the hotel
        Image image = new Image();
        image.setId(imageId);
        image.setHotel(hotel);

        // Mock repository to return hotel and image when findById is called
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
        when(imageRepository.findById(imageId)).thenReturn(Optional.of(image));

        // Call the service method
        Hotel result = hotelService.removeImageFromHotel(hotelId, imageId);

        // Verify that the hotel has been disassociated with the image
        assertEquals(hotel, result);
        assertEquals(null, image.getHotel());
    }

    @Test
    void getAllImagesOfHotel() {
        Long hotelId = 1L;

        // Create a sample hotel
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        // Create a list of sample images associated with the hotel
        List<Image> images = new ArrayList<>();
        images.add(new Image());
        images.add(new Image());

        hotel.setImages(images);

        // Mock repository to return hotel when findById is called
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));

        // Call the service method
        List<Image> result = hotelService.getAllImagesOfHotel(hotelId);

        // Verify that the list of images returned by the method matches the expected list
        assertEquals(images.size(), result.size());
    }
}