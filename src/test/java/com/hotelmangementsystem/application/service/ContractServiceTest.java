package com.hotelmangementsystem.application.service;

import com.hotelmangementsystem.application.entity.*;
import com.hotelmangementsystem.application.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ContractServiceTest {

    @Autowired
    private ContractService contractService;

    @MockBean
    private ContractRepository contractRepository;

    @MockBean
    private SupplementRepository supplementRepository;

    @MockBean
    private SeasonRepository seasonRepository;

    @MockBean
    private RoomTypeRepository roomTypeRepository;

    @MockBean
    private DiscountRepository discountRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getAllContracts() {
        List<Contract> contracts = new ArrayList<>();
        contracts.add(new Contract());
        contracts.add(new Contract());

        when(contractRepository.findAll()).thenReturn(contracts);

        // Test
        List<Contract> result = contractService.getAllContracts();

        // Verify
        assertEquals(2, result.size());
    }

    @Test
    void getContract() {
        Contract contract = new Contract();
        long id = 1L;

        when(contractRepository.findById(id)).thenReturn(Optional.of(contract));

        // Test
        Contract result = contractService.getContract(id);

        // Verify
        assertNotNull(result);
    }

    @Test
    void addContract() {
        Contract contract = new Contract();

        when(contractRepository.save(Mockito.any(Contract.class))).thenReturn(contract);

        // Test
        Contract result = contractService.addContract(contract);

        // Verify
        assertNotNull(result);
    }

    @Test
    void updateContract() {
        long id = 1L;
        Contract existingContract = new Contract();
        existingContract.setId(id);
        existingContract.setStartDate(Date.valueOf(LocalDate.of(2024, 3, 1)));
        existingContract.setEndDate(Date.valueOf(LocalDate.of(2024, 3, 15)));
        existingContract.setCancellationPolicy("Flexible");
        existingContract.setPaymentPolicy("Credit card");

        Contract updatedContract = new Contract();
        updatedContract.setId(id);
        updatedContract.setStartDate(Date.valueOf(LocalDate.of(2024, 4, 1)));
        updatedContract.setEndDate(Date.valueOf(LocalDate.of(2024, 4, 15)));
        updatedContract.setCancellationPolicy("Strict");
        updatedContract.setPaymentPolicy("PayPal");

        when(contractRepository.findById(id)).thenReturn(Optional.of(existingContract));
        when(contractRepository.save(Mockito.any(Contract.class))).thenReturn(updatedContract);

        // Test
        Contract result = contractService.updateContract(id, updatedContract);

        // Verify
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(Date.valueOf(LocalDate.of(2024, 4, 1)), result.getStartDate());
        assertEquals(Date.valueOf(LocalDate.of(2024, 4, 15)), result.getEndDate());
        assertEquals("Strict", result.getCancellationPolicy());
        assertEquals("PayPal", result.getPaymentPolicy());
    }

    @Test
    void deleteContract() {
        long id = 1L;
        Contract contract = new Contract();
        contract.setId(id);

        when(contractRepository.existsById(id)).thenReturn(true);

        // Test
        String result = contractService.deleteContract(id);

        // Verify
        assertEquals("deleted", result);
    }

    @Test
    void addSupplementToContract() {
        long contractId = 1L;
        long supplementId = 1L;
        Contract contract = new Contract();
        Supplement supplement = new Supplement();

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));
        when(supplementRepository.findById(supplementId)).thenReturn(Optional.of(supplement));

        // Test
        Contract result = contractService.addSupplementToContract(contractId, supplementId);

        // Verify
        assertNotNull(result);
        assertEquals(contract, supplement.getContract());
    }

    @Test
    void removeSupplementToContract() {
        long contractId = 1L;
        long supplementId = 1L;
        Contract contract = new Contract();
        Supplement supplement = new Supplement();
        supplement.setContract(contract);

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));
        when(supplementRepository.findById(supplementId)).thenReturn(Optional.of(supplement));

        // Test
        Contract result = contractService.removeSupplementToContract(contractId, supplementId);

        // Verify
        assertNotNull(result);
        assertNull(supplement.getContract());
    }

    @Test
    void getAllSupplementsOfContract() {
        long contractId = 1L;
        Contract contract = new Contract();
        List<Supplement> supplements = new ArrayList<>();
        supplements.add(new Supplement());
        supplements.add(new Supplement());

        contract.setSupplements(supplements);

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));

        // Test
        List<Supplement> result = contractService.getAllSupplementsOfContract(contractId);

        // Verify
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void addSeasonToContract() {
        long contractId = 1L;
        long seasonId = 1L;
        Contract contract = new Contract();
        Season season = new Season();

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));
        when(seasonRepository.findById(seasonId)).thenReturn(Optional.of(season));

        // Test
        Contract result = contractService.addSeasonToContract(contractId, seasonId);

        // Verify
        assertNotNull(result);
        assertEquals(contract, season.getContract());
    }

    @Test
    void removeSeasonToContract() {
        long contractId = 1L;
        long seasonId = 1L;
        Contract contract = new Contract();
        Season season = new Season();
        season.setContract(contract);

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));
        when(seasonRepository.findById(seasonId)).thenReturn(Optional.of(season));

        // Test
        Contract result = contractService.removeSeasonToContract(contractId, seasonId);

        // Verify
        assertNotNull(result);
        assertNull(season.getContract());
    }

    @Test
    void getAllSeasonsOfContract() {
        long contractId = 1L;
        Contract contract = new Contract();
        List<Season> seasons = new ArrayList<>();
        seasons.add(new Season());
        seasons.add(new Season());

        contract.setSeasons(seasons);

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));

        // Test
        List<Season> result = contractService.getAllSeasonsOfContract(contractId);

        // Verify
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void addRoomTypeToContract() {
        long contractId = 1L;
        long roomTypeId = 1L;
        Contract contract = new Contract();
        RoomType roomType = new RoomType();

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));
        when(roomTypeRepository.findById(roomTypeId)).thenReturn(Optional.of(roomType));

        // Test
        Contract result = contractService.addRoomTypeToContract(contractId, roomTypeId);

        // Verify
        assertNotNull(result);
        assertEquals(contract, roomType.getContract());
    }

    @Test
    void removeRoomTypeToContract() {
        long contractId = 1L;
        long roomTypeId = 1L;
        Contract contract = new Contract();
        RoomType roomType = new RoomType();
        roomType.setContract(contract);

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));
        when(roomTypeRepository.findById(roomTypeId)).thenReturn(Optional.of(roomType));

        // Test
        Contract result = contractService.removeRoomTypeToContract(contractId, roomTypeId);

        // Verify
        assertNotNull(result);
        assertNull(roomType.getContract());
    }

    @Test
    void getAllRoomTypesOfContract() {
        long contractId = 1L;
        Contract contract = new Contract();
        List<RoomType> roomTypes = new ArrayList<>();
        roomTypes.add(new RoomType());
        roomTypes.add(new RoomType());

        contract.setRoomTypes(roomTypes);

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));

        // Test
        List<RoomType> result = contractService.getAllRoomTypesOfContract(contractId);

        // Verify
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void addDiscountToContract() {
        long contractId = 1L;
        long discountId = 1L;
        Contract contract = new Contract();
        Discount discount = new Discount();

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));
        when(discountRepository.findById(discountId)).thenReturn(Optional.of(discount));

        // Test
        Contract result = contractService.addDiscountToContract(contractId, discountId);

        // Verify
        assertNotNull(result);
        assertEquals(contract, discount.getContract());
    }

    @Test
    void removeDiscountToContract() {
        long contractId = 1L;
        long discountId = 1L;
        Contract contract = new Contract();
        Discount discount = new Discount();
        discount.setContract(contract);

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));
        when(discountRepository.findById(discountId)).thenReturn(Optional.of(discount));

        // Test
        Contract result = contractService.removeDiscountToContract(contractId, discountId);

        // Verify
        assertNotNull(result);
        assertNull(discount.getContract());
    }

    @Test
    void getAllDiscountsOfContract() {
        long contractId = 1L;
        Contract contract = new Contract();
        List<Discount> discounts = new ArrayList<>();
        discounts.add(new Discount());
        discounts.add(new Discount());

        contract.setDiscounts(discounts);

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));

        // Test
        List<Discount> result = contractService.getAllDiscountsOfContract(contractId);

        // Verify
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}