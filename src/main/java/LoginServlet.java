import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Created by Алена on 21.02.14.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    Set<User> users = new HashSet<User>();

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Page2</title></head><body>");
        Boolean userFound = false;
        User tmpUser = new User("", "");


        for(User u: users) {
            if((u.getLogin()).equals(request.getParameter("login"))) {
                tmpUser = u;
                userFound = true;
                break;
            }
        }

        if(userFound) {
            if((tmpUser.getPassword()).equals(request.getParameter("password"))) {
                out.print("Hello, "+ tmpUser.getLogin()+ "!</br>");
            } else {
                out.print("Access denied</br>");
            }

        } else {
            users.add(new User(request.getParameter("login"), request.getParameter("password")));
            out.print("Welcome to our site, "+ request.getParameter("login") + "!</br>");
        }
        out.print("</body></html>");
        response.sendRedirect("http://localhost:8080/order");

    }
}
