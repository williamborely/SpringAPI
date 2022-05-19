package com.portal.v1.controller;

import java.util.List;

import com.portal.v1.model.User;
import com.portal.v1.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{username}")
    public User getOneUser(@PathVariable("username") String username){
        return userRepository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }

    @PostMapping()
    public void postUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @PutMapping()
    public void putUser(@RequestBody User user){
        userRepository.save(user);
    }
}
