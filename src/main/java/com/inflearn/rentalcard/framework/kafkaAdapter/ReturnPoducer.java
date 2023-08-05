package com.inflearn.rentalcard.framework.kafkaAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inflearn.rentalcard.application.ouputPort.ItemReturnedOutPutPort;
import com.inflearn.rentalcard.domain.model.event.ItemReturned;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReturnPoducer implements ItemReturnedOutPutPort {

    private final Logger log = LoggerFactory.getLogger(RentalProducer.class);

    private static final String TOPIC = "exam";
    private static final String TOPIC_CATALOG = "topic_catalog";
    private static final String TOPIC_POINT = "topic_point";

    private final KafkaTemplate<String, String> kafkaTemplate;

    private KafkaProducer<String, String> producer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void occurEvent(ItemReturned itemReturnedEvent) throws JsonProcessingException {
       this.kafkaTemplate.send(TOPIC,objectMapper.writeValueAsString(itemReturnedEvent));
    }
}
