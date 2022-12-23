package com.vijay.learn;

import com.vijay.learn.service.WikiMediaKafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikimediaEventProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WikimediaEventProducerApplication.class, args);
    }

    @Autowired
    WikiMediaKafkaMessageProducer wikiMediaKafkaMessageProducer;

    @Override
    public void run(String... args) throws Exception {
        wikiMediaKafkaMessageProducer.publishWikiMediaData();
    }
}
