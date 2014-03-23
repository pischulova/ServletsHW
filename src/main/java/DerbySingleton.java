import javax.persistence.*;
import java.sql.*;

/**
 * Created by Алена on 11.03.14.
 */
public class DerbySingleton {
    private static DerbySingleton ourInstance = new DerbySingleton();
    private static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
//    private static final String DB_URL="jdbc:derby:C:\\com.myshop.entity.Users\\Алена\\IdeaProjects\\ServletsHW\\db";

    private static final String UNIT_NAME = "Unit";
    private static EntityManagerFactory factory;
    private static EntityManager em = null;


    public static EntityManager getEMS() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(em!=null) {
            return em;
        } else {
            factory = Persistence.createEntityManagerFactory(UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            return em;
        }
    }
}
