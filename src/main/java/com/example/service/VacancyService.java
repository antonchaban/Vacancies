package com.example.service;

import com.example.models.User;
import com.example.models.Vacancy;

import java.util.Collection;
import java.util.HashMap;

public interface VacancyService {
    Collection<Vacancy> getAllVacancies();
    Collection<Vacancy> searchByReq(HashMap<String, Object> req);
    Collection<Vacancy> searchByText(String string);
    Vacancy getVacById(Integer vacId);
    void delVac(Vacancy vacancy, User user);
    void updVac(Vacancy vacancy);
    void newVac(Vacancy vacancy, User user);


}
