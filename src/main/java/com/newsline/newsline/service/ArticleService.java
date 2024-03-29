package com.newsline.newsline.service;

import com.newsline.newsline.dto.ArticleDto;
import com.newsline.newsline.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {

    Article getArticleById(int id);

    List<Article> getAll();

    boolean create(Article article);

    boolean isExistedById(int id);

    long deleteArticle(int id);

    boolean update(ArticleDto articleDto, int id);

    List<Article> getArticlesByTitle(String title);
}
