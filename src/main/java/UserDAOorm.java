import entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by Алена on 11.03.14.
 */
public class UserDAOorm implements UserDAO{
    private EntityManager em;

    public UserDAOorm() {
        this.em = DerbySingleton.getEMS();
    }

    @Override
    public void addUser(Users users) {
        em.getTransaction().begin();
        em.persist(users);
        em.getTransaction().commit();
    }

    @Override
    public Users findUser(int id) {
        return em.find(Users.class, id);
    }

    @Override
    public Users findUser(String login) {
        Users u = null;
        try{
            Query query = em.createQuery("SELECT c FROM Users c WHERE login='"+login+"'");
        u = (Users)query.getSingleResult();}
        catch (NoResultException noResultException) {}
        finally {
            return u;
        }
    }

    @Override
    public void removeUser(Users users) {
        em.getTransaction().begin();
        em.remove(users);
        em.getTransaction().commit();
    }

    @Override
    public Users updateUser(Users users) {
        em.getTransaction().begin();
        em.merge(users);
        em.getTransaction().commit();
        return null;
    }
}

