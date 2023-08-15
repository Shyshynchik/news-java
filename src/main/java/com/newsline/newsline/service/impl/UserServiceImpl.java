package com.newsline.newsline.service.impl;

import com.newsline.newsline.model.User;
import com.newsline.newsline.repository.RoleRepository;
import com.newsline.newsline.repository.UserRepository;
import com.newsline.newsline.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    @Override
    public User findByToken(String token) {
        return userRepository.findByToken(token);
    }
}
