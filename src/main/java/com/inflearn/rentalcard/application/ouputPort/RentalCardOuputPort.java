package com.inflearn.rentalcard.application.ouputPort;

import com.inflearn.rentalcard.domain.model.RentalCard;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalCardOuputPort {
    public RentalCard loadRentalCard(String userId);
    public RentalCard save(RentalCard rentalCard);
}
