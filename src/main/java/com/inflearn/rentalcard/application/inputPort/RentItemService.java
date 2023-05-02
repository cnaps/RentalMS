package com.inflearn.rentalcard.application.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import com.inflearn.rentalcard.domain.model.vo.RentItem;
import com.inflearn.rentalcard.infrastructure.web.dto.RentResultDTO;
import org.springframework.stereotype.Service;

import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.domain.model.vo.IDName;
import com.inflearn.rentalcard.domain.model.vo.Item;
import com.inflearn.rentalcard.domain.repository.RentalCardRepository;
import com.inflearn.rentalcard.infrastructure.web.dto.RentItemDTO;

import lombok.RequiredArgsConstructor;



    // 대여 비즈니스 로직
    //public RentalDto rentBook(RentalDto rentalDto) {
        
        //도서 서비스에 도서 유효성 체크 한뒤 (ID 및 대여가능여부)
        //도서 대여 됬음으로 재고 처리  
        // Book book = bookRepository.findById(rentalDto.getBookId())
        //         .orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));
        // if (book.isRented()) {
        //     throw new IllegalStateException("The book is already rented");
        // }
        // book.setRented(true);
        // bookRepository.save(book);

        
        // RentalCard rentalCard = rentalCardRepository.findByMember(rentalDto.getRentalUser());
        // rental.setUser(new User(rentalDto.getUserId()));
        // rental.setBook(book);
        // rental.setRentedDate(LocalDate.now());
        // rentalRepository.save(rental);

        // return RentalDto.fromEntity(rental);
    //}

@Service
@Transactional
@RequiredArgsConstructor
public class RentItemService {

    private final RentalCardRepository rentalCardRepository;

    public RentalCard createRentalCard(IDName creator) {
        return rentalCardRepository.save(RentalCard.createRentalCard(creator));
    }

        public RentResultDTO rentItem(RentItemDTO rentalDTO) throws Exception {
        RentalCard rentalCard = rentalCardRepository.findByMember(rentalDTO.getRentalUser()).orElseThrow(() -> new IllegalArgumentException("해당 대출 카드가 존재하지 않습니다."));
        rentalCard.rentItem(rentalDTO.getRentItem());
        rentalCardRepository.save(rentalCard);
       return RentResultDTO.fromEntity(rentalCard);
    }

    public RentalCard returnItem(Long rentalCardId, RentItemDTO rentalDTO) throws Exception {
        RentalCard rentalCard = rentalCardRepository.findById(rentalCardId).orElseThrow(() -> new IllegalArgumentException("해당 대출 카드가 존재하지 않습니다."));
        rentalCard.returnItem(rentalDTO.getRentItem(), LocalDate.now());
        rentalCardRepository.save(rentalCard);
        return rentalCard;
    }

    public RentalCard overdueItem(Long rentalCardId, Item item) throws Exception {
        RentalCard rentalCard = rentalCardRepository.findById(rentalCardId).orElseThrow(() -> new IllegalArgumentException("해당 대출 카드가 존재하지 않습니다."));
        rentalCard.overdueItem(item);
        rentalCardRepository.save(rentalCard);
        return rentalCard;
    }

    public RentalCard makeAvailableRental(Long rentalCardId, Integer point) throws Exception {
        RentalCard rentalCard = rentalCardRepository.findById(rentalCardId).orElseThrow(() -> new IllegalArgumentException("해당 대출 카드가 존재하지 않습니다."));
        rentalCard.makeAvailableRental(point);
        rentalCardRepository.save(rentalCard);
        return rentalCard;
    }

    //@Transactional(readOnly = true)
    public List<RentalCard> getAllRentalCards() {
        return rentalCardRepository.findAll();
    }

    //@Transactional(readOnly = true)
    public RentalCard getRentalCardById(Long rentalCardId) {
        return rentalCardRepository.findById(rentalCardId).orElseThrow(() -> new IllegalArgumentException("해당 대출 카드가 존재하지 않습니다."));
    }

    public void deleteRentalCard(Long rentalCardId) {
        RentalCard rentalCard = rentalCardRepository.findById(rentalCardId).orElseThrow(() -> new IllegalArgumentException("해당 대출 카드가"));
    }
}


