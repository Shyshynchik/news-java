package com.newsline.newsline.service.impl;

import com.newsline.newsline.model.Article;
import com.newsline.newsline.repository.ArticleRepository;
import com.newsline.newsline.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article getArticleById(int id) {
        return articleRepository.findArticlesById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public boolean create(Article article) {

        articleRepository.save(article);

        return false;
    }

    @Override
    public boolean isExistedById(int id) {
        return articleRepository.existsById(id);
    }

    @Override
    public long deleteArticle(int id) {
        return articleRepository.removeById(id);
    }
}
