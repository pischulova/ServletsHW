import javax.persistence.EntityManager;

/**
 * Created by Алена on 11.03.14.
 */
public class UserDAOorm implements UserDAO{
    private EntityManager em;

    public UserDAOorm() {
        this.em = DerbySingleton.getEMS();
    }

    @Override
    public void addUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public User findUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void removeUser(User user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public User updateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        return null;
    }
}
