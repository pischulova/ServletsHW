import com.myshop.entity.Users;

/**
 * Created by Алена on 11.03.14.
 */
public interface UserDAO {

    public void addUser(Users users);
    public Users findUser(int id);
    public Users findUser(String login);
    public void removeUser(Users users);
    public Users updateUser(Users users);

}