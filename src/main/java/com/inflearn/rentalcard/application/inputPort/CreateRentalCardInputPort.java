package com.inflearn.rentalcard.application.inputPort;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.inflearn.rentalcard.application.ouputPort.RentalCardOuputPort;
import com.inflearn.rentalcard.application.usecase.CreateRentalCardUsecase;
import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.domain.model.vo.IDName;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUsecase{

    private final RentalCardOuputPort rentalCardOuputPort;

    @Override
    public RentalCard createRentalCard(IDName owner) {
        return rentalCardOuputPort.save(Optional.of(RentalCard.createRentalCard(owner)));
    }
    
}
