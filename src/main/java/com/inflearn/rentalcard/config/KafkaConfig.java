package com.inflearn.rentalcard.config;

import com.inflearn.rentalcard.domain.model.event.ItemRented;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

public class KafkaConfig {
    @Bean
    public KafkaTemplate<String, ItemRented> kafkaTemplate(ProducerFactory<String, ItemRented> producerFactory) {
        KafkaTemplate<String, ItemRented> kafkaTemplate = new KafkaTemplate<>(producerFactory);
        kafkaTemplate.setDefaultTopic("exam");
        kafkaTemplate.setMessageConverter(new StringJsonMessageConverter()); // JSON 직렬화 MessageConverter 사용
        return kafkaTemplate;
    }
}
