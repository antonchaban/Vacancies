package com.example.web;

import com.example.dao.DaoFactory;
import com.example.dao.impl.inmemory.InMemoryDatabase;
import com.example.dao.impl.inmemory.InMemoryTestData;
import com.example.models.User;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import com.example.service.VacancyService;
import com.example.service.VacancyServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.function.UnaryOperator;

@WebListener
public class ApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        InMemoryDatabase database = new InMemoryDatabase();
        InMemoryTestData.generateTo(database);
        DaoFactory daoFactory = database.getDaoFactory();

        VacancyService vacService = new VacancyServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("vacService", vacService);

        UserService userService = new UserServiceImpl(daoFactory, UnaryOperator.identity());
        sce.getServletContext().setAttribute("userService", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
