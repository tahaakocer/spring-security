package com.tahaakocer.security_basic_auth.controller;

import com.tahaakocer.security_basic_auth.dto.CreateUserRequest;
import com.tahaakocer.security_basic_auth.model.User;
import com.tahaakocer.security_basic_auth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private")
public class PrivateController {

    private final UserService userService;

    public PrivateController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String helloWorldPrivate() {
        return "Hello World! from private endpoint";
    }

    @GetMapping("/user")
    public String helloWorldUserPrivate() {
        return "Hello World! from user private endpoint";
    }

    @GetMapping("/admin")
    public String helloWorldAdminPrivate() {
        return "Hello World! from admin private endpoint";
    }


    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(request));
    }

}