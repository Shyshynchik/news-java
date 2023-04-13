package com.newsline.newsline.service;

import com.newsline.newsline.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User findUserById(Long userId);

    User findByToken(String token);

}
