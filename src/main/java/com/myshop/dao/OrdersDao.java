package com.myshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import com.myshop.entity.Orders;
import org.springframework.stereotype.Repository;

/**
 * Created by Алена on 19.03.14.
 */
@Repository
public class OrdersDao {
    @PersistenceContext
    private EntityManager em;

    public void saveOrders(Orders order){
        em.persist(order);
    }

    public Orders findById(int id) {
        return (Orders)em.createQuery("SELECT o from Orders o WHERE o.id=:num").setParameter("num", id).getSingleResult();
    }

    public List<Orders> findAll() {
        return (List<Orders>)em.createQuery("SELECT o from Orders o").getResultList();
    }

    public void updateOrders(Orders order) {
        em.merge(order);
    }

    public void removeOrder(Orders order) {
        em.remove(order);
    }
}