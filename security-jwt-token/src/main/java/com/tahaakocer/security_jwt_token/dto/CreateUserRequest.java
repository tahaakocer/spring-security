package com.tahaakocer.security_jwt_token.dto;


import com.tahaakocer.security_jwt_token.model.enums.Role;

import java.util.Set;

public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
) {
}
