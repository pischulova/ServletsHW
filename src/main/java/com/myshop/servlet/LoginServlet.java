package com.myshop.servlet;

import com.myshop.entity.Users;
import com.myshop.service.OrdersService;
import com.myshop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

/**
 * Created by Алена on 21.02.14.
 */
@Configuration
public class LoginServlet extends HttpServlet {

    @Autowired
    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Page2</title></head><body>");
        Users tmpUser = null;
        HttpSession session;

        tmpUser = usersService.findByLogin(request.getParameter("login"));
        if(tmpUser!= null) {
            if((tmpUser.getPassword()).equals(request.getParameter("password"))) {
                session= request.getSession(true);
                session.setAttribute("users", tmpUser);
                response.sendRedirect("http://localhost:8080/orders");
            } else {
                out.print("Access denied :(");
            }

        } else {
            String login = request.getParameter("login");
            String pass = request.getParameter("password");
            tmpUser = new Users(login, pass);
            usersService.saveUsers(login, pass);
            session= request.getSession(true);
            session.setAttribute("users", tmpUser);
            response.sendRedirect("http://localhost:8080/orders");
        }
        out.print("</body></html>");
    }
}
