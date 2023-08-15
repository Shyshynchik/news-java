package com.newsline.newsline.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsline.newsline.model.Article;
import com.newsline.newsline.service.KafkaService;
import com.newsline.newsline.utils.kafka.Consumer;
import com.newsline.newsline.utils.kafka.Producer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaServiceImpl implements KafkaService {

    private final Producer producer;
    private final Consumer consumer;

    @Autowired
    public KafkaServiceImpl(Producer producer, Consumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }


    @Override
    @SneakyThrows
    public void send(Article article) {
        producer.sendMessage(article);
    }
}
