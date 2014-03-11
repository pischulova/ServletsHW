/**
 * Created by Алена on 11.03.14.
 */
public abstract class DAOFactory {
    public static final int DERBY = 1;

    public abstract OrderDAO getOrderDAO();
    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory (int factoryType) {
        switch (factoryType) {
            case DERBY:
                return new DerbyDAOFactory();
            default:
                return null;
        }
    }



}

