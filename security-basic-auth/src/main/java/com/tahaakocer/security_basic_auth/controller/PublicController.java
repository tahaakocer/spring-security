package com.tahaakocer.security_basic_auth.controller;

import com.tahaakocer.security_basic_auth.dto.CreateUserRequest;
import com.tahaakocer.security_basic_auth.model.User;
import com.tahaakocer.security_basic_auth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping
    public String helloWorld() {
        return "Hello World! from public endpoint";
    }

}