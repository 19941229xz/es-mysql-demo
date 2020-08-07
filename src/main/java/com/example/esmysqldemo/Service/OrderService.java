package com.example.esmysqldemo.Service;

import com.example.esmysqldemo.model.Order;

import java.util.List;

public interface OrderService {



    public boolean addOrder(Order order);


    public List<Order> searchOrder(Order order);


}
