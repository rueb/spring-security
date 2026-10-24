package com.jwt.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwt.project.entities.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
