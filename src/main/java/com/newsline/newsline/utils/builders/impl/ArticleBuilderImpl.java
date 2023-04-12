package com.newsline.newsline.utils.builders.impl;

import com.newsline.newsline.model.Article;
import com.newsline.newsline.utils.builders.ArticleBuilder;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class ArticleBuilderImpl implements ArticleBuilder {

    private String title;
    private Date date;
    private String annotation;
    private String body;
    private Integer counter;

    private Article article;

    @Override
    public ArticleBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public ArticleBuilder setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public ArticleBuilder setAnnotation(String annotation) {
        this.annotation = annotation;
        return this;
    }

    @Override
    public ArticleBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public ArticleBuilder setCounter(Integer counter) {
        this.counter = counter;
        return this;
    }

    @Override
    public ArticleBuilder setArticleEntity(Article article) {
        this.article = article;
        return this;
    }

    @Override
    public Article build() {
        if (article == null) {
            return null;
        }
        if (title != null) {
            article.setTitle(title);
        }
        if (date != null) {
            article.setDate(date);
        }
        if (annotation != null) {
            article.setAnnotation(annotation);
        }
        if (body != null) {
            article.setBody(body);
        }
        if (counter != null) {
            article.setCounter(counter);
        }

        return article;
    }
}
