package com.inflearn.rentalcard.application.usecase;

import com.inflearn.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.inflearn.rentalcard.framework.web.dto.UserItemInputDTO;
import com.inflearn.rentalcard.framework.web.dto.RentalResultOuputDTO;

public interface RentItemUsecase {
    public RentalCardOutputDTO rentItem(UserItemInputDTO rental) throws Exception;
}
