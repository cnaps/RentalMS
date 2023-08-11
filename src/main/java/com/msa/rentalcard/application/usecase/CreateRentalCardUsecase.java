package com.inflearn.rentalcard.application.usecase;

import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.inflearn.rentalcard.framework.web.dto.UserInputDTO;

public interface CreateRentalCardUsecase {
    
    public RentalCardOutputDTO createRentalCard(UserInputDTO userInputDTO);
    
}
