package com.jwt.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwt.project.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
