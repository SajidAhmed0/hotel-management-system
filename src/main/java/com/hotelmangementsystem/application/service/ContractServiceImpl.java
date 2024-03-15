package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.*;
import com.hotelmangementsystem.application.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private SupplementRepository supplementRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract getContract(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Contract addContract(Contract contract) {
        System.out.println(contract.getHotel());
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Contract contractDB = contractRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contract with id " + id + " does not exists"));

        if(contract != null){
            contractDB.setStartDate(contract.getStartDate());
            contractDB.setEndDate(contract.getEndDate());
            contractDB.setCancellationPolicy(contract.getCancellationPolicy());
            contractDB.setPaymentPolicy(contract.getPaymentPolicy());
            return contractRepository.save(contractDB);
        }
        return null;
    }

    @Override
    public String deleteContract(Long id) {
        boolean exists = contractRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Contract with id " + id + " does not exists");
        }
        contractRepository.deleteById(id);
        return "deleted";
    }

//    @Transactional
//    @Override
//    public Contract addSupplementToContract(Long contractId, Long supplementId) {
//        Contract contract = getContract(contractId);
//        Supplement supplement = supplementRepository.findById(supplementId).orElse(null);
//
//        if(contract != null && supplement != null){
////            contract.addSupplement(supplement);
//            supplement.setContract(contract);
//            return contract;
//        }
//
//        return null;
//    }

//    @Transactional
//    @Override
//    public Contract removeSupplementToContract(Long contractId, Long supplementId) {
//        Contract contract = getContract(contractId);
//        Supplement supplement = supplementRepository.findById(supplementId).orElse(null);
//
//        if(contract != null && supplement != null){
////            contract.removeSupplement(supplement);
//            supplement.setContract(null);
//            return contract;
//        }
//
//        return null;
//    }

//    @Override
//    public List<Supplement> getAllSupplementsOfContract(Long id) {
//        Contract contract = getContract(id);
//
//        if(contract != null){
//            return contract.getSupplements();
//        }
//        return null;
//    }

    @Transactional
    @Override
    public Contract addSeasonToContract(Long contractId, Long seasonId) {
        Contract contract = getContract(contractId);
        Season season = seasonRepository.findById(seasonId).orElse(null);

        if(contract != null && season != null){
//            contract.addSeason(season);
            season.setContract(contract);
            return contract;
        }

        return null;
    }

    @Transactional
    @Override
    public Contract removeSeasonToContract(Long contractId, Long seasonId) {
        Contract contract = getContract(contractId);
        Season season = seasonRepository.findById(seasonId).orElse(null);

        if(contract != null && season != null){
//            contract.removeSeason(season);
            season.setContract(null);
            return contract;
        }

        return null;
    }

    @Override
    public List<Season> getAllSeasonsOfContract(Long id) {
        Contract contract = getContract(id);

        if(contract != null){
            return contract.getSeasons();
        }
        return null;
    }

//    @Transactional
//    @Override
//    public Contract addRoomTypeToContract(Long contractId, Long roomtypeId) {
//        Contract contract = getContract(contractId);
//        RoomType roomType = roomTypeRepository.findById(roomtypeId).orElse(null);
//
//        if(contract != null && roomType != null){
////            contract.addRoomType(roomType);
//            roomType.setContract(contract);
//            return contract;
//        }
//
//        return null;
//    }

//    @Transactional
//    @Override
//    public Contract removeRoomTypeToContract(Long contractId, Long roomtypeId) {
//        Contract contract = getContract(contractId);
//        RoomType roomType = roomTypeRepository.findById(roomtypeId).orElse(null);
//
//        if(contract != null && roomType != null){
////            contract.removeRoomType(roomType);
//            roomType.setContract(null);
//            return contract;
//        }
//
//        return null;
//    }

//    @Override
//    public List<RoomType> getAllRoomTypesOfContract(Long id) {
//        Contract contract = getContract(id);
//
//        if(contract != null){
//            return contract.getRoomTypes();
//        }
//        return null;
//    }

    @Transactional
    @Override
    public Contract addDiscountToContract(Long contractId, Long discountId) {
        Contract contract = getContract(contractId);
        Discount discount = discountRepository.findById(discountId).orElse(null);

        if(contract != null && discount != null){
//            contract.addDiscount(discount);
            discount.setContract(contract);
            return contract;
        }

        return null;
    }

    @Transactional
    @Override
    public Contract removeDiscountToContract(Long contractId, Long discountId) {
        Contract contract = getContract(contractId);
        Discount discount = discountRepository.findById(discountId).orElse(null);

        if(contract != null && discount != null){
//            contract.removeDiscount(discount);
            discount.setContract(null);
            return contract;
        }

        return null;
    }

    @Override
    public List<Discount> getAllDiscountsOfContract(Long id) {
        Contract contract = getContract(id);

        if(contract != null){
            return contract.getDiscounts();
        }
        return null;
    }

//    @Transactional
//    @Override
//    public Hotel addContractToHotel(Long contractId, Long hotelId) {
//        Contract contract = getContract(contractId);
//        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
//
//        contract.setHotel(hotel);
//
//        return hotel;
//    }
//
//    @Transactional
//    @Override
//    public Hotel removeContractToHotel(Long contractId, Long hotelId) {
//        Contract contract = getContract(contractId);
//        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
//
//        contract.setHotel(null);
//        return hotel;
//    }


}
