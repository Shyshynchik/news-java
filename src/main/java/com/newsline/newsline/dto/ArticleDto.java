package com.newsline.newsline.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ArticleDto {

    private int id;
    private String title;
    private Date date;
    private String annotation;
    private String body;
    private Integer counter;

}
