package com.example.esmysqldemo.Service;

import com.example.esmysqldemo.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderEsService orderEsService;

    @Autowired
    OrderMybatisServiceImpl orderMybatisService;

    @Autowired
    RabbitTemplate rabbitTemplate;


    @Override
    public boolean addOrder(Order order) {
        //给订单添加uuid主键
        order.setId(UUID.randomUUID().toString()
                .replaceAll("-",""));

        //先写入到mysql 成功以后 给mq发送消息
        int i = orderMybatisService.addOrder(order);
        if(i==1){
            //如果添加成功 我就给mq发送一条消息 “订单添加消息”
            // 消息格式 "主键-操作类型" 比如："123123-insert"
            rabbitTemplate.convertAndSend("es.mysql.copy.data"
                    ,order.getId()+"-insert");
        }

        return i==1;
    }

    @Override
    public List<Order> searchOrder(Order order) {

        List<Order> list = new ArrayList<Order>();

        Iterable<Order> orders = orderEsService.findAll();

        orders.forEach(temp->{
            list.add(temp);
                }
        );


        return list;
    }
}
