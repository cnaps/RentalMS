package com.inflearn.rentalcard.application.ouputPort;

import com.inflearn.rentalcard.domain.model.RentalCard;

public interface RentalCardOuputPort {
    public RentalCard loadRentalCard(String userId);
    public RentalCard save(RentalCard rentalCard);
}
