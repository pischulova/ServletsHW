package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import entity.Orders;
import org.springframework.stereotype.Repository;

/**
 * Created by Алена on 19.03.14.
 */
@Repository
public class OrdersDao {
    @PersistenceContext
    private EntityManager em;

    public void saveOrders(Orders orders){
        em.persist(orders);
    }

    public Orders findById(int id) {
        return (Orders)em.createQuery("SELECT o from Orders o WHERE o.id=:num").setParameter("num", id).getSingleResult();
    }

    public List<Orders> findAll() {
        return (List<Orders>)em.createQuery("SELECT o from Orders o").getResultList();
    }
}