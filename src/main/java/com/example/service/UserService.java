package com.example.service;

import com.example.models.User;

public interface UserService {
    User getByLogin(String login);
    User getById(Integer userId);
    boolean checkPass(User user, String password);
    boolean checkUser(String user);
    void newUser(User user);
}
