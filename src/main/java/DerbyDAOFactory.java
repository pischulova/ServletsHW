/**
 * Created by Алена on 11.03.14.
 */
public class DerbyDAOFactory extends DAOFactory {
    public DerbyDAOFactory() {

    }

    @Override
    public OrderDAO getOrderDAO() {
        return new OrderDAOorm();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOorm();
    }
}