package com.myshop.servlet;

import com.myshop.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

/**
 * Created by Алена on 21.02.14.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    //Set<com.myshop.entity.Users> users = new HashSet<com.myshop.entity.Users>();
    UserDAO userDAO = DAOFactory.getDAOFactory(1).getUserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Page2</title></head><body>");
        Users tmpUser = null;
        HttpSession session;

        tmpUser = userDAO.findUser(request.getParameter("login"));
        if(tmpUser!= null) {
            if((tmpUser.getPassword()).equals(request.getParameter("password"))) {
                session= request.getSession(true);
                session.setAttribute("users", tmpUser);
                response.sendRedirect("http://localhost:8080/orders");
            } else {
                out.print("Access denied :(");
            }

        } else {
            tmpUser = new Users(request.getParameter("login"), request.getParameter("password"));
            userDAO.addUser(tmpUser);
            session= request.getSession(true);
            session.setAttribute("users", tmpUser);
            response.sendRedirect("http://localhost:8080/orders");
        }

        out.print("</body></html>");
    }

}
