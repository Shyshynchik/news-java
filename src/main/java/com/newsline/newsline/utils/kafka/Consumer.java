package com.newsline.newsline.utils.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsline.newsline.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;

    @Autowired
    public Consumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        Article article = objectMapper.readValue(message, Article.class);

        System.out.println(article);
    }

}
