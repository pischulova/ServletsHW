package com.myshop.dao;
import com.myshop.entity.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Алена on 21.03.14.
 */
@Repository
public class UsersDao {
    @PersistenceContext
    private EntityManager em;

    public void saveUsers(Users users){
        em.persist(users);
    }

    public Users findById(int id) {
        return (Users)em.createQuery("SELECT u from Users u WHERE u.userId=:i").setParameter("i", id).getSingleResult();
    }

    public Users findByLogin(String login) {
        return (Users)em.createQuery("SELECT u FROM Users u WHERE u.login=:l").setParameter("l", login).getSingleResult();
    }

    public List<Users> findAll() {
        return (List<Users>)em.createQuery("SELECT u from Users u").getResultList();
    }

    public void removeUsers(Users user) {
        em.remove(user);
    }

    public void updateUsers(Users user) {
        em.merge(user);
    }
}