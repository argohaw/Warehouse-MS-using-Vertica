package com.sriram.warehouse_management.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService
{
    // In a real application, you should use a secure method for password handling
    private final String USERNAME = "user";
    private final String PASSWORD = "admin";

    public boolean authenticate(String username, String password) {
        System.out.println("SRIRAM LOG >> username: " + username + "and password: " + password);
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}
