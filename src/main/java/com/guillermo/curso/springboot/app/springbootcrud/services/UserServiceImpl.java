package com.guillermo.curso.springboot.app.springbootcrud.services;

import com.guillermo.curso.springboot.app.springbootcrud.entities.User;
import com.guillermo.curso.springboot.app.springbootcrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repository.findAll();

    }

    @Override
    @Transactional
    public User save(User user) {
        return repository.save(user);
    }
}
