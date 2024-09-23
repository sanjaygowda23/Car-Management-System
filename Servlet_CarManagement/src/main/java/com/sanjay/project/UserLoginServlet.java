package com.sanjay.project;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = null;
        try {
            user = userDAO.authenticate(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("Profile.jsp");
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
