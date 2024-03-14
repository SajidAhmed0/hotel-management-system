package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.*;
import com.hotelmangementsystem.application.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private SupplementRepository supplementRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        Optional<Hotel> hotelByName = hotelRepository.findHotelByName(hotel.getName());
        if(hotelByName.isPresent()) {
            throw new IllegalStateException("Name taken");
        }

        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        Hotel hotelDB = hotelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel wiht id " + id + " dose not exists"));
        if (updatedHotel != null) {
            hotelDB.setName(updatedHotel.getName());
            hotelDB.setCountry(updatedHotel.getCountry());
            hotelDB.setDistrict(updatedHotel.getDistrict());
            hotelDB.setStreet(updatedHotel.getStreet());
            hotelDB.setDescription(updatedHotel.getDescription());
            hotelDB.setContact(updatedHotel.getContact());

            return hotelRepository.save(hotelDB);
        }

        return null;
    }

    @Override
    public String deleteHotel(Long id) {

        boolean exixts = hotelRepository.existsById(id);
        if(!exixts){
            throw new EntityNotFoundException("Hotel with id " + id + " does not exists");
        }
        hotelRepository.deleteById(id);
        return "deleted";
    }


    @Transactional
    @Override
    public Hotel addContractToHotel(Long hotelId, Long contractId) {
        Hotel hotel = getHotel(hotelId);
        Contract contract = contractRepository.findById(contractId).orElse(null);

        if(hotel != null && contract != null) {
//            hotel.addContract(contract);
            contract.setHotel(hotel);
            return hotel;
        }
        return null;
    }

    @Transactional
    @Override
    public Hotel removeContractFromHotel(Long hotelId, Long contractId) {
        Hotel hotel = getHotel(hotelId);
        Contract contract = contractRepository.findById(contractId).orElse(null);

        if(hotel != null && contract != null) {
//            hotel.removeContract(contract);
            contract.setHotel(null);
            return hotel;
        }

        return hotel;
    }

    @Override
    public List<Contract> getAllContractsOfHotel(Long id) {
        Hotel hotel = getHotel(id);

        return  hotel.getContracts();
    }

    @Transactional
    @Override
    public Hotel addFacilityToHotel(Long hotelId, Long facilityId) {
        Hotel hotel = getHotel(hotelId);
        Facility facility = facilityRepository.findById(facilityId).orElse(null);

        if(hotel != null && facility != null){
//            hotel.addFacility(facility);
            facility.setHotel(hotel);
            return hotel;
        }
        return null;
    }

    @Transactional
    @Override
    public Hotel removeFacilityFromHotel(Long hotelId, Long facilityId) {
        Hotel hotel = getHotel(hotelId);
        Facility facility = facilityRepository.findById(facilityId).orElse(null);

        if(hotel != null && facility != null){
//            hotel.removeFacility(facility);
            facility.setHotel(null);
            return hotel;
        }
        return null;
    }

    @Override
    public List<Facility> getAllFacilitiesOfHotel(Long id) {
        Hotel hotel = getHotel(id);
        if(hotel != null){
            return hotel.getFacilities();
        }
        return null;
    }

    @Transactional
    @Override
    public Hotel addImageToHotel(Long hotelId, Long imageId) {
        Hotel hotel = getHotel(hotelId);
        Image image = imageRepository.findById(imageId).orElse(null);

        if(hotel != null && image != null){
//            hotel.addImage(image);
            image.setHotel(hotel);
            return hotel;
        }
        return null;
    }

    @Transactional
    @Override
    public Hotel removeImageFromHotel(Long hotelId, Long imageId) {
        Hotel hotel = getHotel(hotelId);
        Image image = imageRepository.findById(imageId).orElse(null);

        if(hotel != null && image != null){
//            hotel.removeImage(image);
            image.setHotel(null);
            return hotel;
        }
        return null;
    }

    @Override
    public List<Image> getAllImagesOfHotel(Long id) {
        Hotel hotel = getHotel(id);
        if(hotel != null){
            return hotel.getImages();
        }
        return null;
    }

    @Transactional
    @Override
    public Hotel addRoomTypeToHotel(Long hotelId, Long roomTypeId) {
        Hotel hotel = getHotel(hotelId);
        RoomType roomType = roomTypeRepository.findById(roomTypeId).orElse(null);

        if(hotel != null && roomType != null) {
            roomType.setHotel(hotel);
            return hotel;
        }
        return null;
    }

    @Transactional
    @Override
    public Hotel removeRoomTypeFromHotel(Long hotelId, Long roomTypeId) {
        Hotel hotel = getHotel(hotelId);
        RoomType roomType = roomTypeRepository.findById(roomTypeId).orElse(null);

        if(hotel != null && roomType != null) {
            roomType.setHotel(null);
            return hotel;
        }
        return null;
    }

    @Override
    public List<RoomType> getAllRoomTypesOfHotel(Long id) {
        Hotel hotel = getHotel(id);
        if(hotel != null){
            return hotel.getRoomTypes();
        }
        return null;
    }

    @Transactional
    @Override
    public Hotel addSupplementToHotel(Long hotelId, Long supplementId) {
        Hotel hotel = getHotel(hotelId);
        Supplement supplement = supplementRepository.findById(supplementId).orElse(null);

        if(hotel != null && supplement != null) {
            supplement.setHotel(hotel);
            return hotel;
        }
        return null;
    }

    @Transactional
    @Override
    public Hotel removeSupplementFromHotel(Long hotelId, Long supplementId) {
        Hotel hotel = getHotel(hotelId);
        Supplement supplement = supplementRepository.findById(supplementId).orElse(null);

        if(hotel != null && supplement != null) {
            supplement.setHotel(null);
            return hotel;
        }
        return null;
    }

    @Override
    public List<Supplement> getAllSupplementsOfHotel(Long id) {
        Hotel hotel = getHotel(id);
        if(hotel != null){
            return hotel.getSupplements();
        }
        return null;
    }

}
