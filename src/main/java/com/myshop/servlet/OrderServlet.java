package com.myshop.servlet;

import com.myshop.entity.Orders;
import com.myshop.entity.Users;
import com.myshop.service.OrdersService;
import com.myshop.service.UsersService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Created by Алена on 21.02.14.
 */
@Configuration
public class OrderServlet extends HttpServlet {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UsersService usersService;

    Users users=null;
    Orders orders=null;

    @Override
    public void init() throws ServletException {
        //orders = new Orders();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        if(session.getAttribute("users")!= null) {
            out.print("<html><head><title>com.myshop.entity.Orders</title></head><body>");
            users = (Users)session.getAttribute("users");
            out.print("Hello, "+ users.getLogin() + "!</br>");

            String name = request.getParameter("name");
            String col = request.getParameter("color");
            if(name!=null && col!=null) {
                orders = new Orders(name, col);
                users.addToOrder(orders);
                orders.setUsers(users);
                usersService.updateUsers(users);
                ordersService.saveOrders(orders);

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

            out.print("<form action=\"/index.html\" method=\"POST\"><input type=\"submit\" name=\"logout\" value=\"Log out\"><br/></form>");
            session.setAttribute("user", users);
        } else {
            out.print("Access denied. You have to log in first");

        }
        out.print("</body></html>");
    }

}
