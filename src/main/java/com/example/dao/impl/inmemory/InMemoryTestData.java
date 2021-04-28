package com.example.dao.impl.inmemory;

import com.example.models.*;

import java.util.Arrays;
import java.util.List;

public class InMemoryTestData {

    public static void generateTo(InMemoryDatabase database) {
        database.users.clear();
        database.vacancies.clear();

        User admin = new User(1, "admin", "admin@gmail.com", "admin");
        User alice = new User(2, "Alice", "alice@example.com", "passwordhash");
        User bob = new User(3, "Bob", "bob@example.com", "passwordhash");
        User charlie = new User(4, "Charlie", "charlie@example.com", "passwordhash");
        User diana = new User(5, "Diana", "diana@example.com", "passwordhash");
        List<User> users = Arrays.asList(admin, alice, bob, charlie, diana);
        users.forEach(user -> database.users.put(user.getUserId(), user));

        String desc1 = "Join us in shaping no code computing. At JourneyXP we develop a no code computing platform, JXP Cloud, that simplifies how software is build, operated, and scaled.";
        Vacancy vac1 = new Vacancy(1, admin.getUserId(), "Junior Java Developer", desc1, new VacRequirements(2, false));

        String desc2 = "One of the world's largest oil field service companies has a need to build a modern solutions that improve efﬁciency, increase recovery and maximize production.This is a position for those interested in working with the latest Microsoft modern technology with the user in focus.";
        Vacancy vac2 = new Vacancy(2, alice.getUserId(), "Intern C# Developer", desc2, new VacRequirements(0, true));

        String desc3 = "Luxoft team is developing a family of condition-based and predictive health management products that uses various online and offline data sources to provide preventive intervention recommendations based on grid asset condition, probability of failure, criticality and risk assessments. Data lake collects telemetrics data, makes clearance, manages archives. Rich UI to visualize results of analysis and diagnostics, prognostics, including 3D representation, builds prognosis on assets health and performance. Offline data is gathered via hybrid mobile application and through external connectors.\n" +
                "We are working with BigData scale and using latest technologies like Java 11, SpringBoot 2, Spring Clould, Kafka, Ignite, Cassandra, PostgreSQL, Jupyter, Docker and Kubernetes, AWS, Angular 10.\n" +
                "Our team is distributed between Ukraine and France (client).\n" +
                "Opportunities: study cutting-edge technologies and participate in multi-year project for one of the biggest companies in the World, contribute to the platform that will change work experience and results of energy grid engineers across the globe.";

        Vacancy vac3 = new Vacancy(3, bob.getUserId(), "Java Intern", desc3, new VacRequirements(0, false));

        String desc4 = "Our client is an American multinational corporation, one of the world's largest providers of products and services that make the oil and gas production possible.\n" +
                "Our Products are two scientifically grounded applications (Desktop and Web) aimed to Design, Optimize and Monitor specific processes in field, simulate or calculate various operations, view and evaluate real-time data acquisition, execute various file imports, reporting and integrations with multiple other software products.";

        Vacancy vac4 = new Vacancy(4, charlie.getUserId(), "Manual QA Intern", desc4, new VacRequirements(0, false));

        String desc5 = "At Very Good Security (“VGS”) we are on a mission to protect the world’s sensitive data - and we’d love to have you along for this journey.\n" +
                "\n" +
                "VGS was founded by highly successful repeat entrepreneurs, and is backed by world-class investors like Goldman Sachs, Andreessen Horowitz, and Visa. We are building an amazing global team spread across four cities. As a young and growing company, we are laser-focused on delighting our customers and hiring talented and entrepreneurial-minded individuals.";

        Vacancy vac5 = new Vacancy(5, diana.getUserId(), "Senior Software Engineer", desc5, new VacRequirements(5, true));

        List<Vacancy> vacancies = Arrays.asList(vac1, vac2, vac3, vac4, vac5);
        vacancies.forEach(vacancy -> database.vacancies.put(vacancy.getVacId(), vacancy));
        for (User user : users) {
            user.setMyVacs(database.getDaoFactory().getVacancyDao().findByUserID(user.getUserId()));
        }


    }

}
