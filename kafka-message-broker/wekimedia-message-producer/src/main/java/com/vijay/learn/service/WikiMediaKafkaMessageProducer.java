package com.vijay.learn.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikiMediaKafkaMessageProducer {

    // Inorder to send message to kafka broker we need KafkaTemplate

    private KafkaTemplate kafkaTemplate;

    public WikiMediaKafkaMessageProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishWikiMediaData() throws InterruptedException {
        // to read the real time data from wiki media we use event source
        EventHandler eventsHandler = new WikiMediaEventsHandler(kafkaTemplate, "wiki-topic");
        String eventSourceUrl = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventsHandler, URI.create(eventSourceUrl));
        EventSource eventSource = builder.build();

        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }


}
