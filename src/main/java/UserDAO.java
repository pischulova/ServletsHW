/**
 * Created by Алена on 11.03.14.
 */
public interface UserDAO {

    public void addUser(User user);
    public User findUser(int id);
    public User findUser(String login);
    public void removeUser(User user);
    public User updateUser(User user);

}