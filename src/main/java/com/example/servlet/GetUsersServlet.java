package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(AddUserServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Set<User> users = Warehouse.getInstance().getUsers();

        req.setAttribute("users", users);

        try {
            req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.info("Failed to forward Get request! " + e.getMessage());
        }

    }
}
