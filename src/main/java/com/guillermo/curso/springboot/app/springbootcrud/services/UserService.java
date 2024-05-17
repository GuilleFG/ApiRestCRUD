package com.guillermo.curso.springboot.app.springbootcrud.services;

import com.guillermo.curso.springboot.app.springbootcrud.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);


}
