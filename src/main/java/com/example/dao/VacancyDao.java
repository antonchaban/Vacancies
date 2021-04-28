package com.example.dao;

import com.example.models.User;
import com.example.models.Vacancy;

import java.util.Collection;
import java.util.HashMap;

public interface VacancyDao extends AbstractDao<Vacancy>{
    Collection<Vacancy> findByText(String string);
    HashMap<Integer,Vacancy> findByUserID(Integer userId);
    void addVac(Vacancy vacancy, User user);
    void delVac(Vacancy vacancy, User user);
}
