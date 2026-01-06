package com.loginapp.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.loginapp.login.model.User;

public interface  UserRepository extends  CrudRepository<User, Long>{
}
