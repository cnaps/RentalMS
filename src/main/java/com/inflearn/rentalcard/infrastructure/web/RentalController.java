package com.inflearn.rentalcard.infrastructure.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inflearn.rentalcard.application.service.RentItemService;
import com.inflearn.rentalcard.infrastructure.web.dto.RentalDTO;


@RestController
@RequestMapping("/api/rentalCards")
public class RentalController {
 
    private final RentItemService rentItemService;

    public RentalController(RentItemService rentItemService) {
        this.rentItemService = rentItemService;
    }
 
    // @PostMapping("/rent")
    // public RentalDTO rentItem(@RequestBody RentalDTO rentalCardDto) {
    //     return rentItemService.rentItem(null, rentalCardDto);
    // }
    
    // @PostMapping("/return")
    // public RentalDTO returnItem(@RequestBody RentalDTO rentalCardDto) {
    //     return rentItemService.returnItem(rentalCardDto);
    // }
    
    // @PostMapping("/overdue")
    // public RentalDTO overdueItem(@RequestBody RentalDTO rentalCardDto) {
    //     return rentItemService.overdueItem(rentalCardDto);
    // }

    // @PostMapping
    // public ResponseEntity<RentalDTO> createRentalCard(@RequestBody RentalDTO rentalCardDTO) {
    //     RentalDTO createdRentalCard = rentItemService.createRentalCard(rentalCardDTO);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(createdRentalCard);
    // }
 
    // @GetMapping("/{id}")
    // public ResponseEntity<RentalDTO> getRentalCard(@PathVariable Long id) {
    //     RentalDTO rentalCardDTO = rentItemService.getRentalCard(id);
    //     return ResponseEntity.ok(rentalCardDTO);
    // }
 
    // @GetMapping
    // public ResponseEntity<List<RentalDTO>> getAllRentalCards() {
    //     List<RentalDTO> rentalCardDTOs = rentItemService.getAllRentalCards();
    //     return ResponseEntity.ok(rentalCardDTOs);
    // }
 
    // @PutMapping("/{id}")
    // public ResponseEntity<RentalDTO> updateRentalCard(@PathVariable Long id, @RequestBody RentalDTO rentalCardDTO) {
    //     rentalCardDTO.setId(id);
    //     RentalDTO updatedRentalCard = rentItemService.updateRentalCard(rentalCardDTO);
    //     return ResponseEntity.ok(updatedRentalCard);
    // }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentalCard(@PathVariable Long id) {
        rentItemService.deleteRentalCard(id);
        return ResponseEntity.noContent().build();
    }
}
