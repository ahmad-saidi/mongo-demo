package com.training.mongo.demo.controller;

import com.training.mongo.demo.model.dto.UserDTO;
import com.training.mongo.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("{id}")
    public UserDTO getUserById(@PathVariable String id){
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        return userService.adduser(userDTO);
    }
}
