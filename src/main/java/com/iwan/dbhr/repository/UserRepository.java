package com.iwan.dbhr.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.iwan.dbhr.model.User;
import com.iwan.dbhr.repository.generic.GenericRepository;

@Repository
public interface UserRepository extends GenericRepository<User> {

    Optional<User> findByUsername(String username);
}
