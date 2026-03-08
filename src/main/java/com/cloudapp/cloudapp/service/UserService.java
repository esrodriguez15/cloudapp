package com.cloudapp.cloudapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cloudapp.cloudapp.model.User;
import com.cloudapp.cloudapp.repository.UserRepository;

/*
*Business logiv for managing users
*/
@Service
public class UserService {

    //logger
    private static final org.slf4j.Logger log =
        org.slf4j.LoggerFactory.getLogger(UserService.class);
    
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    //find all stored users
    public List<User> findAll() {
        log.debug("Fetching all users from database"); //log
        return repo.findAll();
    }

    //finds all users by id
    public User findById(Integer id) {
        log.debug("Fetching user: {}", id); //log
        return repo.findById(id).orElse(null);
    }


    //saves new user 
    public User save(User user) {
        log.info("Saving user: {}", user.getEmail()); //log
        return repo.save(user);
    }

    //deletes user by id
    public void deleteById(Integer id) {
        log.warn("Deleting user: {}", id);
        repo.deleteById(id);
    }
}
