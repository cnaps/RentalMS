package com.inflearn.rentalcard.application.ouputPort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inflearn.rentalcard.domain.model.event.ItemRented;

public interface ItemRentedOuputPort {
    public void occurEvent(ItemRented rentalItemEvent) throws JsonProcessingException;
}
