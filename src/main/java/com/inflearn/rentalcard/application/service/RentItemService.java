package com.inflearn.rentalcard.application.service;

import com.inflearn.rentalcard.domain.repository.RentalCardRepository;

@Service
public class RentItemService {

    private final RentalCardRepository rentalCardRepository;

     
    public RentItemService(RentalCardRepository rentalCardRepository)
    {
        this.rentalCardRepository = rentalCardRepository;
    }

    // 대여 비즈니스 로직
    public RentalDto rentBook(RentalDto rentalDto) {
        
        //도서 서비스에 도서 유효성 체크 한뒤 (ID 및 대여가능여부)
        //도서 대여 됬음으로 재고 처리  
        // Book book = bookRepository.findById(rentalDto.getBookId())
        //         .orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));
        // if (book.isRented()) {
        //     throw new IllegalStateException("The book is already rented");
        // }
        // book.setRented(true);
        // bookRepository.save(book);

        
        rentalCardRepository.findByMember(rnt)
        rental.setUser(new User(rentalDto.getUserId()));
        rental.setBook(book);
        rental.setRentedDate(LocalDate.now());
        rentalRepository.save(rental);

        return RentalDto.fromEntity(rental);
    }

}
