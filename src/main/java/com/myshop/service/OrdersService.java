package com.myshop.service;

import com.myshop.dao.OrdersDao;
import com.myshop.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Алена on 23.03.14.
 */
@Service
public class OrdersService {
    @Autowired
    private OrdersDao ordersDao;


    @Transactional
    public void saveOrders(String name, String color){
        Orders orders = new Orders();
        orders.setName(name);
        orders.setColor(color);
        ordersDao.saveOrders(orders);
    }

    @Transactional
    public Orders findById(int id) {
        return ordersDao.findById(id);
    }

    @Transactional
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    @Transactional
    public void updateOrders(Orders orders) {
        ordersDao.updateOrders(orders);
    }

    @Transactional
    public void removeOrders(Orders orders) {
        ordersDao.removeOrder(orders);
    }
}