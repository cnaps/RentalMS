package com.inflearn.rentalcard.framework.web;

import com.inflearn.rentalcard.application.usecase.RentItemUsecase;
import com.inflearn.rentalcard.application.usecase.ReturnItemUsercase;
import com.inflearn.rentalcard.domain.model.RentalCard;

import com.inflearn.rentalcard.framework.web.dto.RentalInputDTO;
import com.inflearn.rentalcard.framework.web.dto.RentalResultOuputDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(tags = {"대여 Controller"})
public class RentalController {
 
    private final RentItemUsecase rentItemUsecase;
    private final ReturnItemUsercase returnItemUsercase;

    @ApiOperation(value = "도서카드 생성")
    public void createRentalCard() {}
    @ApiOperation(value = "도서카드 조회",notes = "사용자id로 도서카드 조회")
    public  void findRentalCard(){}

    @ApiOperation(value = "대여도서목록 조회",notes = "도서카드 id로 대여도서목록 조회")
    public void findRentedItemList(){}

    @ApiOperation(value = "반납도서목록 조회",notes = "도서카드 id로 반납도서목록 조회")
    public void findReturnItemList(){}

    @ApiOperation(value = "대여기능",notes = "사용자가 도서정보와 사용자정도로 대여")
    @PostMapping("/rent")
     public ResponseEntity<RentalResultOuputDTO> rentItem(@RequestBody RentalInputDTO rentalInputDTO) throws Exception {
         RentalResultOuputDTO resultDTO= rentItemUsecase.rentItem(rentalInputDTO);
         return ResponseEntity.ok(resultDTO);
     }


     @PostMapping("/return")
     public ResponseEntity<RentalResultOuputDTO> returnItem(@RequestBody RentalInputDTO rentalInputDTO) throws Exception {
         RentalResultOuputDTO rentalResultOuputDTO = returnItemUsercase.returnItem(rentalInputDTO);
         return ResponseEntity.ok(rentalResultOuputDTO);
     }

    /*
    // @PostMapping("/overdue")
    // public RentalDTO overdueItem(@RequestBody RentalDTO rentalCardDto) {
    //     return rentItemService.overdueItem(rentalCardDto);
    // }



     @PostMapping
     public ResponseEntity<RentalDTO> createRentalCard(@RequestBody RentalDTO rentalCardDTO) {
         RentalDTO createdRentalCard = rentItemService.createRentalCard(rentalCardDTO);
         return ResponseEntity.status(HttpStatus.CREATED).body(createdRentalCard);
     }
 
//     @GetMapping("/{id}")
//     public ResponseEntity<RentalDTO> getRentalCard(@PathVariable Long id) {
//         RentalDTO rentalCardDTO = rentItemService.getRentalCard(id);
//         return ResponseEntity.ok(rentalCardDTO);
//     }

     @GetMapping
     public ResponseEntity<List<RentalDTO>> getAllRentItem() {
         List<RentalDTO> rentalCardDTOs = rentItemService.getAllRentalCards();
         return ResponseEntity.ok(rentalCardDTOs);
     }
 
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

     */
}
