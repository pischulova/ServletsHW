/**
 * Created by Алена on 21.02.14.
 */
public class User {
    private String login;
    private String password;
    Order order;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Order getOrder() { return order; }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
