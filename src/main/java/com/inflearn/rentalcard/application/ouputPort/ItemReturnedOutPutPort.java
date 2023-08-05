package com.inflearn.rentalcard.application.ouputPort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inflearn.rentalcard.domain.model.event.ItemReturned;

public interface ItemReturnedOutPutPort {
    public void occurEvent(ItemReturned itemReturnedEvent) throws JsonProcessingException;
}
