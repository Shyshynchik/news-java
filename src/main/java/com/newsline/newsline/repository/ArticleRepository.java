package com.newsline.newsline.repository;

import com.newsline.newsline.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Article findArticlesById(int id);

    boolean existsById(int id);

    @Transactional
    long removeById(int id);

    List<Article> findArticlesByTitle(String title);
}
