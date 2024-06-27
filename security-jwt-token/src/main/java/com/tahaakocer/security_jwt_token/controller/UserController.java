package com.tahaakocer.security_jwt_token.controller;


import com.tahaakocer.security_jwt_token.dto.AuthRequest;
import com.tahaakocer.security_jwt_token.dto.CreateUserRequest;
import com.tahaakocer.security_jwt_token.model.User;
import com.tahaakocer.security_jwt_token.service.JwtService;
import com.tahaakocer.security_jwt_token.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@Slf4j
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome";
    }

    @PostMapping("/addNewUser")
    public User addNewUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }
    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(request.username());
        }
        log.info("invalid username {}" + request.username());
        throw new RuntimeException("Invalid username {}" + request.username());
    }
    @GetMapping("/user")
    public String getUserString() {
        return "User";
    }

    @GetMapping("/admin")
    public String getAdminString() {
        return "Admin";
    }

}
