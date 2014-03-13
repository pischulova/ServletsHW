import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Created by Алена on 21.02.14.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    //Set<User> users = new HashSet<User>();
    UserDAO userDAO = DAOFactory.getDAOFactory(1).getUserDAO();

    @Override
    public void init() throws ServletException {

//        users.add(new User("user1", "p1"));
//        users.add(new User("user2", "p2"));
//        users.add(new User("user3", "p3"));
//        userDAO.addUser(new User("user1", "p1"));
//        userDAO.addUser(new User("user2", "p2"));
//        userDAO.addUser(new User("user3", "p3"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Page2</title></head><body>");
        User tmpUser = null;
        HttpSession session;

        tmpUser = userDAO.findUser(request.getParameter("login"));
        if(tmpUser!= null) {
            if((tmpUser.getPassword()).equals(request.getParameter("password"))) {
                session= request.getSession(true);
                session.setAttribute("user", tmpUser);
                response.sendRedirect("http://localhost:8080/order");
            } else {
                out.print("Access denied :(");
            }

        } else {
            tmpUser = new User(request.getParameter("login"), request.getParameter("password"));
            userDAO.addUser(tmpUser);
            session= request.getSession(true);
            session.setAttribute("user", tmpUser);
            response.sendRedirect("http://localhost:8080/order");
        }

        out.print("</body></html>");
    }

}
