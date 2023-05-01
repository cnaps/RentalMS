package com.inflearn.rentalcard.application.usecase;

import com.inflearn.rentalcard.framework.web.dto.RentalInputDTO;
import com.inflearn.rentalcard.framework.web.dto.RentalResultOuputDTO;

public interface RentItemUsecase {
    public RentalResultOuputDTO rentItem(RentalInputDTO rental);
}
