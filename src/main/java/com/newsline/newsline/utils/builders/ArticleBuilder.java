package com.newsline.newsline.utils.builders;

import com.newsline.newsline.model.Article;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public interface ArticleBuilder {

    ArticleBuilder setTitle(String title);
    ArticleBuilder setDate(Date date);
    ArticleBuilder setAnnotation(String annotation);
    ArticleBuilder setBody(String body);
    ArticleBuilder setCounter(Integer counter);

    ArticleBuilder setArticleEntity(Article article);

    Article build();
}
