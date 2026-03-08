package com.cloudapp.cloudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapp.cloudapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
