package com.geiko.services;

import com.geiko.models.User;
import com.geiko.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Андрей on 10.04.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
