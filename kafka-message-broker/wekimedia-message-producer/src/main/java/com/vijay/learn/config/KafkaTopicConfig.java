package com.vijay.learn.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * This is a configuration class to create new kafka topic
 * which this spring boot application is subscribed to push the messages to kafka broker
 */

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("wiki-topic").build();

        // return TopicBuilder.name("wiki-topic").partitions(10).build();
    }
}
