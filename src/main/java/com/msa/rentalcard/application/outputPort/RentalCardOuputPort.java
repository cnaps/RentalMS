package com.msa.rentalcard.application.outputPort;

import com.msa.rentalcard.domain.model.RentalCard;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCardOuputPort {
    public RentalCard loadRentalCard(String userId);
    public RentalCard save(RentalCard rentalCard);
}
