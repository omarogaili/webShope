package com.loginapp.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.loginapp.login.model.Product;

public interface ProductsRepository extends  CrudRepository<Product, Long> {
}
