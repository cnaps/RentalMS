package com.msa.rentalcard.framework.kafkaAdapter;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class RentalEventConsumers {

    private final Logger log = LoggerFactory.getLogger(RentalEventConsumers.class);

    public static final String TOPIC = "topic_kafka";

//    @KafkaListener(topics = "exam",groupId = "foo0")
//    public void consume(String message) throws IOException {
//        System.out.printf("Consumed message : %s%n", message);
//    }
}
