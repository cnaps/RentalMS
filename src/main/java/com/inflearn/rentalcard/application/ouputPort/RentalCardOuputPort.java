package com.inflearn.rentalcard.application.ouputPort;

import com.inflearn.rentalcard.domain.model.RentalCard;

import java.util.Optional;

public interface RentalCardOuputPort {
    public Optional<RentalCard> loadRentalCard(String userId);
    public RentalCard save(RentalCard rentalCard);
}
