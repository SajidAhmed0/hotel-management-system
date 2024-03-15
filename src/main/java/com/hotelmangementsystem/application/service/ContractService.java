package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.*;

import java.util.List;

public interface ContractService {
    public List<Contract> getAllContracts();

    public Contract getContract(Long id);

    public Contract addContract(Contract contract);

    public Contract updateContract(Long id, Contract contract);

    public String deleteContract(Long id);

//    public Hotel addContractToHotel(Long contractId, Long hotelId);
//
//    public Hotel removeContractToHotel(Long contractId, Long hotelId);

//    public Contract addSupplementToContract(Long contractId, Long supplementId);

//    public Contract removeSupplementToContract(Long contractId, Long supplementId);

//    public List<Supplement> getAllSupplementsOfContract(Long id);

    public Contract addSeasonToContract(Long contractId, Long seasonId);

    public Contract removeSeasonToContract(Long contractId, Long seasonId);

    public List<Season> getAllSeasonsOfContract(Long id);

//    public Contract addRoomTypeToContract(Long contractId, Long roomtypeId);

//    public Contract removeRoomTypeToContract(Long contractId, Long roomtypeId);

//    public List<RoomType> getAllRoomTypesOfContract(Long id);

    public Contract addDiscountToContract(Long contractId, Long discountId);

    public Contract removeDiscountToContract(Long contractId, Long discountId);

    public List<Discount> getAllDiscountsOfContract(Long id);
}
