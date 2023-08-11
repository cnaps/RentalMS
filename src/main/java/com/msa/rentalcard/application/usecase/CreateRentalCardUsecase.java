package com.msa.rentalcard.application.usecase;

import com.msa.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.msa.rentalcard.framework.web.dto.UserInputDTO;

public interface CreateRentalCardUsecase {
    
    public RentalCardOutputDTO createRentalCard(UserInputDTO userInputDTO);
    
}
