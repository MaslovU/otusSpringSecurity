package com.maslov.securityhomework.domain;

public enum Role {
    USER("user");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
