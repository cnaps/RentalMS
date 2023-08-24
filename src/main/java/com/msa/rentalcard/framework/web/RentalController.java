package com.msa.rentalcard.framework.web;

import com.msa.rentalcard.application.usecase.*;
import com.msa.rentalcard.framework.web.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
api테스트 시나리오

사용자정보로 도서카드 생성
사용자정보로 도서카드 조회

사용자,아이템정보1로 도서대여
사용자,아이템정보2로 도서 대여
사용자,아이템정보3로 도서 대여

사용자정보로 대여목록 조회
사용자정보로 반납목록 조회

사용자,아이템정보1로 도서반납

사용자정보로 대여목록 조회
사용자정보로 반납목록 조회

사용자,아이템정보2로 도서연체처리

사용자정보로 대여목록 조회
사용자정보로 반납목록 조회

사용자정보로 도서카드 조회(총연체료,대여가능여부,전체대여건수, 대여중 연체건수, 반납도서건수)
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(tags = {"대여 Controller"})
public class RentalController {
 
    private final RentItemUsecase rentItemUsecase;
    private final ReturnItemUsercase returnItemUsercase;
    private final OverdueItemUsercase overdueItemUsercase;
    private final CreateRentalCardUsecase createRentalCardUsecase;
    private final InquiryUsecase inquiryUsecase;
    private final ClearOverdueItemUsecase clearOverdueItemUsecase;

    @ApiOperation(value = "도서카드 생성",notes = "사용자정보 -> 도서카드정보")
    @PostMapping("/RentalCard/")
    public ResponseEntity<RentalCardOutputDTO> createRentalCard(@RequestBody UserInputDTO userInputDTO) {
        RentalCardOutputDTO createdRentalCard = createRentalCardUsecase.createRentalCard(userInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRentalCard);
    }

    @ApiOperation(value = "도서카드 조회",notes = "사용자정보(id) -> 도서카드정보")
    public  void findRentalCard(){}
     @GetMapping("/RentalCard/{id}")
     public ResponseEntity<RentalCardOutputDTO> getRentalCard(@PathVariable String id) {
         RentalCardOutputDTO rentalCardOutputDTO = inquiryUsecase.getRentalCard(new UserInputDTO(id,""));
         return ResponseEntity.ok(rentalCardOutputDTO);
     }

    @ApiOperation(value = "대여도서목록 조회",notes = "사용자정보(id) -> 대여도서목록 조회")
    @GetMapping("/RentalCard/{id}/rentbook")
    public ResponseEntity<List<RentItemOutputDTO>> getAllRentItem(@PathVariable String id) {
        List<RentItemOutputDTO> rentalCardOutputDTOs = inquiryUsecase.getAllRentItem(new UserInputDTO(id,""));
        return ResponseEntity.ok(rentalCardOutputDTOs);
    }

    @ApiOperation(value = "반납도서목록 조회",notes = "사용자정보(id) -> 반납도서목록 조회")
    @GetMapping("/RentalCard/{id}/returnbook")
    public ResponseEntity<List<RetrunItemOupputDTO>> getAllReturnItem(@PathVariable String id) {
        List<RetrunItemOupputDTO> allReturnItem = inquiryUsecase.getAllReturnItem(new UserInputDTO(id, ""));
        return ResponseEntity.ok(allReturnItem);
    }

    @ApiOperation(value = "대여기능",notes = "사용자정보,아이템정보1 -> 도서카드정보 ")
    @PostMapping("/RentalCard/rent")
     public ResponseEntity<RentalCardOutputDTO> rentItem(@RequestBody UserItemInputDTO userItemInputDTO) throws Exception {
        RentalCardOutputDTO resultDTO= rentItemUsecase.rentItem(userItemInputDTO);
         return ResponseEntity.ok(resultDTO);
     }


    @ApiOperation(value = "반납기능",notes = "사용자정보,아이템정보1 -> 도서카드정보 ")
    @PostMapping("/RentalCard/return")
    public ResponseEntity<RentalCardOutputDTO> returnItem(@RequestBody UserItemInputDTO userItemInputDTO) throws Exception {
        RentalCardOutputDTO rentalCardOutputDTO = returnItemUsercase.returnItem(userItemInputDTO);
         return ResponseEntity.ok(rentalCardOutputDTO);
     }

    @ApiOperation(value = "연체기능",notes = "사용자정보,아이템정보1 -> 도서카드정보 ")
    @PostMapping("/RentalCard/overdue")
    public ResponseEntity<RentalCardOutputDTO> overdueItem(@RequestBody UserItemInputDTO userItemInputDTO) throws Exception {
        RentalCardOutputDTO rentalCardOutputDTO = overdueItemUsercase.overDueItem(userItemInputDTO);
        return ResponseEntity.ok(rentalCardOutputDTO);
    }

    @ApiOperation(value = "연체해제기능",notes = "사용자정보,포인트 -> 도서카드정보 ")
    @PostMapping("/RentalCard/clearoverdue")
    public ResponseEntity<RentalResultOuputDTO> clearOverdueItem(@RequestBody ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalResultOuputDTO rentalResultOuputDTO = clearOverdueItemUsecase.clearOverdue(clearOverdueInfoDTO);
        return ResponseEntity.ok(rentalResultOuputDTO);
    }

}
