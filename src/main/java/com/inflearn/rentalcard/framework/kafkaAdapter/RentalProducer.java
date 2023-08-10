package com.inflearn.rentalcard.framework.kafkaAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inflearn.rentalcard.application.outputPort.ItemRentedOuputPort;
import com.inflearn.rentalcard.domain.model.event.ItemRented;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalProducer implements ItemRentedOuputPort {

    private final Logger log = LoggerFactory.getLogger(RentalProducer.class);

    private static final String TOPIC = "exam";
    private static final String TOPIC_CATALOG = "topic_catalog";
    private static final String TOPIC_POINT = "topic_point";

    private final KafkaTemplate<String, ItemRented> kafkaTemplate;

    private KafkaProducer<String, String> producer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(String message) {
        System.out.printf("Produce message : %s%n", message);
    //    this.kafkaTemplate.send(TOPIC, message);
    }

    @Override
    public void occurEvent(ItemRented rentalItemEvent) {
 //       String msg = objectMapper.writeValueAsString(rentalItemEvent);
        this.kafkaTemplate.send(TOPIC, rentalItemEvent);
    }

}
