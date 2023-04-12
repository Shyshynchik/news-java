package com.newsline.newsline.dto;

import lombok.Getter;

import java.sql.Date;

@Getter
public class ArticleDto {

    private int id;
    private String title;
    private Date date;
    private String annotation;
    private String body;
    private Integer counter;

}
