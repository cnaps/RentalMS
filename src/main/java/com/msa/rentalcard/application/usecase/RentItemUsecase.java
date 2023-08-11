package com.msa.rentalcard.application.usecase;

import com.msa.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.msa.rentalcard.framework.web.dto.UserItemInputDTO;

public interface RentItemUsecase {
    public RentalCardOutputDTO rentItem(UserItemInputDTO rental) throws Exception;
}
