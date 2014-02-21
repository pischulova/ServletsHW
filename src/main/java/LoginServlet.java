import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * Created by Алена on 21.02.14.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    Set<User> users = new HashSet<User>();

    @Override
    public void init() throws ServletException {
        users.add(new User("user1", "p1"));
        users.add(new User("user2", "p2"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Page2</title></head><body>");
        String tmpLog="";
        String tmpPas="";
        Boolean newUser = false;

        for(User u: users) {
            if(u.getLogin()!= request.getParameter("login")) {
                tmpLog = request.getParameter("login");
                tmpPas = request.getParameter("password");
                newUser = true;
            } else {
                if(u.getPassword()==request.getParameter("password")) {
                    out.print("Hello, "+ u.getLogin()+ "!");
                } else {
                    out.print("Access denied");
                }
            }
        }
        if(newUser=true) {
            users.add(new User(tmpLog, tmpPas));
        }
        out.print("</body></html>");
    }


}
