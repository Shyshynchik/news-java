package com.newsline.newsline.controller;

import com.newsline.newsline.dto.ArticleDto;
import com.newsline.newsline.model.Article;
import com.newsline.newsline.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/articles/")
public class NewsController {


    private final ArticleService articleService;

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
        if (articleService.create(article)) {
            return new ResponseEntity<>("Created", HttpStatus.OK);
        }
        return new ResponseEntity<>("File already exists", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteArticle(@PathVariable(name = "id") int id) {
        var test = articleService.deleteArticle(id);
        return new ResponseEntity<>("DELETED " + test, HttpStatus.OK);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateArticle(@PathVariable(name = "id") int id, @RequestBody ArticleDto articleDto) {
        if (articleService.update(articleDto, id)) {
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }

        return new ResponseEntity<>("File doesn't exists", HttpStatus.BAD_REQUEST);
    }

}
