package com.newsline.newsline.service.impl;

import com.newsline.newsline.dto.ArticleDto;
import com.newsline.newsline.model.Article;
import com.newsline.newsline.repository.ArticleRepository;
import com.newsline.newsline.service.ArticleService;
import com.newsline.newsline.utils.builders.ArticleBuilder;
import com.newsline.newsline.utils.builders.impl.ArticleBuilderImpl;
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
        if (isExistedById(article.getId())) {
            return false;
        }
        articleRepository.save(article);

        return true;
    }

    @Override
    public boolean update(ArticleDto articleDto, int id) {
        Article article = getArticleById(id);

        if (article == null) {
            return false;
        }

        ArticleBuilder articleBuilder = new ArticleBuilderImpl();

        article = articleBuilder
                .setBody(articleDto.getBody())
                .setDate(articleDto.getDate())
                .setTitle(articleDto.getTitle())
                .setAnnotation(articleDto.getAnnotation())
                .setCounter(articleDto.getCounter())
                .setArticleEntity(article)
                .build();

        articleRepository.save(article);

        return true;
    }

    @Override
    public boolean isExistedById(int id) {
        return articleRepository.existsById(id);
    }

    @Override
    public long deleteArticle(int id) {
        return articleRepository.removeById(id);
    }

    @Override
    public List<Article> getArticlesByTitle(String title) {
        return articleRepository.findArticlesByTitle(title);
    }
}
