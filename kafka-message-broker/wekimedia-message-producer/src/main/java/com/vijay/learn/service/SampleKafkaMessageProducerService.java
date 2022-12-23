package com.vijay.learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SampleKafkaMessageProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleKafkaMessageProducerService.class);

    private KafkaTemplate kafkaTemplate;

    public SampleKafkaMessageProducerService(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSampleMessage(String message){
        LOGGER.info(String.format("Message : %s, is written to kafka topic: %s", message, "wiki-topic"));
        kafkaTemplate.send("wiki-topic", message);
    }


}
