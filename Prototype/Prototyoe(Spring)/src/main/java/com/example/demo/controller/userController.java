package com.example.demo.controller;

import com.example.demo.service.UserCanUse;
import com.example.demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class userController {

    private final UserCanUse userService;
    public userController(UserCanUse userService){this.userService= userService;}

    @GetMapping("/list")
    public Iterable<User> list(){return userService.list();}
}
