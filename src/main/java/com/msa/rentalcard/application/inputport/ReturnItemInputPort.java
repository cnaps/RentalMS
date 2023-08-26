package com.msa.rentalcard.application.inputport;

import com.msa.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.msa.rentalcard.application.usecase.ReturnItemUsercase;
import com.msa.rentalcard.domain.model.RentalCard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msa.rentalcard.application.outputport.RentalCardOuputPort;
import com.msa.rentalcard.domain.model.vo.Item;
import com.msa.rentalcard.framework.web.dto.UserItemInputDTO;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
@Transactional
public class ReturnItemInputPort implements ReturnItemUsercase {

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

        //반납 이벤트 발행 필요

        return RentalCardOutputDTO.mapToDTO(rental);
      }

    
}
