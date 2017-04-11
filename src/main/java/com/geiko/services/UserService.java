package com.geiko.services;

import com.geiko.models.User;

/**
 * Created by Андрей on 10.04.2017.
 */
public interface UserService {
    User findByName(String name);
    void save(User user);
}
