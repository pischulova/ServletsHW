package com.myshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Алена on 21.02.14.
 */
@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(unique = true)
    private String login;
    private String password;

    @OneToMany(mappedBy="users", fetch = FetchType.EAGER)
    private Collection <Orders> ordersList= new ArrayList<Orders>();

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Users() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(Collection<Orders> orders) {
        this.ordersList = orders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void addToOrder (Orders orders) {
        this.ordersList.add(orders);
    }

    public String getOrdersForWeb() {
        String s="";
        for(Orders o: ordersList) {
            s += "<tr><td>"+ o.getId() +" </td><td>"+ o.getName() +" </td><td>"+ o.getColor()+" </td></tr></br>";
        }
        return s;
    }
}
