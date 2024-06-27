package com.tahaakocer.security_basic_auth.dto;

public record AuthRequest(
        String username,
        String password
) {
}
