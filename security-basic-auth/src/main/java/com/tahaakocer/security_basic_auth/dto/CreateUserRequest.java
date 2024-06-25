package com.tahaakocer.security_basic_auth.dto;

import com.tahaakocer.security_basic_auth.model.enums.Role;
import java.util.Set;

public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
) {
}
