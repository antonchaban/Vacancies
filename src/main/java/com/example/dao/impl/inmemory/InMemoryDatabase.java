package com.example.dao.impl.inmemory;

import com.example.dao.DaoFactory;
import com.example.models.*;
import java.util.*;

public class InMemoryDatabase {
    Map<Integer, User> users;
    Map<Integer, Vacancy> vacancies;

    public InMemoryDatabase() {
        vacancies = new TreeMap<>();
        users = new TreeMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new InMemoryDaoFactory(this);
    }
}
