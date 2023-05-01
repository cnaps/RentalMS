package com.inflearn.rentalcard.application.usecase;

import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.domain.model.vo.IDName;

public interface CreateRentalCardUsecase {
    
    public RentalCard createRentalCard(IDName owner);
    
}
