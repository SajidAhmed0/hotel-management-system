package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.Contract;
import com.hotelmangementsystem.application.entity.Hotel;
import com.hotelmangementsystem.application.repository.ContractRepository;
import com.hotelmangementsystem.application.repository.HotelRepository;
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
            // Assuming facilities and images can be updated without additional validation
            hotelDB.setFacilities(updatedHotel.getFacilities());
            hotelDB.setImages(updatedHotel.getImages());

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
            hotel.addContract(contract);
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
            hotel.removeContract(contract);
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

}
