package com.loginapp.login.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import com.loginapp.login.model.User;

public interface  UserRepository extends  CrudRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
