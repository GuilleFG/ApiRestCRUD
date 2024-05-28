package com.guillermo.curso.springboot.app.springbootcrud.services;

import com.guillermo.curso.springboot.app.springbootcrud.entities.Role;
import com.guillermo.curso.springboot.app.springbootcrud.entities.User;
import com.guillermo.curso.springboot.app.springbootcrud.repositories.RoleRepository;
import com.guillermo.curso.springboot.app.springbootcrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repository.findAll();

    }

    @Override
    @Transactional
    public User save(User user) {
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optionalRoleUser.ifPresent(roles::add);

        if (user.isAdmin()){
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }
        user.setRoles(roles);

        //se le codifica el password pasandole el password que aun no esta codificado
        user.setPassword(passwordEncoder.encode((user.getPassword())));

        return repository.save(user);
    }
}
