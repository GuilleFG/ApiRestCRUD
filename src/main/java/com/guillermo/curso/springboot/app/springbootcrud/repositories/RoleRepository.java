package com.guillermo.curso.springboot.app.springbootcrud.repositories;

import com.guillermo.curso.springboot.app.springbootcrud.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository <Role, Long> {

}
