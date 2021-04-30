package com.example.dao;

import com.example.models.User;
import com.example.models.Vacancy;

public interface UserDao extends AbstractDao<User>{

    User getByLogin(String login);

    void addVac(User user, Vacancy vacancy);
    void delVac(User user, Vacancy vacancy);
    void newUser(User user);
}
