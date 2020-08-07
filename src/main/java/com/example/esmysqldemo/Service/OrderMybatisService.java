package com.example.esmysqldemo.Service;

import com.example.esmysqldemo.model.Order;

public interface OrderMybatisService {

    public int addOrder(Order order);

    public Order getOrderById(String id);

}
