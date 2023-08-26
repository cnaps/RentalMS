package com.msa.rentalcard.application.outputport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.msa.rentalcard.domain.model.event.ItemRented;

public interface ItemRentedOuputPort {
    public void occurEvent(ItemRented rentalItemEvent) throws JsonProcessingException;
}
