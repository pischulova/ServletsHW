import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Алена on 21.02.14.
 */
public class OrderServlet extends javax.servlet.http.HttpServlet {
    User user;
    Order order=null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Orders</title></head><body>");
        HttpSession session = request.getSession();
        user = (User)session.getAttribute("user");
        out.print("Hello, "+ user.getLogin() + "</br>");
        out.print("<H2>Your previous orders:</H2>");

        order = user.getOrder();
        if(order==null) {
            out.print("You have not made any orders yet.");
        } else {
            out.print(user.getOrder().getDataForWeb());
        }

        out.print("<H2>Make a new order</H2>");
        out.print("<form action=\"\"> <input type=\"text\" name=\"Choose your car model:\"/><br/> <input type=\"password" +
                "name=\"Choose your car color\"/><br/> <input type=\"submit\" name=\"Buy!\"/><br/></form>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
