package com.example.esmysqldemo.web;

import com.example.esmysqldemo.Service.OrderServiceImpl;
import com.example.esmysqldemo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;


    // 创建两个接口  一个是添加订单  一个是查询订单
    @PostMapping("/addOrder")
    public Object addOrder(@RequestBody Order order){

        return orderService.addOrder(order);

    }

    @PostMapping("/searchOrder")
    public Object searchOrder(@RequestBody Order order){

        return orderService.searchOrder(order);
    }





}
