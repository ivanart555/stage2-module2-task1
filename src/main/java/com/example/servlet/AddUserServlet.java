package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(AddUserServlet.class.getName());
    private final String JSP_ADD = "/jsp/add.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher(JSP_ADD).forward(req, resp);
        } catch (ServletException | IOException e) {
            log.info("Failed to forward Get request! " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        if (!firstName.isEmpty() && !lastName.isEmpty()) {
            User user = new User(firstName, lastName);
            Warehouse.getInstance().addUser(user);
            req.setAttribute("user", user);

            try {
                req.getRequestDispatcher(JSP_ADD).forward(req, resp);
            } catch (ServletException | IOException e) {
                log.info("Failed to forward Post request! " + e.getMessage());
            }
        }
    }
}
