package com.newsline.newsline.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterArticleGet {

    @AfterReturning(value = "execution(* com.newsline.newsline.service.impl.ArticleServiceImpl.getArticleById(..))", returning = "returnValue")
    public void afterReturn(JoinPoint joinPoint, Object returnValue) {
        System.out.println("after");
    }

    @Before("execution(* com.newsline.newsline.service.impl.ArticleServiceImpl.getArticleById(..))")
    public void beforeExecution() {
        System.out.println("before");
    }

    @AfterThrowing("execution(* com.newsline.newsline.controller.NewsController.createArticle(..))")
    public void beforeControllerCreate(JoinPoint joinPoint) {
        System.out.println("before");
    }

}
