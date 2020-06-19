package com.lcevallo.springsecurity.resolutions.service.impl;

import com.lcevallo.springsecurity.resolutions.models.User;
import com.lcevallo.springsecurity.resolutions.repository.UserRepository;
import com.lcevallo.springsecurity.resolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User guardarUsuario(User user) {
        return this.userRepository.save(user);
    }
}
