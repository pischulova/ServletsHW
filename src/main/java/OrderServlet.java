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
    Order order;

    @Override
    public void init() throws ServletException {
        order = new Order();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        if(session.getAttribute("user")!= null) {
            out.print("<html><head><title>Orders</title></head><body>");
            user = (User)session.getAttribute("user");
            out.print("Hello, "+ user.getLogin() + "!</br>");

            String mod = request.getParameter("model");
            String col = request.getParameter("color");
            if(mod!=null && col!=null) {
                if(order==null) {
                    order = new Order();
                    order.addToOrder(new Car(mod, col));
                    user.setOrder(order);
                } else {
                    order.addToOrder(new Car(mod, col));
                    user.setOrder(order);
                }

            }

            out.print("<H2>Your previous orders:</H2>");

            order = user.getOrder();
            if(order==null) {
                out.print("You have not made any orders yet.");
            } else {
                out.print(user.getOrder().getDataForWeb());
            }

            session.setAttribute("user", user);
            out.print("<H2>Make a new order</H2>");
            out.print("<form action=\"/order\" method=\"GET\"> Choose model:<input type=\"text\" name=\"model\"/><br/> Choose color:<input type=\"text\"" +
                    "name=\"color\"/><br/> <input type=\"submit\" name=\"Buy\" value=\"Buy!\"><br/></form>");

            out.print("<form action=\"/index.jsp\" method=\"POST\"><input type=\"submit\" name=\"logout\" value=\"Log out\"><br/></form>");

        } else {
            out.print("Access denied. Log in first");
        }
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
