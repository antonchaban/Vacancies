package com.example.service;

import com.example.dao.DaoFactory;
import com.example.models.User;

import java.util.function.UnaryOperator;

public class UserServiceImpl implements UserService {
    DaoFactory daoFactory;
    UnaryOperator<String> passHasher;

    public UserServiceImpl(DaoFactory daoFactory, UnaryOperator<String> passHasher) {
        this.daoFactory = daoFactory;
        this.passHasher = passHasher;
    }

    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getByLogin(login);
    }

    @Override
    public User getById(Integer userId) {
        return daoFactory.getUserDao().get(userId);
    }

    @Override
    public boolean checkPass(User user, String password) {
        return user.getPassword().equals(passHasher.apply(password));
    }

    @Override
    public boolean checkUser(String user) {
        if (daoFactory.getUserDao().getByLogin(user) == null) {
            return false;
        }
        return true;
    }

    @Override
    public void newUser(User user) {
        daoFactory.getUserDao().newUser(user);
    }

}
