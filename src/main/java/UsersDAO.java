import java.sql.SQLException;

/**
 * Created by Алена on 26.02.14.
 */
public interface UsersDAO {

    public boolean addUser(String login, String password) throws SQLException;
    public User checkUser(String login) throws SQLException;
    public boolean checkPassword(String login, String password);

}
