package com.userMgr.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.userMgr.model.Users;
import com.userMgr.services.UserDataProcessor;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdentifier = request.getParameter("userIdentifier");
        String password = request.getParameter("password");
        
        UserDataProcessor processor = new UserDataProcessor();
        
        System.out.println("User Identifier: " + userIdentifier);
        System.out.println("Password: " + password);
        
        Users Users = processor.authenticateUser(userIdentifier, password);
        
        System.out.println("User: " + Users);
        
        
        if (Users != null) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("Users", Users);
            session.setAttribute("loginTime", new java.util.Date());
            
            response.sendRedirect("profile.jsp");
        } else {
            // Failed login
            request.setAttribute("error", "Invalid username/email or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
