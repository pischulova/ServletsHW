import javax.persistence.*;

/**
 * Created by Алена on 11.03.14.
 */
public class DerbySingleton {
    private static DerbySingleton ourInstance = new DerbySingleton();

    private static final String UNIT_NAME = "Unit";
    private static EntityManagerFactory factory;
    private static EntityManager em = null;

    public static EntityManager getEMS() {
        if(em!=null) {
            return em;
        } else {
            factory = Persistence.createEntityManagerFactory(UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            return em;
        }
    }
}
