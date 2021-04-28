package com.example.web;

import com.example.models.*;
import com.example.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "FrontController", urlPatterns = {"/do/*"})
public class FrontController extends HttpServlet {
    VacancyService vacService;
    UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        vacService = (VacancyService) config.getServletContext().getAttribute("vacService");
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            pathInfo = "/";
        }
        try {
            switch (pathInfo) {
                case "/login":
                    login(request, response);
                    break;
                case "/logout":
                    logout(request, response);
                    break;
                case "/main":
                    main(request, response);
                    break;
                case "/vacancy":
                    vacancy(request, response);
                    break;
                case "/vacedit":
                    vacedit(request, response);
                    break;
                case "/vacnew":
                    vacnew(request, response);
                    break;
                case "/vacdel":
                    vacdel(request, response);
                    break;
                case "/vacsave":
                    vacsave(request, response);
                    break;
                case "/vacupdate":
                    vacupdate(request, response);
                    break;
                case "/":
                case "/search":
                default:
                    main(request, response);
                    break;
            }
        } catch (RuntimeException ex) {
            error(request, response, "Oops, " + ex.getMessage());
        }

    }

    protected void vacsave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        Boolean highEducation = false;
        if (request.getParameter("highEducation") != null) {
            highEducation = true;
        }

        Vacancy vacancy = new Vacancy(user.getUserId(),request.getParameter("vacName"),request.getParameter("description"),
                new VacRequirements(Integer.parseInt(request.getParameter("exp")), highEducation));

        vacService.newVac(vacancy, user);
        response.sendRedirect("main");
    }

    protected void vacupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vacId = Integer.parseInt(request.getParameter("vacId"));
        Vacancy vacancy = vacService.getVacById(vacId);

        Boolean highEducation = false;
        if (request.getParameter("highEducation") != null) {
            highEducation = true;
        }

        vacancy.getRequirements().setHighEducation(highEducation);

        if (request.getParameter("exp") != null) {
            vacancy.getRequirements().setExperience(Integer.parseInt(request.getParameter("exp")));
        }


        if (request.getParameter("vacName") != null) {
            vacancy.setVacName(request.getParameter("vacName"));
        }

        if (request.getParameter("description") != null) {
            vacancy.setDescription(request.getParameter("description"));
        }


        vacService.updVac(vacancy);
        response.sendRedirect("main");
    }

    protected void vacnew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().getAttribute("user");
        request.getRequestDispatcher("/WEB-INF/jsp/vacnew.jsp").forward(request, response);

    }

    protected void vacdel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vacId = Integer.parseInt(request.getParameter("vacId"));
        Vacancy vacancy = vacService.getVacById(vacId);
        User user = (User) request.getSession().getAttribute("user");

        vacService.delVac(vacancy, user);
        response.sendRedirect("main");
    }

    protected void vacedit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vacId = Integer.parseInt(request.getParameter("vacId"));
        Vacancy vacancy = vacService.getVacById(vacId);
        request.setAttribute("vacancy", vacancy);
        request.getRequestDispatcher("/WEB-INF/jsp/vacedit.jsp").forward(request, response);
    }

    protected void vacancy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vacId = Integer.parseInt(request.getParameter("vacId"));
        Vacancy vacancy = vacService.getVacById(vacId);
        request.setAttribute("vacancy", vacancy);
        request.getRequestDispatcher("/WEB-INF/jsp/vacancy.jsp").forward(request, response);
    }

    protected void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("search");
        Collection<Vacancy> vacancies;
        if (searchText != null) {
            vacancies = vacService.searchByText(searchText);
        } else
            vacancies = vacService.getAllVacancies();
        request.setAttribute("vacancies", vacancies);
        request.setAttribute("text", searchText);
        request.getRequestDispatcher("/WEB-INF/jsp/vacancies.jsp").forward(request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();

        String login = request.getParameter("login");
        User user = userService.getByLogin(login);
        if (!userService.checkUser(login)) {
            error(request, response, "Sorry, user with login " + login + " not exists");
            return;
        }
        String password = request.getParameter("password");

        if (!userService.checkPass(user, password)) {
            error(request, response, "Sorry, wrong password");
            return;
        }

        request.getSession().setAttribute("user", user);
        response.sendRedirect(".");
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("vacancies", vacService.getAllVacancies());
        request.getSession().invalidate();
        response.sendRedirect(".");
    }

    protected void error(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
