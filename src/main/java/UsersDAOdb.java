import java.sql.*;

/**
 * Created by Алена on 26.02.14.
 */
public class UsersDAOdb implements UsersDAO {
    public Connection con;
    private PreparedStatement stmt;


    @Override
    public boolean addUser(String login, String password) {
        try {
            stmt=con.prepareStatement("INSERT INTO users (login,password) VALUES (?,?)");
            stmt.setString(1,login);
            stmt.setString(2,password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public User checkUser(String login) throws SQLException {
        User u = null;
        stmt=con.prepareStatement("SELECT * FROM USERS WHERE LOGIN=?");
        stmt.setString(1,login);
        ResultSet res = stmt.executeQuery();
        while(res.next()) {
            if (res.getString("login").equals(login))
                u=new User(res.getString("login"),res.getString("password"));
        }
        return u;
    }

    @Override
    public boolean checkPassword(String login, String password) {
        return false;
    }
}
