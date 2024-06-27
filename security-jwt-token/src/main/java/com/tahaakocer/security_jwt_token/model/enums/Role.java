package com.tahaakocer.security_jwt_token.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER( "USER"),

    ROLE_ADMIN("ADMIN"),
    ROLE_MOD("MOD"),
    ROLE_TAHA("TAHA");
    private String value;

    Role(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
    @Override
    public String getAuthority() {
        return name();
    }
}
