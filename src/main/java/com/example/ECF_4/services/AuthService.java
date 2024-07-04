package com.example.ECF_4.services;

import com.example.ECF_4.entities.User;

public interface AuthService {
    boolean login(String username, String password);
    boolean isLogged();
    User register(User user);
    void deconnexion();
}
