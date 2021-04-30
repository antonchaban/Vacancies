package com.example.dao.impl.inmemory;

import com.example.dao.VacancyDao;
import com.example.models.User;
import com.example.models.Vacancy;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryVacancyDao extends InMemoryAbstractDao<Vacancy> implements VacancyDao {
    InMemoryVacancyDao(InMemoryDatabase database) {
        super(database.vacancies, Vacancy::getVacId, Vacancy::setVacId, database);
    }

    @Override
    public Collection<Vacancy> findByText(String string) {
        String[] words = string.toLowerCase().split(" ");
        return database.vacancies.values().stream()
                .filter(movie -> containsAllWords(movie, words))
                .collect(Collectors.toList());
    }



    @Override
    public HashMap<Integer, Vacancy> findByUserID(Integer userId) {
        return database.vacancies.values()
                .stream()
                .filter(vacancy -> vacancy.getUserId().equals(userId))
                .collect(Collectors.toMap(Vacancy::getVacId, Function.identity(), (prev, next) -> next, HashMap::new));

    }

    @Override
    public void addVac(Vacancy vacancy, User user) {
        this.insert(vacancy, true);
        vacancy.setVacId(this.idGetter.apply(vacancy));
        HashMap newVac = findByUserID(user.getUserId());
        user.setMyVacs(newVac);

    }

    @Override
    public void delVac(Vacancy vacancy, User user) {
        this.delete(vacancy);
        HashMap newVac = findByUserID(user.getUserId());
        user.setMyVacs(newVac);

    }

    private static boolean containsAllWords(Vacancy vacancy, String[] words) {
        String string = vacancy.getVacName() + " " + vacancy.getDescription();
        string = string.toLowerCase();
        return Stream.of(words).allMatch(string::contains);
    }
}
