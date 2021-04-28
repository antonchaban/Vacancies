package com.example.dao.impl.inmemory;

import com.example.dao.DaoFactory;
import com.example.dao.UserDao;
import com.example.dao.VacancyDao;

public class InMemoryDaoFactory implements DaoFactory {
    InMemoryDatabase database;

    VacancyDao vacancyDao;
    UserDao userDao;

    InMemoryDaoFactory(InMemoryDatabase database) {
        this.database = database;

        vacancyDao = new InMemoryVacancyDao(database);
        userDao = new InMemoryUserDao(database);
    }

    @Override
    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public VacancyDao getVacancyDao() {
        return vacancyDao;
    }
}
