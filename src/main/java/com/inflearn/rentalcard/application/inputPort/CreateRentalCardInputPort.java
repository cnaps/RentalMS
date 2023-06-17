package com.inflearn.rentalcard.application.inputPort;

import javax.transaction.Transactional;

import com.inflearn.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.inflearn.rentalcard.framework.web.dto.UserInputDTO;
import org.springframework.stereotype.Service;

import com.inflearn.rentalcard.application.ouputPort.RentalCardOuputPort;
import com.inflearn.rentalcard.application.usecase.CreateRentalCardUsecase;
import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.domain.model.vo.IDName;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUsecase{

    private final RentalCardOuputPort rentalCardOuputPort;

    @Override
    public RentalCardOutputDTO createRentalCard(UserInputDTO owner) {

        RentalCard rentalCard1 = RentalCard.createRentalCard(new IDName(owner.getUserId(), owner.getUserNm()));
        RentalCard rentalCard = rentalCardOuputPort.save(rentalCard1);
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
    
}
