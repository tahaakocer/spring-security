package com.tahaakocer.security_basic_auth.service;

import com.tahaakocer.security_basic_auth.dto.CreateUserRequest;
import com.tahaakocer.security_basic_auth.model.User;
import com.tahaakocer.security_basic_auth.repository.UserRepository;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUsername(String userName) {
        return this.userRepository.findByUsername(userName);

    }

    public User createUser(CreateUserRequest request) {
        User user  = User.builder()
                .name(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .accountNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();

    return this.userRepository.save(user);
    }
}
