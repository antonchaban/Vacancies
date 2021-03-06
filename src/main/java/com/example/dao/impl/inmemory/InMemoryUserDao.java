package com.example.dao.impl.inmemory;

import com.example.dao.UserDao;
import com.example.models.User;
import com.example.models.Vacancy;

public class InMemoryUserDao extends InMemoryAbstractDao<User> implements UserDao {
    InMemoryUserDao(InMemoryDatabase database) {
        super(database.users, User::getUserId, User::setUserId, database);
    }

    @Override
    public User getByLogin(String login) {
        return database.users.values()
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addVac(User user, Vacancy vacancy) {
        user.getMyVacs().put(vacancy.getVacId(), vacancy);
    }

    @Override
    public void delVac(User user, Vacancy vacancy) {
        user.getMyVacs().remove(vacancy.getVacId());
    }

    @Override
    public void newUser(User user) {
        this.insert(user, true);
        user.setUserId(this.idGetter.apply(user));
    }
}
