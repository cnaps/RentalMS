package com.msa.rentalcard.application.outputPort;

import com.msa.rentalcard.domain.model.RentalCard;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCardOuputPort {
    RentalCard loadRentalCard(String userId);
    RentalCard save(RentalCard rentalCard);
}
