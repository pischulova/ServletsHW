import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Алена on 21.02.14.
 */
@Entity
public class User {
    @Id
    private String login;
    private String password;

    @OneToMany(mappedBy="user")
    private Collection <Order> orders;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    public void addToOrder (Order order) {
        orders.add(order);
    }

    public String getOrdersForWeb() {
        String s="";
        for(Order o: orders) {
            s += "<tr><td>"+ o.getId() +" </td><td>"+ o.getName() +" </td><td>"+ o.getColor()+" </td></tr></br>";
        }
        return s;
    }
}
