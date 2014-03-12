import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Created by Алена on 21.02.14.
 */
public class OrderServlet extends javax.servlet.http.HttpServlet {
    User user;
    Order order;
    OrderDAO orderDAO = DAOFactory.getDAOFactory(1).getOrderDAO();

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

            String name = request.getParameter("name");
            String col = request.getParameter("color");
            if(name!=null && col!=null) {
                if(order==null) {
                    order = new Order();
                    orderDAO.addOrder(new Order(name, col));
                    user.addToOrder(order);
                } else {
                    orderDAO.addOrder(new Order(name, col));
                    user.addToOrder(order);
                }
            }

            out.print("<H2>Your previous orders:</H2>");

            Collection<Order> orders = user.getOrders();
            if(orders==null) {
                out.print("You have not made any orders yet.");
            } else {
                out.print(user.getOrdersForWeb());
            }

            session.setAttribute("user", user);
            out.print("<H2>Make a new order</H2>");
            out.print("<form action=\"/order\" method=\"GET\"> Choose product:<input type=\"text\" name=\"name\"/><br/> Choose color:<input type=\"text\"" +
                    "name=\"color\"/><br/> <input type=\"submit\" name=\"Buy\" value=\"Buy!\"><br/></form>");

            out.print("<form action=\"/index.jsp\" method=\"POST\"><input type=\"submit\" name=\"logout\" value=\"Log out\"><br/></form>");

        } else {
            out.print("Access denied. You have to log in first");
        }
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
