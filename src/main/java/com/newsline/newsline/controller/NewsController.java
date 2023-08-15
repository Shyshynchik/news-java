package com.newsline.newsline.controller;

import com.newsline.newsline.dto.ArticleDto;
import com.newsline.newsline.model.Article;
import com.newsline.newsline.service.ArticleService;
import com.newsline.newsline.service.KafkaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/articles/")
public class NewsController {


    private final ArticleService articleService;
    private final KafkaService kafkaService;

    public NewsController(ArticleService articleService, KafkaService kafkaService) {
        this.articleService = articleService;
        this.kafkaService = kafkaService;
    }

    @GetMapping("/get/{id}")
    public @ResponseBody Article getArticleById(@PathVariable(name = "id") int id) {
        var article = articleService.getArticleById(id);

        kafkaService.send(article);

        return articleService.getArticleById(id);
    }

    public @ResponseBody List<Article> getArticlesByTitle(@PathVariable(name = "title") String title) {
        return articleService.getArticlesByTitle(title);
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
