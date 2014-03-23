import com.myshop.entity.Orders;

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
    public void addOrder(Orders orders) {
        em.getTransaction().begin();
        em.persist(orders);
        em.getTransaction().commit();
    }

    @Override
    public Orders findOrder(int id) {
        return em.find(Orders.class, id);
    }

    @Override
    public void removeOrder(Orders orders) {
        em.getTransaction().begin();
        em.remove(orders);
        em.getTransaction().commit();
    }

    @Override
    public Orders updateOrder(Orders orders) {
        em.getTransaction().begin();
        em.merge(orders);
        em.getTransaction().commit();
        return null;
    }
}
