package com.vijay.learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikiMediaKafkaMessageConsumerService {

    private final Logger LOGGER = LoggerFactory.getLogger(WikiMediaKafkaMessageConsumerService.class);

    @KafkaListener(topics = "wiki-topic", groupId = "myGroup")
    public void consumeMessage(String eventMessage) {
        LOGGER.info(String.format("Consumer:: Consuming eventMessage - %s", eventMessage));
    }
}
