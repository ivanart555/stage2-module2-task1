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

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");

        Set<User> users = Warehouse.getInstance().getUsers();

        req.setAttribute("users", users);

        req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);

    }
}
