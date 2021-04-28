package com.example.dao;

public interface DaoFactory {
    UserDao getUserDao();
    VacancyDao getVacancyDao();
}
