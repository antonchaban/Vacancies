package com.example.service;

import com.example.dao.DaoFactory;
import com.example.models.User;
import com.example.models.Vacancy;

import java.util.Collection;

public class VacancyServiceImpl implements VacancyService {
    DaoFactory daoFactory;

    public VacancyServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Collection<Vacancy> getAllVacancies() {
        return daoFactory.getVacancyDao().findAll();
    }


    @Override
    public Collection<Vacancy> searchByText(String string) {
        if (string == null || string.equals("")) {
            return getAllVacancies();
        }
        return daoFactory.getVacancyDao().findByText(string);
    }

    @Override
    public Vacancy getVacById(Integer vacId) {
        return daoFactory.getVacancyDao().get(vacId);
    }

    @Override
    public void delVac(Vacancy vacancy, User user) {
        daoFactory.getVacancyDao().delVac(vacancy, user);
    }

    @Override
    public void updVac(Vacancy vacancy) {
        daoFactory.getVacancyDao().update(vacancy);
    }

    @Override
    public void newVac(Vacancy vacancy, User user) {
        daoFactory.getVacancyDao().addVac(vacancy, user);
    }
}
