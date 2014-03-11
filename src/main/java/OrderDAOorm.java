import javax.persistence.EntityManager;

/**
 * Created by Алена on 11.03.14.
 */
public class OrderDAOorm implements OrderDAO{
    private EntityManager em;

    public OrderDAOorm() {
        this.em = DerbySingleton.getEMS();
    }

    @Override
    public void addOrder(Order order) {
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
    }

    @Override
    public Order findOrder(int id) {
        return em.find(Order.class, id);
    }

    @Override
    public void removeOrder(Order order) {
        em.getTransaction().begin();
        em.remove(order);
        em.getTransaction().commit();
    }

    @Override
    public Order updateOrder(Order order) {
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
        return null;
    }
}
