package com.newsline.newsline.service;

import com.newsline.newsline.model.Article;

public interface KafkaService {

    void send(Article article);

}
