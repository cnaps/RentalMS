package com.inflearn.rentalcard.application.usecase;

import com.inflearn.rentalcard.framework.web.dto.RentalInputDTO;
import com.inflearn.rentalcard.framework.web.dto.RentalResultOuputDTO;

public interface ReturnItemUsercase {
    public RentalResultOuputDTO returnItem(RentalInputDTO returnDto) throws Exception;
}
