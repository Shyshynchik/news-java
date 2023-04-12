package com.newsline.newsline.controller;

import com.newsline.newsline.model.Article;
import com.newsline.newsline.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/articles/")
public class NewsController {


    private ArticleService articleService;

    public NewsController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/get/{id}")
    public @ResponseBody Article getArticleById(@PathVariable(name = "id") int id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("/all")
    public @ResponseBody List<Article> getAllArticles() {
        return articleService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createArticle(@Validated @RequestBody Article article) {
        articleService.create(article);
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteArticle(@PathVariable(name = "id") int id) {
        var test = articleService.deleteArticle(id);
        return new ResponseEntity<>("DELETED " + test, HttpStatus.OK);
    }

}
