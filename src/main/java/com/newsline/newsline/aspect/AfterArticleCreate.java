package com.newsline.newsline.aspect;

import com.newsline.newsline.model.Article;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class AfterArticleCreate {

    private static final Logger log = Logger.getLogger(AfterArticleCreate.class.getName());


    @Before("execution(* com.newsline.newsline.controller.NewsController.createArticle(..))")
    public void logBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof Article article) {
            log.info("/create added " + article);
        }
    }

    @AfterReturning(value = "execution(* com.newsline.newsline.controller.NewsController.createArticle(..))", returning = "result")
    public void logBefore(JoinPoint joinPoint, Object result) {
        if (result instanceof ResponseEntity<?> responseEntity) {
            logResponseEntity(responseEntity);
        }
    }

    @AfterReturning(value = "execution(* com.newsline.newsline.controller.RestExceptionHandler.handleAllExceptionMethod(..))", returning = "result")
    public void logBeforeThrowing(JoinPoint joinPoint, Object result) {
        if (result instanceof ResponseEntity<?> responseEntity) {
            logResponseEntity(responseEntity);
        }
    }

    private void logResponseEntity(ResponseEntity<?> responseEntity) {
        String message = (String) responseEntity.getBody();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response body = ");
        if (message != null) {
            stringBuilder.append(message.replaceAll("\n", ""));
        }
        stringBuilder.append(" and code = ");
        stringBuilder.append(responseEntity.getStatusCode());

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            log.warning(stringBuilder.toString());
        } else {
            log.info(stringBuilder.toString());
        }
    }


}
