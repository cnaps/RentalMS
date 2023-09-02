package com.msa.rentalcard.application.outputport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.msa.rentalcard.domain.model.event.ItemRented;
import com.msa.rentalcard.domain.model.event.ItemReturned;
import com.msa.rentalcard.domain.model.event.OverdueCleared;

public interface EventOuputPort {
    public void occurRentalEvent(ItemRented rentalItemEvent) throws JsonProcessingException;

    public void occurReturnEvent(ItemReturned itemReturnedEvent) throws JsonProcessingException;

    public void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException;

}
