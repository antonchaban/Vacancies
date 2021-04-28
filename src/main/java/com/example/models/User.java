package com.example.models;

import java.util.HashMap;
import java.util.Objects;

public class User {
    private Integer userId;
    private String name;
    private String login;
    private String password;
    private HashMap<Integer, Vacancy> myVacs;

    public User(Integer userId, String name, String login, String password) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(Integer userId, String name, String login, String password, HashMap<Integer, Vacancy> myVacs) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.myVacs = myVacs;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<Integer, Vacancy> getMyVacs() {
        return myVacs;
    }

    public void setMyVacs(HashMap<Integer, Vacancy> myVacs) {
        this.myVacs = myVacs;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.userId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }
}
