package com.inflearn.rentalcard.application.usecase;

import com.inflearn.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.inflearn.rentalcard.framework.web.dto.UserItemInputDTO;

public interface OverdueItemUsercase {
    public RentalCardOutputDTO overDueItem(UserItemInputDTO rental) throws Exception;

}
