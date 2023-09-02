package com.msa.rentalcard.framework.kafkaadapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.msa.rentalcard.application.outputport.EventOuputPort;
import com.msa.rentalcard.domain.model.event.ItemRented;
import com.msa.rentalcard.domain.model.event.ItemReturned;
import com.msa.rentalcard.domain.model.event.OverdueCleared;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalKafkaProducer implements EventOuputPort {

    private static final String TOPIC_RENT = "rental_rent";
    private static final String TOPIC_RETURN = "rental_return";
    private static final String TOPIC_CLEAR = "overdue_clear";


    private final KafkaTemplate<String, ItemRented> kafkaTemplate1;

    private final KafkaTemplate<String, ItemReturned> kafkaTemplate2;

    private final KafkaTemplate<String, OverdueCleared> kafkaTemplate3;


    @Override
    public void occurRentalEvent(ItemRented rentalItemEvent) throws JsonProcessingException {
        this.kafkaTemplate1.send(TOPIC_RENT, rentalItemEvent);
    }

    @Override
    public void occurReturnEvent(ItemReturned itemReturnedEvent) throws JsonProcessingException {
        this.kafkaTemplate2.send(TOPIC_RETURN, itemReturnedEvent);
    }

    @Override
    public void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException {
        this.kafkaTemplate3.send(TOPIC_CLEAR, overdueCleared);
    }
}
