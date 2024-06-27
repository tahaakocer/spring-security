package com.tahaakocer.security_jwt_token.dto;

public record AuthRequest(
        String username,
        String password
) {
}
