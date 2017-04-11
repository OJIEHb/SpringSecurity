package com.geiko.repositories;

import com.geiko.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Андрей on 10.04.2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    User findByUsername(String name);
}
