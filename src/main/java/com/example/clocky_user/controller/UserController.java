package com.example.clocky_user.controller;

import com.example.clocky_user.Payload.Request.RegisterRequest;
import com.example.clocky_user.model.User;
import com.example.clocky_user.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/User")
@RestController
public class UserController {
    public final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json")
    public User insert(@RequestBody RegisterRequest registerRequest){
        return userRepository.save(
                new User(registerRequest.getName(), registerRequest.getPassword())
        );

    }

    @GetMapping("/insert/{id}")
    public String insertGet(@PathVariable("id") Long id){
        return userRepository.findById(id).orElse(null).toString();
    }

    @GetMapping(value = "/select/{id}", produces = "application/json")
    public String select(@PathVariable("id") Long id){
        return userRepository.findById(id).orElse(null).toString();
    }
}
