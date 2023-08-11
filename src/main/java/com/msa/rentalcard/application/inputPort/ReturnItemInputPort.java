package com.inflearn.rentalcard.application.inputPort;

import com.inflearn.rentalcard.framework.web.dto.RentalCardOutputDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inflearn.rentalcard.application.outputPort.RentalCardOuputPort;
import com.inflearn.rentalcard.application.usecase.ReturnItemUsercase;
import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.domain.model.vo.Item;
import com.inflearn.rentalcard.framework.web.dto.UserItemInputDTO;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
@Transactional
public class ReturnItemInputPort implements ReturnItemUsercase{

    private final RentalCardOuputPort rentalCardOuputPort;

    @Override
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDto) throws Exception {
        // OutputPort를 사용해서 rental를 검색한 후 
        // 없으면 에러
        // 있으면 도서 반납
        // OutputPort에 저장 
        RentalCard rental = rentalCardOuputPort.loadRentalCard(returnDto.getUserId());
        
        if (rental == null) new IllegalArgumentException("해당 카드가 존재하지 않습니다.");

        rental = rental.returnItem(new Item(returnDto.getItemId(),returnDto.getItemTitle()), LocalDate.now());

        rental = rentalCardOuputPort.save(rental);

        return RentalCardOutputDTO.mapToDTO(rental);
      }

    
}
