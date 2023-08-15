package com.newsline.newsline.service;

import com.newsline.newsline.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findUserById(Long userId);

    User findByToken(String token);

}
