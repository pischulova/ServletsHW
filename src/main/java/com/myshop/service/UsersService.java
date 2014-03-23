package com.myshop.service;

import com.myshop.dao.OrdersDao;
import com.myshop.dao.UsersDao;
import com.myshop.entity.Orders;
import com.myshop.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Алена on 23.03.14.
 */
@Service
public class UsersService {
    @Autowired
    private UsersDao usersDao;


    @Transactional
    public void saveUsers(String login, String password){
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);
        usersDao.saveUsers(user);
    }

    @Transactional
    public Users findById(int id) {
        return usersDao.findById(id);
    }

    @Transactional
    public Users findByLogin(String login) {
        return usersDao.findByLogin(login);
    }

    @Transactional
    public List<Users> findAll() {
        return usersDao.findAll();
    }

    @Transactional
    public void updateUsers(Users user) {
        usersDao.updateUsers(user);
    }

    @Transactional
    public void removeOrders(Users user) {
        usersDao.removeUsers(user);
    }
}