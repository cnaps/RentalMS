package com.msa.rentalcard.application.inputPort;

import javax.transaction.Transactional;

import com.msa.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.msa.rentalcard.framework.web.dto.UserInputDTO;
import com.msa.rentalcard.domain.model.RentalCard;
import org.springframework.stereotype.Service;

import com.msa.rentalcard.application.outputPort.RentalCardOuputPort;
import com.msa.rentalcard.application.usecase.CreateRentalCardUsecase;
import com.msa.rentalcard.domain.model.vo.IDName;
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
