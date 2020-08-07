package com.example.esmysqldemo.Service;

import com.example.esmysqldemo.dao.OrderDao;
import com.example.esmysqldemo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMybatisServiceImpl implements OrderMybatisService {

    @Autowired
    OrderDao orderDao;

    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public Order getOrderById(String id) {
        return orderDao.getOrderById(id);
    }
}
