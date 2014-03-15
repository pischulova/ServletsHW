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
    Users users;
    Orders orders;
    OrderDAO orderDAO = DAOFactory.getDAOFactory(1).getOrderDAO();

    @Override
    public void init() throws ServletException {
        orders = new Orders();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        if(session.getAttribute("users")!= null) {
            out.print("<html><head><title>Orders</title></head><body>");
            users = (Users)session.getAttribute("users");
            out.print("Hello, "+ users.getLogin() + "!</br>");

            String name = request.getParameter("name");
            String col = request.getParameter("color");
            if(name!=null && col!=null) {
                orders = new Orders(name, col);
                users.addToOrder(orders);
                orders.setUsers(users);
                orderDAO.addOrder(orders);
            }

            out.print("<H2>Your previous orders:</H2>");

            Collection<Orders> ordersList = users.getOrdersList();
            if(ordersList.size()==0) {
                out.print("You have not made any orders yet.");
            } else {
                out.print("<table>"+users.getOrdersForWeb()+"</table>");
            }

            session.setAttribute("users", users);
            out.print("<H2>Make new orders</H2>");
            out.print("<form action=\"/orders\" method=\"GET\"> Choose product:<input type=\"text\" name=\"name\"/><br/> " +
                    "Choose color:<input type=\"text\"" +
                    "name=\"color\"/><br/> <input type=\"submit\" name=\"Buy\" value=\"Buy!\"><br/></form>");

            out.print("<form action=\"/index.jsp\" method=\"POST\"><input type=\"submit\" name=\"logout\" value=\"Log out\"><br/></form>");
            session.setAttribute("user", users);
        } else {
            out.print("Access denied. You have to log in first");

        }
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
